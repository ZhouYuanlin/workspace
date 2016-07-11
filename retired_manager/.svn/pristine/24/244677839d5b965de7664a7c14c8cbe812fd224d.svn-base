package cn.uuf.ltxxt.system.param.controller;

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
import cn.uuf.domain.Retparam;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.param.service.RetparamService;
import cn.uuf.util.Paginate;

/**
 * 系统参数表
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-19
 */
@Controller
@RequestMapping("{retparam:retparam;*.?}")
public class RetparamController extends BaseController{

	private final String LIST_ACTION = "redirect:/retparam";
	@Resource
	RetparamService pService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retparam p){
		ModelAndView mav = new ModelAndView("permission/param/index");
		try{
			int s = (page - 1) * size;
			Long count = pService.getCount(p);
			List<Retparam> list = pService.queryList(p, s, size);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		return new ModelAndView("permission/param/create");
	}
	
	@RequestMapping("{save:save;*.?}")
	public ModelAndView save(@Valid Retparam p,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("p",p);
					return new ModelAndView(LIST_ACTION + "/create");
				}
			}
			Retparam pp = pService.qeryByName(p.getName());
			if(pp != null)
				red.addFlashAttribute(Constants.MESSAGE_NAME, p.getName() + "已存在不能添加相同名称");
			else{
				pService.save(p);
				red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
			}
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加参数失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("permission/param/update");
		mav.addObject("p",pService.getById(id));
		return mav;
	}
	
	@RequestMapping("{update:update;*.?}")
	public ModelAndView update(@Valid Retparam p,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("p",p);
					return new ModelAndView(LIST_ACTION + "/"+p.getId()+"/edit");
				}
			}
			pService.update(p);
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
			pService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
}

