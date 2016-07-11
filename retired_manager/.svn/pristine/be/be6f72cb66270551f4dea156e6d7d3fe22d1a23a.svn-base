package cn.uuf.ltxxt.party.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
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
import cn.uuf.domain.Account;
import cn.uuf.domain.CodeLxb;
import cn.uuf.domain.CodeZzmmb;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.ret.Retireparty;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.party.service.RetirepartyService;
import cn.uuf.ltxxt.retire.util.ImportPage;
import cn.uuf.util.DateUtil;
import cn.uuf.util.Paginate;

/**
 * 党员管理
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-13
 */
@Controller
@RequestMapping("{retpartymems:retpartymems;*.?}")
public class PartymemberController extends BaseController{

	private final String LIST_ACTION = "redirect:/retpartymems";
	@Resource
	private RetirepartyService pService;
//	@Resource 
//	private Retirement mentService;
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retirement m,String kssj,String jssj,String parAges){
		ModelAndView mav = new ModelAndView("party/branch/indexmems");
		try{
			Integer parAgeSt=null;
			Integer parAgeEnd=null;
			Integer parAgeEq=null;
			if(StringUtils.isNotEmpty(parAges)){
				String[] parAgerArr = parAges.split(",");
				parAgeSt = Integer.parseInt(parAgerArr[0]);
				parAgeEnd = Integer.parseInt(parAgerArr[1]);
				if(parAgeSt.equals(parAgeEnd)){
					parAgeEq=parAgeEnd;
				}
			}
			mav.addObject("parAges", parAges);
			
			String rdsjSt = "";
			String rdsjEnd = "";
			String rdsjEq = "";
			if(parAgeEq!=null){
				int dqYear = DateUtil.getCurrentYear();
				rdsjEq = (dqYear-parAgeEq)+"";
			}else{
				if(parAgeSt!=null){
					int dqYear = DateUtil.getCurrentYear();
					if((dqYear-parAgeSt)==dqYear){
						rdsjSt = ((dqYear-parAgeSt)+1)+"-00-00";
					}else{
						rdsjSt = ((dqYear-parAgeSt)+1)+"-00-00";
					}
				}
				if(parAgeEnd!=null){
					int dqYear = DateUtil.getCurrentYear();
					rdsjEnd = ((dqYear-parAgeEnd))+"-00-00";
				}
			}
			int s = (page - 1) * size;
			List<Retireparty> all = pService.getAll();
			Long count = mentService.getCount(m,kssj, jssj,"party",rdsjSt,rdsjEnd,rdsjEq);
			List<Retirement> list = mentService.queryList(m, s, size, kssj, jssj,"party",rdsjSt,rdsjEnd,rdsjEq);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("zblist",all);
			mav.addObject("list", list);
			mav.addObject("parAgeSt", parAgeSt);
			mav.addObject("parAgeEnd", parAgeEnd);
			mav.addObject("parAgeEq", parAgeEq);
			mav.addObject("kssj",kssj);
			mav.addObject("jssj",jssj);
			mav.addObject("m",m);
			getCodeInf(mav);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	
	/**
	 * 
	 * 添加党员
	 * @return
	 */
	@RequestMapping(value="{create:create;*.?}")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("party/partymems/create");
		List<Retireparty> all = pService.getAll();
		mav.addObject("zblist",all);
		this.getCodeInf(mav);
		return mav;
	}

	@RequestMapping(value="{save:save;*.?}",method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request, @Valid Retirement m, BindingResult result,RedirectAttributes redAttr) {
		try{
			if(m.getSfzh() != null){
				String splitSfzh = splitSfzh(m.getSfzh());
				Retirement ment = mentService.getById(splitSfzh);
				if(ment.getZzmm()==null){
					Long a = 1415L;
					CodeZzmmb zzmmb = new CodeZzmmb();
					zzmmb.setId(a);
					ment.setZzmm(zzmmb);
				}
				CodeZzmmb codeZzmmb = zzmmService.getById(ment.getZzmm().getId());
				if(!codeZzmmb.getName().equals("中共党员")){
					CodeZzmmb zzmmb = new CodeZzmmb();
					zzmmb.setId(codeZzmmb.getId());
					ment.setZzmm(zzmmb);
				}
				Retireparty party = m.getParty();
				ment.setParty(party);
				ment.setRdsj(m.getRdsj());
				if(m.getRdsj() != null){
					mentService.update(ment);
					redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"添加党员信息成功");
				}else{
					redAttr.addFlashAttribute(Constants.MESSAGE_NAME,ment.getXm()+"添加党员信息失败");
					return new ModelAndView(LIST_ACTION);
				}
			}else{
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"没有身份信息");
			}
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"添加党员失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	/**
	 * 修改第一步：修改时显示的数据
	 * @param sfzh
	 * @return
	 */
	@RequestMapping("/{sfzh}/edit")
	public ModelAndView edit(@PathVariable String sfzh){
		ModelAndView mav = new ModelAndView("party/partymems/update");
		mav.addObject("ret",mentService.getById(sfzh));
		return mav;
	}
	
	@RequestMapping("{update:update;*.?}")
	public ModelAndView update(Retirement m,RedirectAttributes red){
		try{
			if(m.getSfzh() != null && m.getSfzh().length() > 0){
				Retirement ment = mentService.getById(m.getSfzh());
				if(ment.getZzmm()==null){
					Long a = 1415L;
					CodeZzmmb zzmmb = new CodeZzmmb();
					zzmmb.setId(a);
					ment.setZzmm(zzmmb);
				}
				CodeZzmmb codeZzmmb = zzmmService.getById(ment.getZzmm().getId());
				if(!codeZzmmb.getName().equals("中共党员")){
					CodeZzmmb zzmmb = new CodeZzmmb();
					zzmmb.setId(codeZzmmb.getId());
					ment.setZzmm(zzmmb);
				}
				if(ment !=null){
					ment.setRdsj(m.getRdsj());
					mentService.update(ment);
					red.addFlashAttribute(Constants.MESSAGE_NAME,"修改党员信息成功");
				}else
					red.addFlashAttribute(Constants.MESSAGE_NAME,m.getSfzh()+"未找到离退休人员");
			}else
				red.addFlashAttribute(Constants.MESSAGE_NAME,"身份证号不能为空");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	/**
	 * 删除党员信息
	 * @param request
	 * @param redAttr
	 * @param id
	 * @return
	 */
	@RequestMapping("{delete:delete;*.?}")
	public ModelAndView delete(HttpServletRequest request,RedirectAttributes redAttr,String... sfzh){
		try{
			for(int i=0;i<sfzh.length;i++){
				Retirement ment = mentService.getById(sfzh[i]);
				ment.setZzmm(null);
				ment.setParty(null);
				mentService.update(ment);
			}
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
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
	
	/*
	 * 跳转导入
	 */
	@RequestMapping(value="/importexecl")
	public ModelAndView importexecl(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("party/partymems/upload");
		return mav;
	}
	
	@RequestMapping(value="/dcExcel")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView uploadxsl(@RequestParam("uploadFile") MultipartFile uploadFile,HttpServletRequest request, HttpServletResponse response,RedirectAttributes red)throws Exception{
		try{
			Map<String,Retireparty> pms = new LinkedHashMap<String,Retireparty>();
			List<Retireparty> list = pService.getAll();
			for(Retireparty p : list){
				pms.put(p.getId()+"",p);pms.put(p.getDzbmc(),p);
			}
			Map<String,CodeZzmmb> zms = new LinkedHashMap<String,CodeZzmmb>();
			List<CodeZzmmb> lzs = zzmmService.getAll();
			for(CodeZzmmb z : lzs){
				zms.put(z.getCode(),z);zms.put(z.getName(),z);
			}
			Workbook workbook = WorkbookFactory.create(uploadFile.getInputStream());
		    Sheet sheet = workbook.getSheetAt(0);
		    for(int i=1;i<sheet.getLastRowNum()+1;i++){
				Row row = sheet.getRow(i);
				if(row != null){
					Cell cell0 = row.getCell(0);
					Retirement m = null;
					Retireparty p = null;
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
					row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
					//格式：姓名，身份证号，所属支部，政治面貌，入党时间
					if(cell0.getStringCellValue() != null && row.getCell(1) != null && row.getCell(2) != null){
						m = mentService.getById(row.getCell(1).getStringCellValue().trim());
						p = pms.get(row.getCell(2).getStringCellValue().trim());
						if(m != null && p != null){
							m.setParty(p);
							if(row.getCell(3) != null){
								row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
								m.setZzmm(zms.get(row.getCell(3).getStringCellValue().trim()));
							}
							if(row.getCell(4) != null){
								row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
								m.setRdsj(row.getCell(4).getStringCellValue().trim());
							}
							mentService.update(m);
							p.addMents(m);
							pService.update(p);
						}else{
							red.addFlashAttribute(Constants.MESSAGE_NAME,"支部代码未找到党支部或身份号未找到人员");
							return new ModelAndView(LIST_ACTION);
						}
					}
				}
		    }
			red.addFlashAttribute(Constants.MESSAGE_NAME,"导入成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"导入失败,支部代码未找到党支部或身份号未找到人员");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/doExport")
	public ModelAndView exportExcel(Retirement r,String kssj,String jssj,HttpServletRequest request,HttpServletResponse response)throws Exception{
		try {
			List<Retirement>list = mentService.queryList(r, 0, Integer.MAX_VALUE-1,kssj,jssj,"party",null,null,null);
			String[] headers = { "身份证", "姓名", "性别", "出生日期","单位名称" };
			String fileName = "drxs"+DateUtil.getMSDateTime(new Date(), DateUtil.DEFAULT_DATEMS_FORMAT);
			response.setHeader("Content-Disposition", "attachment;filename="+fileName+".xls");// 设定输出文件头
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");// 定义输出类型
			OutputStream out = response.getOutputStream();
			ExportExcel exportExcel = new ExportExcel();
			exportExcel.exportExcel("导出人员",headers, list, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 异步提取人员信息
	 * @param response
	 * @param sfzh
	 * @return
	 */
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxDetail(HttpServletResponse response,String sfzh){
		ModelAndView mav = new ModelAndView("party/branch/_info");
		try{
			Retirement m = mentService.getById(sfzh);
			mav.addObject("ret",m);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
}

