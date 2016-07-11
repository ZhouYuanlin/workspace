package cn.uuf.ltxxt.retire.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retiresalute;
import cn.uuf.domain.Retiresaluterecord;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.retire.service.RetiresaluteService;
import cn.uuf.ltxxt.retire.service.RetiresaluterecordService;
import cn.uuf.util.AddSQLQuery;
import cn.uuf.util.Paginate;

/**
 * 慰问服务
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-3
 */
@Controller
@RequestMapping("{retsalute:retsalute;*.?}")
public class RetsaluteController extends BaseController{

	private final String LIST_ACTION = "redirect:/retsalute";
	@Resource
	private RetiresaluteService saSerivce;
	@Resource
	private RetiresaluterecordService reService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retiresalute r,String ksj,String jsj){
		ModelAndView mav = new ModelAndView("retire/salute/index");
		try{
			if(ksj != null)
				ksj = ksj.equals("") ? null : ksj;
			if(jsj != null)
				jsj = jsj.equals("") ? null : jsj;
			int s = (page - 1) * size;
			Long count = saSerivce.getCount(r,ksj,jsj);
			List<Retiresalute> list = saSerivce.queryList(r, s, size,ksj,jsj);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("r",r);
			mav.addObject("ksj", ksj);
			mav.addObject("jsj",jsj);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		getCodeInf(mav);
		return mav;
	}
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("retire/salute/create");
		try{
			getCodeInf(mav);
		}catch(Exception e){}
		return mav;
	}
	
	@RequestMapping(value="{save:save;*.?}",method=RequestMethod.POST)
	public ModelAndView save(@Valid Retiresalute r,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("r",r);
					return create();
				}
			}
			if(r.getSfzhs() == null){
				red.addFlashAttribute(Constants.MESSAGE_NAME,"请选择人员");
				red.addFlashAttribute("r",r);
				return create();
			}
			saSerivce.save(r);
			for(String s : r.getSfzhs().split(",")){
				Retiresaluterecord rec = new Retiresaluterecord();
				rec.setSfzh(s);rec.setSid(r.getId());
				reService.save(rec);
			}
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("retire/salute/update");
		try{
			Retiresalute sa=saSerivce.getById(id);
			mav.addObject("r",saSerivce.getById(id));
			Retiresaluterecord rec = new Retiresaluterecord();
			rec.setSid(id);
			mav.addObject("recs",reService.queryByVo(rec));
			getCodeInf(mav);
		}catch(Exception e){}
		return mav;
	}
	@RequestMapping(value="{update:update;*.?}",method=RequestMethod.POST)
	public ModelAndView update(@Valid Retiresalute r,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("r",r);
					return new ModelAndView("redirect:/retsalute/"+r.getId()+"/edit");
				}
			}
			if(r.getSfzhs() == null){
				red.addFlashAttribute(Constants.MESSAGE_NAME,"请选择人员");
				red.addFlashAttribute("r",r);
				return new ModelAndView("redirect:/retsalute/"+r.getId()+"/edit");
			}
			Retiresalute sa = saSerivce.getById(r.getId());
			sa = (Retiresalute) AddSQLQuery.setObjectValue(r,sa);
			saSerivce.update(sa);
			String sql = "delete from uf_ltx_salute_record where sid=" + sa.getId();
			saSerivce.updateHQL(sql);
			for(String s : r.getSfzhs().split(",")){
				Retiresaluterecord rec = new Retiresaluterecord();
				rec.setSfzh(s);rec.setSid(r.getId());
				reService.save(rec);
			}
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
			saSerivce.delete(id);
			String sql = "delete from uf_ltx_salute_record where sid=";
			for(Long i : id){
				sql += i;
				saSerivce.updateHQL(sql);
			}
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping("/{id}/{zxzt}/backinfo")
	public ModelAndView backinfo(@PathVariable Long id,@PathVariable String zxzt,RedirectAttributes red){
		try{
			Retiresalute s = saSerivce.getById(id);
			s.setZxzt(zxzt);
			saSerivce.update(s);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"操作成功");
		}catch(Exception e){
			red.addFlashAttribute(Constants.MESSAGE_NAME,"操作失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	/**
	 * 异步提取人员信息
	 * @param response
	 * @param sfzh
	 * @return
	 */
	@RequestMapping("{ajaxdwlist:ajaxdwlist;*.?}")
	public ModelAndView ajaxDetail(HttpServletResponse response){
		ModelAndView mav = new ModelAndView("retire/salute/_choice");
		try{
			mav.addObject("dwblist",dwbService.getAll());
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxdetail(Long id){
		ModelAndView mav = new ModelAndView("retire/salute/_show");
		mav.addObject("p",saSerivce.getById(id));
		return mav;
	}
}

