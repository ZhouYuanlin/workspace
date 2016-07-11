package cn.uuf.wechat.activity.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.uuf.domain.Account;
import cn.uuf.domain.activity.Activity;
import cn.uuf.domain.activity.ActivityApply;
import cn.uuf.domain.activity.Retireactivother;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.wechat.activity.service.ActivityApplyService;
import cn.uuf.wechat.activity.service.ActivityService;
import cn.uuf.wechat.activity.service.IActivityService;
import cn.uuf.wechat.common.controller.WxBaseController;
import cn.uuf.wechat.connect.service.ILtxAccountService;

@Controller
@RequestMapping(value="/wechat/activity")
public class ActivityController extends WxBaseController{
	
	@Resource(name="activityService")
	private IActivityService activityService;
	
	@Resource(name="activityApplyService")
	private ActivityApplyService activityApplyService;
	
	@Resource(name="activitysService")
	private ActivityService activitysService;
	
	/**
	 * ltx账号service
	 */
	@Resource
	private ILtxAccountService ltxAccountService;
	
	/**
	 * 查询出所有的活动  并将活动信息展示到页面
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Retireactivother activity,Pageable pageable,ModelMap model){
		
		//查询到所有的活动相关信息传入界面
		Page<Retireactivother> queryList = activityService.queryList(activity, pageable);
		model.put("page", queryList);
		return "/wechat/activity/index";
	}
	
	/**
	 * 实现报名,根据传递过来的活动id查询更新并返回
	 * @param id
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/apply",method=RequestMethod.POST)
	public @ResponseBody Object apply(Long id){
		Map<String, String> map = new HashMap<String,String>();
		try {
			//根据得到的传过来的活动id,查询获取到该活动下都有哪些人员报名
			Retireactivother retireactivother = activityService.get(id);
			//将当前登录人员的username(身份证号加入到该活动报名人员中)
			Account account = getCurrentAccount();
			if(StringUtils.isNotEmpty(retireactivother.getSfzhstr())){
				retireactivother.setSfzhstr(retireactivother.getSfzhstr()+","+account.getUsername());
			}else{
				retireactivother.setSfzhstr(account.getUsername());
			}
			if(StringUtils.isNotEmpty(retireactivother.getCyrys())){
				retireactivother.setCyrys(retireactivother.getCyrys()+";"+account.getRealname());
			}else{
				retireactivother.setCyrys(account.getRealname());
			}
			activityService.update(retireactivother);
			map.put("result", "10001");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "10002");
			return map;
		}
	}
	
	/**
	 *  实现报名取消,根据传递过来的活动id进行查询更新并返回界面
	 * @param id
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/cancelApply",method=RequestMethod.POST)
	public @ResponseBody Object cancelApply(Long id){
		Map<String, String> map = new HashMap<String,String>();
		try {
			//根据得到的传过来的活动id,查询获取到该活动下都有哪些人员报名
			Retireactivother retireactivother = activityService.get(id);
			//将当前登录人员的username(身份证号加入到该活动报名人员中)
			Account account = getCurrentAccount();
			//获取到已报名人根据 (,) 切分,将其删除
			String[] bmyh = retireactivother.getSfzhstr().split(",");
			String[] cyry = retireactivother.getCyrys().split(";");
			List<String> list = Arrays.asList(bmyh);
			List<String> list1 = Arrays.asList(cyry);
			List<String> listadd = new ArrayList<String>();
			List<String> listaddcyry = new ArrayList<String>();
			for (String name : list) {
				listadd.add(name);
			}
			for (String name : list1) {
				listaddcyry.add(name);
			}
			listadd.remove(account.getUsername());
			listaddcyry.remove(account.getRealname());
			if(listadd.size()>0 || listaddcyry.size()>0){
				if(listadd.size()>0){
					Object[] array = listadd.toArray();
					String join = StringUtils.join(array, ",");
					retireactivother.setSfzhstr(join);
					activityService.update(retireactivother);
				}
				if(listaddcyry.size()>0){
					Object[] array = listaddcyry.toArray();
					String join = StringUtils.join(array, ";");
					retireactivother.setSfzhstr(join);
					activityService.update(retireactivother);
				}
			}else{
				retireactivother.setSfzhstr(null);
				retireactivother.setCyrys(null);
				activityService.update(retireactivother);
			}
			map.put("result", "10001");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "10002");
			return map;
		}
	}
	
	/**
	 * 查看活动详情
	 * @param id
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/showDetail")
	public String showDetail(Long id,ModelMap model){
		Retireactivother retireactivother = activityService.get(id);
		Account account = getCurrentAccount();
		model.put("username", account.getUsername());
		model.put("activ", retireactivother);
		return "/wechat/activity/detail";
	}
	
	/**
	 * 查询出所有的活动  并将活动信息展示到页面
	 * @param openId
	 * @param model
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/showActivitys")
	public String showActivity(Pageable pageable,ModelMap model) throws ParseException{
		//查询到所有的活动相关信息传入界面
		List<Activity> queryList = activitysService.getAll();
		List<Activity> queryLists = new ArrayList<Activity>();
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date);
		Date nowdate=format.parse(time);
		for(int i=0;i<queryList.size();i++){
			Date enddate=format.parse(queryList.get(i).getAddEndTime());
			if(nowdate.before(enddate)){
				queryLists.add(queryList.get(i));
			}
		}
		model.put("page", queryLists);
		return "/wechat/activityAdd/index";
	}
	
	/**
	 * 查看活动详情
	 * @param id
	 * @param openId
	 * @param model
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/showActivityOne")
	public String showActivity(Long id,ModelMap model) throws ParseException{
		Activity retireactivother = activitysService.get(id);
		ActivityApply activityApply = new ActivityApply();
		Activity ac = new Activity();
		ac.setId(id);
		activityApply.setState("1");
		activityApply.setActivity(ac);
		List<ActivityApply> list = activityApplyService.queryList(activityApply);
		//获取当用户姓名,查看对应日志
		Account account = getCurrentAccount();
		activityApply.setIdCard(account.getUsername());
		List<ActivityApply> lists = activityApplyService.queryList(activityApply);
		ActivityApply aca = new ActivityApply();
		if(lists.size()>0){
			aca = lists.get(0);
		}
		if(lists.size()>0){
			model.put("state", aca.getState());
		}else{
			model.put("state", "0");
		}
		List<String> listTime = activityApplyService.getTimes(retireactivother.getStartTime(), retireactivother.getEndTime());
		model.put("listTime", listTime);
		model.put("addNum", list.size());
		model.put("activ", retireactivother);
		model.put("aca", aca);
		return "/wechat/activityAdd/detail";
	}
	
	
	/**
	 * 实现报名,根据传递过来的活动id查询更新并返回
	 * @param id
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/applys",method=RequestMethod.POST)
	public @ResponseBody Object applys(Long id,String comeTime,String entryMode){
		Map<String, String> map = new HashMap<String,String>();
		try {
			ActivityApply activityApply = new ActivityApply();
			ActivityApply aca = new ActivityApply();
			Activity ac = new Activity();
			ac.setId(id);
			activityApply.setActivity(ac);
			Account account = getCurrentAccount();
			activityApply.setIdCard(account.getUsername());
			List<ActivityApply> list = activityApplyService.queryList(activityApply);
			if(list.size()>0){
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				String time=format.format(date);
				aca.setEntryMode("微信");
				aca.setEnrollTime(time);
				aca=list.get(0);
				aca.setComeTime(comeTime);
				aca.setEntryMode(entryMode);
				aca.setState("1");
				activityApplyService.update(aca);
			}else{
				Date date=new Date();
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				String time=format.format(date);
				activityApply.setEntryMode("微信");
				activityApply.setEnrollTime(time);
				activityApply.setComeTime(comeTime);
				activityApply.setEntryMode(entryMode);
				activityApply.setState("1");
				activityApplyService.save(activityApply);
			}
			map.put("result", "10001");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "10002");
			return map;
		}
	}
	
	
	
	
	/**
	 *  实现报名取消,根据传递过来的活动id进行查询更新并返回界面
	 * @param id
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/cancelApplys",method=RequestMethod.POST)
	public @ResponseBody Object cancelApplys(Long id){
		Map<String, String> map = new HashMap<String,String>();
		try {
			ActivityApply activityApply = new ActivityApply();
			ActivityApply aca = new ActivityApply();
			Activity ac = new Activity();
			ac.setId(id);
			Account account = getCurrentAccount();
			activityApply.setIdCard(account.getUsername());
			activityApply.setActivity(ac);
			List<ActivityApply> list = activityApplyService.queryList(activityApply);
			aca = list.get(0);
			aca.setState("0");
			activityApplyService.update(aca);
			map.put("result", "10001");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "10002");
			return map;
		}
	}
}
