package cn.uuf.ltxxt.retire.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.classfile.Code;
import com.sun.xml.internal.ws.wsdl.parser.MexEntityResolver;

import cn.uuf.contants.Constants;
import cn.uuf.domain.CodeDyb;
import cn.uuf.domain.Retirement;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.party.service.RetirepartyService;
import cn.uuf.ltxxt.system.code.service.CodeDwbService;
import cn.uuf.ltxxt.system.code.service.CodeDybService;
import cn.uuf.util.DateUtil;
import cn.uuf.util.Paginate;

/**
 * 普通工作人员查询
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-17
 */
@Controller
@RequestMapping("{retinfo:retinfo;*.?}")
public class RetinfoController extends BaseController{

	@Resource
	private RetirepartyService pService;
	@Resource
	private CodeDybService dybService;
	@Resource
	private CodeDwbService codeDwbService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue = "1") Integer page,Retirement m,String ages,String xsdy){
		ModelAndView mav = new ModelAndView("retire/person/list");
		try{
			if(ages==null){
				ages="50,120";
			}
			Integer agest=null;
			Integer ageend=null;
			Integer ageeq=null;
			if(StringUtils.isNotEmpty(ages)){
				String[] agearr = ages.split(",");
				agest = Integer.parseInt(agearr[0]);
				ageend = Integer.parseInt(agearr[1]);
				if(agest.equals(ageend)){
					ageeq=ageend;
				}
			}
			mav.addObject("ages", ages);
			
			
			String csrqSend="";
			String csrqSst="";
			String csrqSeq="";
			if(ageeq!=null){
				int currentYear = DateUtil.getCurrentYear();
				csrqSeq = (currentYear-ageeq)+"";
			}else{
				if(agest!=null){
					int currentYear = DateUtil.getCurrentYear();
					csrqSst = ((currentYear-agest)+1)+"-00-00";
				}
				if(ageend!=null){
					int currentYear = DateUtil.getCurrentYear();
					csrqSend = ((currentYear-ageend))+"-00-00";
				}
			}
			int s = (page - 1) * size;
			if(hasRoleScope().equals(Constants.INFOYX)){
				if(codeDwbService.getById(getUser().getCodedwb().getId()).getSfejdw().equals(Constants.HASYES)){
					m.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}
			}
			Long count = mentService.getCount(m,csrqSst,csrqSend,csrqSeq,xsdy);
			List<Retirement> list = mentService.queryList(m,s, size,csrqSst,csrqSend,csrqSeq,xsdy);
			List<CodeDyb> codeDyb = dybService.getAll();
			paginate = new Paginate(list, count, size, page);
			mav.addObject("pagpaginateinate", paginate);
			mav.addObject("list", list);
			mav.addObject("ret",m);
			mav.addObject("plist",pService.getAll());
			mav.addObject("agest", agest);
			mav.addObject("ageend", ageend);
			mav.addObject("ageeq", ageeq);
			mav.addObject("xsdy", xsdy);
			mav.addObject("codeDyb", codeDyb);
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
}

