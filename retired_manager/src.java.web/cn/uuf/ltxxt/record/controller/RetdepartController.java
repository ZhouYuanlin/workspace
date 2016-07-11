package cn.uuf.ltxxt.record.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.record.Retdepart;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.record.service.RetdepartService;
import cn.uuf.util.Paginate;

/**
 * 通信录部门
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-28
 */
@Controller
@RequestMapping("{retdepart:retdepart;*.?}")
public class RetdepartController extends BaseController{

	private final String LIST_ACTION = "redirect:/retdepart";
	@Resource
	private RetdepartService dService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retdepart d){
		ModelAndView mav = new ModelAndView("record/depart/index");
		try{
			int s = (page - 1) * size;
			Long count = dService.getCount(d);
			List<Retdepart> list = dService.queryList(d,s, size);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("dlist",dService.getAll());
			mav.addObject("d",d);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("record/depart/create");
		mav.addObject("dlist",dService.getAll());
		return mav;
	}
	
	@RequestMapping("{save:save;*.?}")
	public ModelAndView save(Long pid,@Valid Retdepart d,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("d",d);
					return new ModelAndView("redirect:/retdepart/create");
				}
			}
			if(pid != null)
				d.setParent(dService.getById(pid));
			dService.save(d);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("record/depart/update");
		try{
			mav.addObject("d",dService.getById(id));
			mav.addObject("dlist",dService.getAll());
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("{update:update;*.?}")
	public ModelAndView update(Long pid,@Valid Retdepart d,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("d",d);
					return new ModelAndView("redirect:/retdepart/"+d.getId()+"/create");
				}
			}
			if(pid != null)
				d.setParent(dService.getById(pid));
			dService.update(d);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("{delete:delete;*.?}")
	public ModelAndView delete(RedirectAttributes red,Long... id){
		try{
			dService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxdetail(Long id){
		ModelAndView mav = new ModelAndView("record/depart/_show");
		try{
			mav.addObject("d",dService.getById(id));
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
}

