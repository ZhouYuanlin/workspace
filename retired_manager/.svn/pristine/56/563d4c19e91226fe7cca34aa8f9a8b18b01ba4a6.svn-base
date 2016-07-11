package cn.uuf.ltxxt.party.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.ret.Retireparty;
import cn.uuf.domain.ret.Retorganize;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.party.service.RetirepartyService;
import cn.uuf.ltxxt.party.service.RetorganizeService;
import cn.uuf.util.Paginate;

/**
 * 组织关系调整
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-28
 */
@Controller
@RequestMapping("{retorganize:retorganize;*.?}")
public class RetorganizeController extends BaseController{

	private final String LIST_ACTION = "redirect:/retorganize";
	@Resource
	private RetorganizeService gService;
	@Resource
	private RetirepartyService rService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retorganize g,String kssj,String jssj){
		ModelAndView mav = new ModelAndView("party/organ/index");
		try{
			int s = (page - 1) * size;
			Long count = gService.getCount(g,kssj,jssj);
			List<Retorganize> list = gService.queryList(g, s, size,kssj,jssj);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("kssj",kssj);
			mav.addObject("jssj",jssj);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找数据");
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("party/organ/create");
		mav.addObject("list",rService.getAll());
		this.getCodeInf(mav);
		return mav;
	}
	
	@RequestMapping("{save:save;*.?}")
	public ModelAndView save(@Valid Retorganize g,RedirectAttributes red,Long hid,String sfzh){
		try{
			if(sfzh != null){
				String[] code=sfzh.split(",");
				for (int i = 0; i < code.length; i++) {
					Retirement m = mentService.getById(code[i]);
					if(m.getParty() != null){
						Retireparty p = rService.getById(hid);
						g.setYparty(m.getParty());
						g.setHparty(p);
						g.setRet(m);
						gService.save(g);
						m.setParty(p);
						mentService.update(m);
						red.addFlashAttribute(Constants.MESSAGE_NAME,"维护组织关系成功");
					}else{
						red.addFlashAttribute(Constants.MESSAGE_NAME,m.getXm()+"还没有党支部，请先维护其党支部");
						return new ModelAndView(LIST_ACTION);
					}
				}
			}else{
				red.addFlashAttribute(Constants.MESSAGE_NAME,"未选择人员不能维护组织关系");
			}
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加组织关系失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("{delete:delete;*.?}")
	public ModelAndView delete(RedirectAttributes red,Long... id){
		try{
			gService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
}

