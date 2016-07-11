package cn.uuf.ltxxt.retire.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retiredeath;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.Retirework;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.retire.service.RetiredeathService;
import cn.uuf.ltxxt.retire.service.RetireworkService;
import cn.uuf.ltxxt.system.code.service.CodeDwbService;
import cn.uuf.util.Paginate;

/**
 * 工作经历管理
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-22
 */
@Controller
@RequestMapping("{retwork:retwork;*.?}")
public class RetworkController extends BaseController{

	private final String LIST_ACTION = "redirect:/retwork";
	@Resource
	private RetireworkService workService;
	
	@Resource
	private RetiredeathService dService;
	@Resource
	private CodeDwbService codeDwbService;
	/**
	 * 查询
	 * @param page
	 * @param w
	 * @param gksj
	 * @param gjsj
	 * @param lksj
	 * @param ljsj
	 * @return
	 */
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retirework w,String gksj,String gjsj,String lksj,String ljsj,String column,String sort){
		ModelAndView mav = new ModelAndView("retire/work/index");
		try{
			if(gksj != null)
				gksj = gksj.equals("") ? null : gksj;
			if(gjsj != null)
				gjsj = gjsj.equals("") ? null : gjsj;
			if(lksj != null)lksj = lksj.equals("") ? null : lksj;
			if(ljsj != null)ljsj = ljsj.equals("") ? null : ljsj;
			if(column != null)column = column.equals("") ? null : column;//要排序的列
			if((sort==null||sort.equals(""))||sort.equals("asc"))//排序的方式
			{
				sort="desc";
			}
			else if(sort.equals("desc"))
			{
				sort="asc";
			}
			int s = (page - 1) * size;
			Retirement retirement = null;
			if(hasRoleScope().equals(Constants.INFOYX)){
				if(codeDwbService.getById(getUser().getCodedwb().getId()).getSfejdw().equals(Constants.HASYES)){
					if(w.getRet()!=null){
						retirement = w.getRet();
						retirement.setDwb(getUser() != null ? getUser().getCodedwb() : null);
					}else{
						retirement = new Retirement();
						retirement.setDwb(getUser() != null ? getUser().getCodedwb() : null);
					}
				}
				w.setRet(retirement);
			}
			Long count = workService.getCount(w,gksj,gjsj,lksj,ljsj,column,sort);
			List<Retirework> list = workService.queryList(w,s, size,gksj,gjsj,lksj,ljsj,column,sort);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("w",w);
			mav.addObject("gksj",gksj);
			mav.addObject("gjsj",gjsj);
			mav.addObject("lksj",lksj);
			mav.addObject("ljsj",ljsj);
			mav.addObject("sort",sort);
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("retire/work/create");
		getCodeInf(mav);
		return mav;
	}
	@RequestMapping(value="{save:save;*.?}",method=RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request,String sfzh,@Valid Retirework w,BindingResult res,RedirectAttributes red){
		try{
			if(sfzh != null){
				Retirement m = mentService.getById(splitSfzh(sfzh));
				if(m != null){
					w.setCreateDate(new Date());
					w.setRet(m);
					workService.save(w);
					m.addWork(w);
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
		ModelAndView mav = new ModelAndView("retire/work/update");
		try{
			mav.addObject("r",workService.getById(id));
		}catch(Exception e){
		}
		return mav;
	}
	@RequestMapping(value="{update:update;*.?}",method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request,String sfzh,@Valid Retirework w,BindingResult res,RedirectAttributes red){
		try{
			if(sfzh != null){
				w.setRet(mentService.getById(sfzh));
				w.setCreateDate(new Date());
				workService.update(w);
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
			workService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
			this.writer(this.getCurrentUser().getRealname()+"删除人员" + id.toString(),request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	/**
	 * 异步提取人员信息
	 * @param response
	 * @param sfzh
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxDetail(HttpServletResponse response,String sfzh){
		ModelAndView mav = new ModelAndView("retire/work/_work");
		try{
			Retirement m = mentService.getById(sfzh);
			mav.addObject("ret",m);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("beforeFind")
	public @ResponseBody 
	String beforeApply(@RequestParam String sfzh){
		return checkXh(sfzh);
	}
	
	public String checkXh(String sfzh){
		try {
			Retirement retirement= mentService.getById(sfzh);
			if(retirement==null){
				return "notFoundm";
			}else{
				if(StringUtils.isNotEmpty(retirement.getSfsc())&&retirement.getSfsc().equals("是")){
					return "notFoundm";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StringUtils.EMPTY;
	}
	
	@RequestMapping(value="querybysfzh/json",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String queryTemplateJbxxByXh(String sfzh){
		String str="";
		try {
			str=mentService.getBaseInfo(sfzh);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}

