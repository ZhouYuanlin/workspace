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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retiredeath;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.honor.Retirehonor;
import cn.uuf.ltxxt.honor.service.RetirehonorService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.retire.service.RetiredeathService;
import cn.uuf.ltxxt.retire.service.RetiresaluteService;
import cn.uuf.ltxxt.system.code.service.CodeDwbService;
import cn.uuf.util.Paginate;

/**
 * 离世管理
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-31
 */
@Controller
@RequestMapping("{retdeath:retdeath;*.?}")
public class RetdeathController extends BaseController{

	private final String LIST_ACTION = "redirect:/retdeath";
	@Resource
	private RetiredeathService dService;
	@Resource
	private RetirehonorService hService;
	@Resource
	private RetiresaluteService saluteService;
	@Resource
	private CodeDwbService codeDwbService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retiredeath r,String ksj,String jsj){
		ModelAndView mav = new ModelAndView("retire/death/index");
		try{
			if(ksj != null)
				ksj = ksj.equals("") ? null : ksj;
			if(jsj != null)
				jsj = jsj.equals("") ? null : jsj;
			int s = (page -1) * size;
			if(hasRoleScope().equals(Constants.INFOYX)){
				if(codeDwbService.getById(getUser().getCodedwb().getId()).getSfejdw().equals(Constants.HASYES)){
					r.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}
			}
			Long count = dService.getCount(r,ksj,jsj);
			List<Retiredeath> list = dService.queryList(r, s, size,ksj,jsj);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("ret",r);
			mav.addObject("ksj", ksj);
			mav.addObject("jsj",jsj);
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("{create:create;*.?}")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("retire/death/create");
		try{
			getCodeInf(mav);
		}catch(Exception e){e.printStackTrace();}
		return mav;
	}
	@RequestMapping(value="{save:save;*.?}",method=RequestMethod.POST)
	public ModelAndView save(@Valid Retiredeath r,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("ret",r);
					return new ModelAndView("redirect:/retdeath/create");
				}
			}
			String[] split = r.getSfzh().split(",");
			Retirement m = mentService.getById(split[0]);
			m.setSfsc(Constants.HASYES);
			mentService.update(m);
			r.setCsrq(m.getCsrq());
			if(r.getSscj() == null)
				r.setSscj(Constants.HASNO);
			r.setSfzh(split[0]);
			dService.save(r);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping("/{sfzh}/edit")
	public ModelAndView edit(@PathVariable String sfzh){
		ModelAndView mav = new ModelAndView("retire/death/update");
		try{
			mav.addObject("ret",dService.getById(sfzh));
			getCodeInf(mav);
		}catch(Exception e){}
		return mav;
	}
	@RequestMapping(value="{update:update;*.?}",method=RequestMethod.POST)
	public ModelAndView update(@Valid Retiredeath r,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					return new ModelAndView("redirect:/retdeath/"+r.getSfzh()+"/edit");
				}
			}
			if(r.getSscj() == null)
				r.setSscj(Constants.HASNO);
			dService.update(r);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"更新失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping("{delete:delete;*.?}")
	public ModelAndView delete(RedirectAttributes red,String... id){
		try{
	     	dService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{sfzh}/detail")
	public ModelAndView detail(@PathVariable String sfzh,RedirectAttributes red){
		ModelAndView mav = new ModelAndView("retire/person/detail");
		try{
			mav.addObject("ret",mentService.getById(sfzh));
			mav.addObject("lsxx",dService.getById(sfzh));
			Retirehonor h = new Retirehonor();
			h.setCyhs(sfzh);
			List<Retirehonor> list = hService.queryByVo(h);//个人表彰
			mav.addObject("hlist",list);
			//查慰问记录
			String sql = "from Retiresalute s where s.id in( select u.sid from Retiresaluterecord u where u.sfzh='"+sfzh+"') order by s.wwsj desc";//慰问
			mav.addObject("salist",saluteService.queryBySql(sql));
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"未找到退休人员");
			return new ModelAndView(LIST_ACTION);
		}
		return mav;
	}
	
	/**
	 * 异步提取人员信息
	 * @param response
	 * @param sfzh
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxDetail(HttpServletResponse response,String sfzh){
		ModelAndView mav = new ModelAndView("retire/death/_life");
		try{
			Retiredeath m = dService.getById(sfzh);
			mav.addObject("ret",m);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * 根据用户名
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "autoCompleteUser", method = RequestMethod.POST)
	public @ResponseBody Object[] getAllUser(@RequestParam String query) {
		Object[] obj = null;
		Object[] autoComplete = null;
		try {
			StringBuffer strBuf=new StringBuffer();
			strBuf.append("select t.sfzh,t.xm from Retiredeath t where 1=1 ");
			strBuf.append("and  ( t.sfzh like '"+query+"%' or t.xm like '"+query+"%') ");//and rownum <9 ");
			if(hasRoleScope().equals(Constants.INFOYX)){
				Long did = getUser() != null ? getUser().getCodedwb().getId() : null;
				if(did != null) strBuf.append(" and t.dwb_id = " + did);
			}
			List data =  dService.queryByHql(strBuf.toString());
			autoComplete = new Object[data.size()];
			for(int i = 0 ;i < data.size(); i++){
				obj = (Object[]) data.get(i);
				autoComplete[i] = obj[0].toString()+"-"+obj[1];
			}
			return autoComplete;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value="querybysfzh/json",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String queryTemplateJbxxByXh(String sfzh){
		String str="";
		try {
			str=mentService.getBaseInfos(sfzh);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}

