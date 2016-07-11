package cn.uuf.ltxxt.login.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.Role;
import cn.uuf.domain.cue.Retmarke;
import cn.uuf.domain.daily.Workdaily;
import cn.uuf.domain.message.Notice;
import cn.uuf.ltxxt.cue.service.RetmarkeService;
import cn.uuf.ltxxt.daily.service.WorkdailyService;
import cn.uuf.ltxxt.folder.service.FolderService;
import cn.uuf.ltxxt.login.util.TjUtil;
import cn.uuf.ltxxt.mess.service.NoticeService;
import cn.uuf.ltxxt.retire.service.RetirementService;
import cn.uuf.ltxxt.system.code.service.CodeDwbService;
import cn.uuf.ltxxt.system.permission.service.AccountService;
import cn.uuf.ltxxt.system.permission.service.UserService;
import cn.uuf.util.DateUtil;
import sun.launcher.resources.launcher;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date May 20, 2013
 */
@Controller
@RequestMapping("/{index:index;?.*}")
public class IndexController extends BaseController{

	@Autowired
	private AccountService accountService;
	@Resource
	private NoticeService nService;
	@Resource
	private FolderService fService;
	@Resource
	private WorkdailyService dService;
	@Resource
	private UserService uService;
	@Resource
	private CodeDwbService codeDwbService;
	@Resource
	private RetmarkeService mService;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat hhmm = new SimpleDateFormat("HH:mm");
	
	@Resource
	private RetirementService retirementService;
	/**
	 * 用户首页面
	 * @return
	 */
	@RequestMapping
	public ModelAndView home(){
		ModelAndView mav = new ModelAndView("auth/home");
		try{
			getInfo(mav);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	private void getInfo(ModelAndView mav){
		try{//通知公告
			Notice n = new Notice();
			List<Role> rs = this.getCurrentUser().getRoles();
			for(Role r : rs){
				if(!r.getName().contains("管理员"))
					n.setDwbs(uService.getById(this.getCurrentUser().getUsername()).getCodedwb().getId()+"");
			}
			mav.addObject("nlist",nService.queryList(n,0,5));
			//常用统计
			getTj(mav);
			//代办
			Workdaily w = new Workdaily();
			w.setSfwc(Constants.HASNO);
			w.setSfzh(this.getCurrentUser().getUsername());
			mav.addObject("marke",getMarke());//问候语
			mav.addObject("curd",dService.getCount(w,sdf.format(DateUtil.getTimesnightZero()),sdf.format(DateUtil.getTimesnightZero()),null,null));//取得当天代办数
			mav.addObject("curw",dService.getCount(w,sdf.format(DateUtil.getTimesWeekmorning()),sdf.format(DateUtil.getTimesWeeknight()),null,null));//取得一周代办数
			mav.addObject("curm",dService.getCount(w,sdf.format(DateUtil.getMonthFirstDay()),sdf.format(DateUtil.getMonthEndDay(new Date())),null,null));//取得一月代办数
			mav.addObject("flist", fService.queryByHql());//读取固化好的文件夹中的内容
			mav.addObject("u",uService.getById(this.getCurrentUser().getUsername()));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 常用统计
	 * @param mav
	 */
	private void getTj(ModelAndView mav){
		Map<String,List> maps = new LinkedHashMap<String,List>();
		try{
			Long dwbId = null;
			if(hasRoleScope().equals(Constants.INFOYX)){
				if(codeDwbService.getById(getUser().getCodedwb().getId()).getSfejdw().equals(Constants.HASYES)){
					dwbId = (getUser() != null ? getUser().getCodedwb().getId() : null);
				}
			}
			TjUtil t = new TjUtil(dwbId);
			String ages = "";
			if(dwbId!=null){
				String age = TjUtil.ages;
				List<String> list = new ArrayList<String>();
				String[] split = age.split("where");
				String string2 =" a.dwb_id="+"'"+dwbId+"'"+" and";
				list.add(0, split[0]);
				list.add(1," where");
				list.add(2,string2);
				list.add(3,split[1]);
				for(int i=0;i<list.size();i++){
					ages += list.get(i);
				}
			}else{
				ages = TjUtil.ages;
			}
			List list = mentService.queryBySql(ages);
			String[] s = {"60以下","60-69","70-79","80-89","90以上"};
			List res = new ArrayList();
			for(int i = 0;i<list.size();i++){
				Object[] o = (Object[]) list.get(i);
				for(int j=0;j<5;j++){
					Object[] ob = new Object[2];
					ob[0] = s[j];
					ob[1] = o[j];
					res.add(ob);
				}
			}
			long secount=res.size();
			for(Map.Entry<String,String> en : t.map.entrySet()){
				if(en.getKey().contains("年龄"))
					maps.put(en.getKey(), res);
				else
					maps.put(en.getKey(),mentService.queryBySql(en.getValue()));
			}
			mav.addObject("maps",maps);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 取得当前时间段的问候语，前提是已维护好的
	 * @return
	 */
	private Retmarke getMarke(){
		List<Retmarke> list = mService.getAll();
		Retmarke m = new Retmarke();
		long curren = System.currentTimeMillis();
		try{
			Date d = hhmm.parse(hhmm.format(new Date(curren)));
			for(Retmarke r : list){
				if(r.getKssj() != null && r.getJssj() != null){
					if(d.after(hhmm.parse(r.getKssj())) && d.before(hhmm.parse(r.getJssj()))){
						m = r;
						break;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return m;
	}
	
	/**
	 * 用户换肤
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody 
	@RequestMapping(value="/skin",method=RequestMethod.POST)
	public void exchangeSkin(HttpServletRequest request,HttpServletResponse response,String skin)throws Exception{
		Account account = this.getCurrentUser();
		account.setStyleColor(skin);
		accountService.update(account);
	}
	
	
}

