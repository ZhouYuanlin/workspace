package cn.uuf.ltxxt.system.code.controller;

import java.util.List;

import javax.annotation.Resource;
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
import cn.uuf.domain.CodeBjbj;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.code.service.CodeBjbjService;
import cn.uuf.util.Paginate;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Controller
@RequestMapping("{codebjbj:codebjbj;*.?}")
public class CodeBjbjController extends BaseController{

	private final String LIST_ACTION = "redirect:/codebjbj";
	@Resource
	CodeBjbjService bjService;
	
	@RequestMapping
	public ModelAndView index(Integer page,CodeBjbj mzb,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("code/bjbj/index");
		try{
			page = page == null || page < 0 ? 1 : page;
			int start = (page - 1) * size;
			Long count = bjService.getCount(mzb);
			List<CodeBjbj> list = bjService.queryList(mzb, start, size);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("mzb", mzb);
			mav.addObject("list",list);
			mav.addObject("paginate",paginate);
		}catch(Exception e){
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
			e.printStackTrace();
		}
		mav.addObject("url","/mzb");
		return mav;
	}
	@RequestMapping("create")
	public ModelAndView create( CodeBjbj mzb,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("code/bjbj/create");
		return mav;
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ModelAndView save(@Valid CodeBjbj mzb,BindingResult binding,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redAttr)throws Exception{
		try{
			if(binding.hasErrors()){
				List<ObjectError> ls = binding.getAllErrors();
				String error = "";
				for(ObjectError oe : ls){
					error = oe.getDefaultMessage();
				}
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME, error);
				redAttr.addFlashAttribute("mzb", mzb);
				return new ModelAndView("redirect:/codebjbj/create");
			}
			bjService.save(mzb);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加成功！");
			this.writer("添加保健标记表",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加失败！");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping(value="/{id}/edit")
	public ModelAndView modify(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("code/bjbj/update");
		try{
			CodeBjbj mzb = bjService.getById(id);
			mav.addObject("mzb",mzb);
		}catch(Exception e){
			e.printStackTrace();
		}
		return  mav;
	}
	
	@RequestMapping("update")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response,@Valid CodeBjbj mzb,BindingResult result,RedirectAttributes redAttr)throws Exception{
		try{
			if(result.hasErrors()){
				ModelAndView mav = new ModelAndView("code/bjbj/update");
				List<ObjectError> ls = result.getAllErrors();
				String error = "";
				for(ObjectError oe : ls){
					error = oe.getDefaultMessage();
				}
				mav.addObject(Constants.MESSAGE_NAME, error);
				mav.addObject("mzb",mzb);
				return mav;
			}
			bjService.update(mzb);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "修改成功！");
			this.writer("修改保健标记表",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "修改失败！");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping(value="/delete")
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redAttr,Long... id)throws Exception{
		try{
			
			bjService.delete(id);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除成功！");
			this.writer("删除保健标记",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除失败！");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
}

