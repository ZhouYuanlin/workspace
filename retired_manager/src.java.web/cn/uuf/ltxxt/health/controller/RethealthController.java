package cn.uuf.ltxxt.health.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.health.Rethealth;
import cn.uuf.ltxxt.health.service.RethealthService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.Paginate;

/**
 * 医疗健康
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-29
 */
@Controller
@RequestMapping("{rethealth:rethealth;*.?}")
public class RethealthController extends BaseController{

	private final String LIST_ACTION = "redirect:/rethealth";
	@Resource
	private RethealthService hSerivce;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Rethealth w,String gksj,String gjsj){
		ModelAndView mav = new ModelAndView("care/health/index");
		try{
			if(gksj != null)gksj = gksj.equals("") ? null : gksj;
			if(gjsj != null)gjsj = gjsj.equals("") ? null : gjsj;
			int s =(page - 1) * size;
			Retirement retirement = null;
			if(hasRoleScope().equals(Constants.INFOYX)){
				if(w.getRet() != null){
					retirement = w.getRet();
					retirement.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}else{
					retirement = new Retirement();
					retirement.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}
				w.setRet(retirement);
			}
			Long count = hSerivce.getCount(w, gksj, gjsj);
			List<Rethealth> list = hSerivce.queryList(w, s, size, gksj, gjsj);
			paginate = new Paginate(list,count,size,page);
			mav.addObject("paginate", paginate);
			mav.addObject("w", w);
			mav.addObject("list", list);
			mav.addObject("gksj", gksj);
			mav.addObject("gjsj", gjsj);
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("care/health/create");
		getCodeInf(mav);
		return mav;
	}
	@RequestMapping(value="{save:save;*.?}",method=RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request,String sfzh,@Valid Rethealth w,BindingResult res,RedirectAttributes red){
		try{
			sfzh=splitSfzh(sfzh);
			if(sfzh != null){
				Retirement m = mentService.getById(sfzh);
				if(m != null){
					w.setRet(m);
					hSerivce.save(w);
					m.addHealth(w);
					mentService.update(m);
					red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
					this.writer(this.getCurrentUser().getRealname() + "添加["+w.getRet().getXm()+"]的工作经历", request.getRemoteAddr(), this.getCurrentUser().getUsername());
				}else{
					red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败，【"+sfzh+"】退休人员不存在");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("care/health/update");
		try{
			mav.addObject("r",hSerivce.getById(id));
		}catch(Exception e){
		}
		return mav;
	}
	@RequestMapping(value="{update:update;*.?}",method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request,String sfzh,@Valid Rethealth w,BindingResult res,RedirectAttributes red){
		try{
			if(sfzh != null){
				w.setRet(mentService.getById(sfzh));
				hSerivce.update(w);
				red.addFlashAttribute(Constants.MESSAGE_NAME,"修改成功");
				this.writer(this.getCurrentUser().getRealname()+"修改【" + w.getRet().getXm() + "】信息",request.getRemoteAddr(),this.getCurrentUser().getUsername());
			}
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping("{delete:delete;*.?}")
	public ModelAndView delete(HttpServletRequest request,RedirectAttributes red,Long... id){
		try{
			hSerivce.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
			this.writer(this.getCurrentUser().getRealname()+"删除人员" + id.toString(),request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxDetail(HttpServletResponse response,Long id){
		ModelAndView mav = new ModelAndView("care/health/_work");
		try{
			Rethealth m = hSerivce.getById(id);
			mav.addObject("r",m);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
}

