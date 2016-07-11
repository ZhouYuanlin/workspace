package cn.uuf.ltxxt.health.controller;

import java.io.OutputStream;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.CodeZzmmb;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.health.Rethoscard;
import cn.uuf.domain.health.Retphone;
import cn.uuf.domain.ret.Retireparty;
import cn.uuf.ltxxt.health.service.RetphoneService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.party.service.RetirepartyService;
import cn.uuf.util.AddSQLQuery;
import cn.uuf.util.DateUtil;
import cn.uuf.util.Paginate;

/**
 * 电话联系
 * @author Suntingwen
 *
 */
@Controller
@RequestMapping("{retphone:retphone;*.?}")
public class RetphoneController extends BaseController{

	private final String LIST_ACTION = "redirect:/retphone";
	@Resource
	private RetphoneService retphoneService;
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retphone retphone){
		ModelAndView mav = new ModelAndView("care/phone/index");
		try{
			int s = (page - 1) * size;
			Retirement ment = null;
			if(hasRoleScope().equals(Constants.INFOYX)){
				if(retphone.getRetirement()!=null){
					ment = retphone.getRetirement();
					ment.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}else{
					ment = new Retirement();
					ment.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}
				retphone.setRetirement(ment);
			}
			Long count = retphoneService.getCount(retphone);
			List<Retphone> list = retphoneService.queryList(retphone,s,size);
			for (Retphone retphone2 : list) {
				Retirement retirement = mentService.getById(retphone2.getSfzh());
				retphone2.setRetirement(retirement);
			}
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("retphone",retphone);
			mav.addObject("list", list);
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("care/phone/create");
		getCodeInf(mav);
		return mav;
	}
	
	@RequestMapping("{save:save;*.?}")
	public ModelAndView save(String sfzh,@Valid Retphone retphone,BindingResult res,RedirectAttributes red){
		try{
			sfzh=splitSfzh(sfzh);
			Retirement retirement = mentService.getById(sfzh);
			retphone.setSfzh(retirement.getSfzh());
			retphone.setDjrq(new Date());
			retphone.setDjr(getCurrentUser().getRealname());
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("retphone",retphone);
					return new ModelAndView("redirect:/retphone/create");
				}
			}
			retphoneService.save(retphone);
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("care/phone/update");
		Retphone retphone = this.retphoneService.getById(id);
		Retirement retirement = mentService.getById(retphone.getSfzh());
		retphone.setRetirement(retirement);
		try{
			mav.addObject("retphone",this.retphoneService.getById(id));
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("{update:update;*.?}")
	public ModelAndView update(@Valid Retphone retphone,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("retphone",retphone);
					return new ModelAndView("redirect:/retphone/" + retphone.getId() + "/edit");
				}
			}
			Retphone retp = retphoneService.getById(retphone.getId());
			retp.setDjrq(new Date());
			retp.setLxr(retphone.getLxr());
			retp.setLxxq(retphone.getLxxq());
			retp.setLxrq(retphone.getLxrq());
			retp.setDjr(getCurrentUser().getRealname());
			retphoneService.update(retp);
			
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
			retphoneService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
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
		ModelAndView mav = new ModelAndView("care/phone/_info");
		try{
			String[] split = sfzh.split(",");
			sfzh = split[0];
			Long id=Long.parseLong(split[1]);
			Retphone retphone =null;
			if(id!=null){
				retphone = retphoneService.getById(id);
			}
//			Retirement m = mentService.getById(retphone.getRetirement().getSfzh());
			Retirement m = mentService.getById(sfzh);
			mav.addObject("ret",m);
			mav.addObject("retphone", retphone);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
}

