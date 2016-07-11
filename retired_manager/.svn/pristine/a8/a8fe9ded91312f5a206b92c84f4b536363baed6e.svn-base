package cn.uuf.ltxxt.retire.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.excelutils.ExcelUtils;
import net.sf.json.JSONArray;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirefamily;
import cn.uuf.domain.Retiremember;
import cn.uuf.domain.Retirement;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.retire.service.RetirefamilyService;
import cn.uuf.ltxxt.retire.service.RetirememberService;
import cn.uuf.util.CleanStringUtil;
import cn.uuf.util.Paginate;

/**
 * 家庭住址
 * @author Suntingwen
 *
 */
@Controller
@RequestMapping("{retmap:retmap;*.?}")
public class RetMapController extends BaseController{

	private final String LIST_ACTION = "redirect:/retmap";
	@Resource
	private RetirefamilyService familyService;
	
	@RequestMapping
	public ModelAndView index(){	//@RequestParam(defaultValue="1")Integer page,
		ModelAndView mav = new ModelAndView("retire/map/index");
		try{
			getCodeInf(mav);
		}catch(Exception e){
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据！");
		}
		return mav;
	}
	
	/**
	 * 异步提取人员信息
	 * @param response
	 * @param sfzh	根据身份证号查询
	 * @param dzcx 根据输入的地址 查询出对应的地址下有多少人员的信息
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxDetail(HttpServletResponse response,String sfzh,String sfzhcx,Retirefamily f){
		ModelAndView mav = null;
		try{
			int s=0;
			if(StringUtils.isEmpty(f.getJtdz()) && StringUtils.isNotEmpty(sfzh) && StringUtils.isEmpty(sfzhcx)){
				List<Retirefamily> family = new ArrayList<>();
				Retirement m = mentService.getById(splitSfzh(sfzh));
				List<Retirefamily> familys = m.getFamilys();
				for (Retirefamily retirefamily : familys) {
					if(retirefamily.getSfmr().equals("是")){
						family.add(retirefamily);
					}
				}
				mav = new ModelAndView("/retire/map/_address");
				mav.addObject("fam", family);
			}
			if(f!=null && f.getJtdz()!=null && f.getJtdz().trim().length()>0){
				List<Retirement> ment = new ArrayList<>();
				f.setSfmr("是");
				List<Retirefamily> list = familyService.queryList(f, s, size);
				for (Retirefamily retirefamily : list) {
					Retirement retirement = mentService.getById((retirefamily.getRet().getSfzh()));
					if(retirement!=null){
						ment.add(retirement);
					}
				}
				mav=new ModelAndView("/retire/map/_detail");
				mav.addObject("xmList", ment);
			}
			if(StringUtils.isNotEmpty(sfzhcx)){
				List<Retirefamily> family = new ArrayList<>();
				Retirement retment = mentService.getById(sfzhcx);
				List<Retirefamily> familys = retment.getFamilys();
				for (Retirefamily retirefamily : familys) {
					if(retirefamily.getSfmr().equals("是")){
						family.add(retirefamily);
					}
				}
				mav = new ModelAndView("/retire/map/_address");
				mav.addObject("fam", family);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	/**
	 * 异步提取人员信息
	 * @param response
	 * @param sfzh	根据身份证号查询
	 * @param dzcx 根据输入的地址 查询出对应的地址下有多少人员的信息
	 * @return
	 */
	@RequestMapping(value="ajax",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String ajaxDetails(HttpServletResponse response,HttpServletRequest request,Retirefamily f){
		List<String> lists = new ArrayList<>();
		try{
			int s=0;
			if(f!=null && f.getJtdz()!=null && f.getJtdz().trim().length()>0){
				f.setSfmr("是");
				List<Retirefamily> list = familyService.queryList(f, s, size);
				for(int i =0;i<list.size();i++){
					Retirefamily retirefamily = list.get(i);
					Retirement retirement = mentService.getById((retirefamily.getRet().getSfzh()));
					if(retirement!=null){
						String jtdz = retirement.getFamilys().get(0).getJtdz();
						String xm = retirement.getXm();
						lists.add(xm);
						lists.add(jtdz);
						}
					}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return lists.toString();
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
