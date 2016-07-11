package cn.uuf.ltxxt.activity.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.activity.Activity;
import cn.uuf.domain.activity.ActivityApply;
import cn.uuf.ltxxt.activity.service.ActivityApplyService;
import cn.uuf.ltxxt.activity.service.ActivityService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.permission.service.AccountService;
import cn.uuf.util.Paginate;

/**
 * 活动发布
 * @author fc
 * @version 1.0
 * @date 2016-5-12 11:34:22
 */
@Controller
@RequestMapping("/activityReleas")
public class ActivityReleaseAction extends BaseController{
	
	private final String LIST_ACTION = "redirect:/activityReleas";
	
	@Autowired
	private ActivityService activityService;
	@Autowired
	private ActivityApplyService activityApplyService;
	
	@Resource
	private AccountService accountService;
	
	@RequestMapping
	public ModelAndView index(Integer page,Activity cp){
		ModelAndView mav = new ModelAndView("activ/activityAdd/index");
		try{
			//获取车辆申请信息分页list
			page = page == null || page < 0 ? 1 : page;
			int startnum =(page - 1) * size;
			List<Activity> list = activityService.queryList(cp, startnum, size);
			//获取车辆申请信息总数量
			Long count = activityService.getCount(cp);
			paginate = new Paginate(list,count,size,page);//获取页面page对象
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("cp", cp);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
		}
		return mav;
	}
	
	//删除车辆
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request,RedirectAttributes red,Long... id){
		try{
			activityService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
		}
	
	//跳转添加页面
	@RequestMapping("/create")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("activ/activityAdd/create");
		getCodeInf(mav);
		return mav;
	}
	
	//车辆sava方法
	@RequestMapping(value="/save")
	public ModelAndView save(HttpServletRequest request,String sfzh,@Valid Activity ci,BindingResult res,RedirectAttributes red){
		//添加车辆信息
		try{
			activityService.save(ci);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	
	//修改车辆信息
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("activ/activityAdd/update");
		try{
			//获取选择车辆申请信息
			mav.addObject("r",activityService.getById(id));
		}catch(Exception e){
		}
		return mav;
	}
	
	@RequestMapping(value="/update")
	public ModelAndView update(HttpServletRequest request,@Valid Activity ci,BindingResult res,RedirectAttributes red){
		try{
		/*	Activity carp=activityService.getById(ci.getId());*/
			activityService.update(ci);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	/**
	 * 查看活动详情
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView detail(Long id,RedirectAttributes redirectAttributes){
		ModelAndView mav = new ModelAndView("activ/activityAdd/detail");
		try{
			//获取分配活动信息
			mav.addObject("r",activityService.getById(id));
			//获取分配活动报名人员信息
			ActivityApply a =new ActivityApply();
			Activity ac =new Activity();
			ac.setId(id);
			a.setActivity(ac);
			List<ActivityApply> list =activityApplyService.queryByAid(a);
			/*for(int i=0;i<list.size();i++){
				String sid=list.get(i).getIdCard();
				Account account=accountService.queryByLoginName(sid);
				list.get(i).setAc(account);
			}*/
			mav.addObject("peo",list);
			if(list.size()==0){
				mav.addObject("nums","0");
			}else{
				mav.addObject("nums",list.size());
			}
		}catch(Exception e){
			e.printStackTrace();
			redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME,"未查询到活动信息");
			return new ModelAndView(LIST_ACTION);
		}
		return mav;
	}
	//分配
		@RequestMapping("/{id}/assign")
		public ModelAndView edit(@PathVariable Long id,Integer page){
			ModelAndView mav = new ModelAndView("activ/activityAdd/updateapply");
			try{
				//获取分配活动信息
				mav.addObject("r",activityService.getById(id));
				//获取分配活动报名人员信息
				page = page == null || page < 0 ? 1 : page;
				int startnum =(page - 1) * size;
				ActivityApply a =new ActivityApply();
				Activity ac =new Activity();
				ac.setId(id);
				a.setActivity(ac);
				List<ActivityApply> list =activityApplyService.queryList(a, startnum, size);
				mav.addObject("peo",list);
				if(list.size()==0){
					mav.addObject("nums","0");
				}else{
					mav.addObject("nums",list.size());
				}
			}catch(Exception e){
			}
			return mav;
		}
		@RequestMapping(value="/assinSuccess")
		public ModelAndView update(HttpServletRequest request,@Valid Activity ci,BindingResult res,RedirectAttributes red,Integer page){
			try{
				//获取分配活动报名人员信息
				page = page == null || page < 0 ? 1 : page;
				int startnum =(page - 1) * size;
				ActivityApply a =new ActivityApply();
				a.setActivity(ci);
				List<ActivityApply> list =activityApplyService.queryList(a, startnum, size);
				for(int i=1;i<=list.size();i++){
					list.get(i-1).setCarNumber("1");
					list.get(i-1).setSeatNumber(""+i);
					activityApplyService.update(list.get(i-1));
				}
				red.addFlashAttribute(Constants.MESSAGE_NAME,"座位分配成功");
			}catch(Exception e){
				e.printStackTrace();
				red.addFlashAttribute(Constants.MESSAGE_NAME,"座位分配失败");
			}
			return new ModelAndView(LIST_ACTION);
		}
}

