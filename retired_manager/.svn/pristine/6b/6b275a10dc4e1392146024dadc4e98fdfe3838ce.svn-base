package cn.uuf.ltxxt.retire.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirement;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.retire.service.RetbirthdayService;
import cn.uuf.ltxxt.system.code.service.CodeDwbService;
import cn.uuf.util.DateUtil;
import cn.uuf.util.Paginate;

/**
 * 生日提醒
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-31
 */
@Controller
@RequestMapping("{retbirthday:retbirthday;*.?}")
public class RetbirthdayController extends BaseController{

	@Resource
	private RetbirthdayService bService;
	@Resource
	private CodeDwbService codeDwbService;
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retirement m,String kssj,String jssj,String ages){
		ModelAndView mav = new ModelAndView("retire/birthday/index");
		try{
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
			Long count = 0l;
			List<Retirement> list = new ArrayList<Retirement>();
			if((kssj == null || kssj.equals("")) && (jssj == null || jssj.equals(""))){//查年龄段
				count = bService.getCount(m,csrqSst,csrqSend,csrqSeq,null);
				list = bService.queryList(m, s, size,csrqSst,csrqSend,csrqSeq,null);
			}else{//查时间段
				count = bService.getCount(m,jssj,kssj,null, "csrq");
				list = bService.queryList(m, s, size,jssj,kssj,null,"csrq");
			}
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("kssj",kssj);
			mav.addObject("jssj",jssj);
			mav.addObject("ret",m);
			getCodeInf(mav);
		}catch(Exception e){
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	private String backYear(int age){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date d = new Date();
		return String.valueOf(Integer.parseInt(sdf.format(d)) - age);
	}
}

