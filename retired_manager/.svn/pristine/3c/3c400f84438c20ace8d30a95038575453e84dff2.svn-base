package cn.uuf.ltxxt.activity.controller;

import java.util.List;

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
import cn.uuf.domain.activity.Activity;
import cn.uuf.domain.activity.ActivityApply;
import cn.uuf.ltxxt.activity.service.ActivityApplyService;
import cn.uuf.ltxxt.activity.service.ActivityService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.Paginate;

/**
 * 活动发布
 * @author fc
 * @version 1.0
 * @date 2016-5-12 11:34:22
 */
@Controller
@RequestMapping("/activityDistribution")
public class ActivityDistributionAction extends BaseController{
	
	private final String LIST_ACTION = "redirect:/activityDistribution";
	
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private ActivityApplyService activityApplyService;
	
	@RequestMapping
	public ModelAndView index(Integer page,Activity cp){
		ModelAndView mav = new ModelAndView("activ/activityAdd/indexapply");
		try{
			
			page = page == null || page < 0 ? 1 : page;
			int startnum =(page - 1) * size;
			List<Activity> list = activityService.queryList(cp, startnum, size);
			
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
	
	
	//分配
	@RequestMapping("/{id}/edit")
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
	
	@RequestMapping(value="/update")
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
	
	/**
	 * 查看会议室详情
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView detail(Long id,RedirectAttributes redirectAttributes){
		ModelAndView mav = new ModelAndView("activ/activityAdd/detail");
		try{
			Activity mm = activityService.getById(id);
			mav.addObject("meeting", mm);
		}catch(Exception e){
			e.printStackTrace();
			redirectAttributes.addFlashAttribute(Constants.MESSAGE_NAME,"未查询到活动信息");
			return new ModelAndView(LIST_ACTION);
		}
		return mav;
	}
	
}

