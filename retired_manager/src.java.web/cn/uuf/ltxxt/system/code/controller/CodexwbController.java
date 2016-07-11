package cn.uuf.ltxxt.system.code.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.CodeXwb;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.Paginate;

/**
 * 学位表
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-1
 */
@Controller
@RequestMapping("{codexwb:codexwb;*.?}")
public class CodexwbController extends BaseController{

	private final String LIST_ACTION = "redirect:/codexwb";
	@RequestMapping
	public ModelAndView index(Integer page,CodeXwb dwb,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("code/xwb/index");
		try{
			page = page == null || page < 0 ? 1 : page;
			int start = (page - 1) * size;
			Long count = xwbService.getCount(dwb);
			List<CodeXwb> list = xwbService.queryList(dwb, start, size);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("dwb", dwb);
			mav.addObject("list",list);
			mav.addObject("paginate",paginate);
		}catch(Exception e){
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping("create")
	public ModelAndView create( CodeXwb dwb,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("code/xwb/create");
		return mav;
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ModelAndView save(@Valid CodeXwb dwb,BindingResult binding,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redAttr)throws Exception{
		try{
			if(binding.hasErrors()){
				List<ObjectError> ls = binding.getAllErrors();
				String error = "";
				for(ObjectError oe : ls){
					error = oe.getDefaultMessage();
				}
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME, error);
				redAttr.addFlashAttribute("dwb", dwb);
				return new ModelAndView("redirect:/codexwb/create");
			}
			xwbService.save(dwb);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加成功！");
		}catch(Exception e){
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加失败！");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping(value="/{id}/edit")
	public ModelAndView modify(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("code/xwb/update");
		try{
			CodeXwb dwb = xwbService.getById(id);
			mav.addObject("dwb",dwb);
		}catch(Exception e){
			e.printStackTrace();
		}
		return  mav;
	}
	
	@RequestMapping("update")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response,@Valid CodeXwb dwb,BindingResult result,RedirectAttributes redAttr)throws Exception{
		try{
			if(result.hasErrors()){
				ModelAndView mav = new ModelAndView("code/xwb/update");
				List<ObjectError> ls = result.getAllErrors();
				String error = "";
				for(ObjectError oe : ls){
					error = oe.getDefaultMessage();
				}
				mav.addObject(Constants.MESSAGE_NAME, error);
				mav.addObject("dwb",dwb);
				return mav;
			}
			xwbService.update(dwb);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "修改成功！");
		}catch(Exception e){
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "修改失败！");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping(value="/delete")
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redAttr,Long... id)throws Exception{
		try{
			
			xwbService.delete(id);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除成功！");
		}catch(Exception e){
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除失败！");
		}
		return new ModelAndView(LIST_ACTION);
	}
}

