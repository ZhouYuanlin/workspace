package cn.uuf.ltxxt.health.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.health.Retlabel;
import cn.uuf.ltxxt.health.service.RetlabelService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.AddSQLQuery;
import cn.uuf.util.Paginate;

/**
 * 保健标记
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-2
 */
@Controller
@RequestMapping("{retlabel:retlabel;*.?}")
public class RetlabelController extends BaseController{

	private final String LIST_ACTION = "redirect:/retlabel";
	@Resource
	private RetlabelService bService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retlabel l){
		ModelAndView mav = new ModelAndView("care/label/index");
		try{
			int s = (page - 1) * size;
			Retirement retirement = null;
			if(hasRoleScope().equals(Constants.INFOYX)){
				if(l.getRet()!=null){
					retirement = l.getRet();
					retirement.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}else{
					retirement = new Retirement();
					retirement.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}
				l.setRet(retirement);
			}
			Long count = bService.getCount(l);
			List<Retlabel> list = bService.queryList(l, s, size);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("w",l);
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("care/label/create");
		getCodeInf(mav);
		return mav;
	}
	
	@RequestMapping("{save:save;*.?}")
	public ModelAndView save(String sfzh,@Valid Retlabel l,RedirectAttributes red){
		try{
			sfzh=splitSfzh(sfzh);
			Retirement m = new Retirement();
			m.setSfzh(sfzh);
			l.setRet(m);
			l.setCreateDate(new Date());
			bService.save(l);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("care/label/update");
		mav.addObject("r",bService.getById(id));
		getCodeInf(mav);
		return mav;
	}
	
	@RequestMapping("{update:update;*.?}")
	public ModelAndView update(@Valid Retlabel l,RedirectAttributes red){
		try{
			Retlabel b = bService.getById(l.getId());
			b = (Retlabel) AddSQLQuery.setObjectValue(l,b);
			bService.update(b);
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
			bService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
}

