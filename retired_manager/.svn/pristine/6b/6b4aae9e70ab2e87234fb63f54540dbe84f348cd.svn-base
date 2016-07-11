package cn.uuf.ltxxt.car.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import cn.uuf.domain.car.Carapply;
import cn.uuf.domain.car.Carinfo;
import cn.uuf.ltxxt.car.service.CarApplyService;
import cn.uuf.ltxxt.car.service.CarInfoService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.Paginate;

/**
 * 车辆使用管理
 * @author fc
 * @version 1.0
 * @date 2016-5-12 11:34:22
 */
@Controller
@RequestMapping("/carApply")
public class CarApplyAction extends BaseController{
	
	private final String LIST_ACTION = "redirect:/carApply";
	
	@Autowired
	private CarApplyService carService;
	
	@Autowired
	private CarInfoService carInfoService;
	
	@RequestMapping
	public ModelAndView index(Integer page,Carapply cp){
		ModelAndView mav = new ModelAndView("car/carapply/index");
		try{
			//获取车辆申请信息分页list
			page = page == null || page < 0 ? 1 : page;
			int startnum =(page - 1) * size;
			List<Carapply> list = carService.queryList(cp, startnum, size);
			for(int i=0;i<list.size();i++){
				if(list.get(i).getState().equals("审核通过")){
					list.get(i).setState("<span style='color:blue'>审核通过</span>");
				}else if(list.get(i).getState().equals("待审核")){
					list.get(i).setState("<span>待审核</span>");
				}else {
					list.get(i).setState("<span style='color:red'>审核不通过</span>");
				}
			}
			//获取车辆申请信息总数量
			Long count = carService.getCount(cp);
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
	
	//跳转添加页面
	@RequestMapping("/create")
	public ModelAndView create(){
		//查询车辆信息下拉列表数据
		List<Carinfo> list = carInfoService.find();
		ModelAndView mav = new ModelAndView("car/carapply/create");
		mav.addObject("carslist",list);
		getCodeInf(mav);
		return mav;
	}
	
	//车辆sava方法
	@RequestMapping(value="/save")
	public ModelAndView save(HttpServletRequest request,String sfzh,@Valid Carapply ci,BindingResult res,RedirectAttributes red){
		//添加车辆信息
		try{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String time =df.format(new Date());
			ci.setAddTime(time);
			ci.setApplyId(this.getCurrentUser().getId());
			ci.setApplyName(this.getCurrentUser().getRealname());
			ci.setState("待审核");
			carService.save(ci);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	//删除车辆
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request,RedirectAttributes red,Long... id){
		try{
			carService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	//修改车辆信息
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("car/carapply/update");
		try{
			//查询车辆信息下拉列表数据
			List<Carinfo> list = carInfoService.find();
			mav.addObject("carslist",list);
			//获取选择车辆申请信息
			mav.addObject("r",carService.getById(id));
		}catch(Exception e){
		}
		return mav;
	}
	
	@RequestMapping(value="/update")
	public ModelAndView update(HttpServletRequest request,@Valid Carapply ci,BindingResult res,RedirectAttributes red){
		try{
			Carapply carp=carService.getById(ci.getId());
			ci.setApplyId(carp.getApplyId());
			ci.setApplyName(carp.getApplyName());
			ci.setState(carp.getState());
			ci.setAddTime(carp.getAddTime());
			ci.setApplyTime(carp.getApplyTime());
			ci.setOpinion(carp.getOpinion());
			carService.update(ci);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	//审核车辆信息
	@RequestMapping("/{id}/apply")
	public ModelAndView apply(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("car/carapply/apply");
		try{
			//查询车辆信息下拉列表数据
			List<Carinfo> list = carInfoService.find();
			mav.addObject("carslist",list);
			//获取选择车辆申请信息
			mav.addObject("r",carService.getById(id));
		}catch(Exception e){
		}
			return mav;
	}
	
	//审核车辆信息保存
	@RequestMapping(value="/applyState")
	public ModelAndView applyState(HttpServletRequest request,@Valid Carapply ci,BindingResult res,RedirectAttributes red){
		try{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String time =df.format(new Date());
			ci.setApplyTime(time);
			Carapply carp=carService.getById(ci.getId());
			ci.setAddTime(carp.getAddTime());
			ci.setUseTime(carp.getUseTime());
			ci.setApplyId(carp.getApplyId());
			ci.setApplyName(carp.getApplyName());
			carService.update(ci);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"审核成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"审核失败");
		}
			return new ModelAndView(LIST_ACTION);
		}
}

