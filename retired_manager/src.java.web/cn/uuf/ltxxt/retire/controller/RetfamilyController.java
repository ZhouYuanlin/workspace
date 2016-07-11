package cn.uuf.ltxxt.retire.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.excelutils.ExcelUtils;

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
import cn.uuf.ltxxt.system.code.service.CodeDwbService;
import cn.uuf.util.CleanStringUtil;
import cn.uuf.util.Paginate;

/**
 * 家庭成员
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-25
 */
@Controller
@RequestMapping("{retfamily:retfamily;*.?}")
public class RetfamilyController extends BaseController{

	private final String LIST_ACTION = "redirect:/retfamily";
	@Resource
	private RetirefamilyService faService;
	@Resource
	private RetirememberService memService;
	@Resource
	private CodeDwbService codeDwbService;
	
	@RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="1")Integer page,Retirement f){
		ModelAndView mav = new ModelAndView("retire/family/index");
		try{
			int s = (page -1) * size;
			if(hasRoleScope().equals(Constants.INFOYX)){
				if(codeDwbService.getById(getUser().getCodedwb().getId()).getSfejdw().equals(Constants.HASYES)){
					f.setDwb(getUser() != null ? getUser().getCodedwb() : null);
				}
			}
			Long count = mentService.getCount(f,null,null,null,null,null,null);
			List<Retirement> list = mentService.queryList(f, s, size,null,null,null,null,null,null);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("paginate", paginate);
			mav.addObject("list", list);
			mav.addObject("w",f);
			getCodeInf(mav);
		}catch(Exception e){
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据！");
		}
		return mav;
	}
	
	@RequestMapping(value="/{sfzh}/create")
	public ModelAndView create(@PathVariable String sfzh){
		ModelAndView mav = new ModelAndView("retire/family/create");
		try{
			mav.addObject("f",mentService.getById(sfzh));
		}catch(Exception e){
			return new ModelAndView(LIST_ACTION);
		}
		return mav;
	}
	
	@RequestMapping(value="{save:save;*.?}",method=RequestMethod.POST)
	public ModelAndView save(String sfzh,@Valid Retirefamily f,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					red.addFlashAttribute("f",f);
					return new ModelAndView("redirect:/retfamily/create");
				}
			}
			Retirement m = mentService.getById(sfzh);
			f.setRet(m);
			faService.save((Retirefamily) CleanStringUtil.CleanObj(f,new Retirefamily()));
			if(f.getSfmr().equals(Constants.HASYES)){//是否默认地址(只能有一个为是,改变一个其它都为否)
				String sql = "update uf_ltx_family r set r.sfmr='否' where r.ret_sfzh='"+m.getSfzh()+"' and r.id <> "+f.getId();
				faService.updateSql(sql);
			}
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加家庭地址成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加家庭地址失败");
		}
		return new ModelAndView("redirect:/retfamily/"+sfzh+"/detail");
	}
	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("retire/family/update");
		try{
			mav.addObject("f",faService.getById(id));
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	@RequestMapping("{update:update;*.?}")
	public ModelAndView update(String sfzh,@Valid Retirefamily f,BindingResult res,RedirectAttributes red){
		try{
			if(res.hasErrors()){
				for(ObjectError e : res.getAllErrors()){
					red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
					return edit(f.getId());
				}
			}
			f.setRet(mentService.getById(sfzh));
			faService.update(f);
			if(f.getSfmr().equals(Constants.HASYES)){//是否默认地址(只能有一个为是,改变一个其它都为否)
				String sql = "update uf_ltx_family r set r.sfmr='否' where r.ret_sfzh='"+sfzh+"' and r.id <> "+f.getId();
				faService.updateSql(sql);
			}
			red.addFlashAttribute(Constants.MESSAGE_NAME,"更新成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"更新失败");
		}
		return new ModelAndView("redirect:/retfamily/"+sfzh+"/detail");
	}
	/**
	 * 新加家庭成员为某人
	 * @param sfzh
	 * @return
	 */
	@RequestMapping(value="/{sfzh}/addmember")
	public ModelAndView createmember(@PathVariable String sfzh){
		ModelAndView mav = new ModelAndView("retire/family/cmember");
		try{
			mav.addObject("f",mentService.getById(sfzh));
		}catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView(LIST_ACTION);
		}
		return mav;
	}
	/**
	 * 添加家庭成员
	 * @param sfzh
	 * @param r
	 * @param res
	 * @param red
	 * @return
	 */
	@RequestMapping(value="{savemem:savemem;*.?}",method=RequestMethod.POST)
	public ModelAndView savemem(String sfzh,@Valid Retiremember r,BindingResult res,RedirectAttributes red){
		if(res.hasErrors()){
			for(ObjectError e : res.getAllErrors()){
				red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
				return new ModelAndView(LIST_ACTION);
			}
		}
		try{
			Retirement m = mentService.getById(sfzh);
			r.setRet(m);
			memService.save(r);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加家庭成员成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"添加成员失败");
		}
		return new ModelAndView("redirect:/retfamily/"+sfzh+"/detail");
	}
	/**
	 * 修改家庭成员
	 * @param id
	 * @return
	 */
	@RequestMapping("/{id}/modify")
	public ModelAndView modify(@PathVariable Long id){
		ModelAndView mav = new ModelAndView("retire/family/umember");
		try{
			mav.addObject("f",memService.getById(id));
		}catch(Exception e){}
		return mav;
	}
	/**
	 * 更新家庭成员信息
	 * @param sfzh
	 * @param r
	 * @param res
	 * @param red
	 * @return
	 */
	@RequestMapping(value="{updatemem:updatemem;*.?}",method=RequestMethod.POST)
	public ModelAndView update(String sfzh,@Valid Retiremember r,BindingResult res,RedirectAttributes red){
		try{
			if(sfzh != null){
				if(res.hasErrors()){
					for(ObjectError e : res.getAllErrors()){
						red.addFlashAttribute(Constants.MESSAGE_NAME,e.getDefaultMessage());
						return new ModelAndView("/retfamily/"+r.getId()+"/modify");
					}
				}
				Retirement m = new Retirement();
				m.setSfzh(sfzh);
				r.setRet(m);
				memService.update(r);
				red.addFlashAttribute(Constants.MESSAGE_NAME,"修改家庭成员成功");
			}else
				red.addFlashAttribute(Constants.MESSAGE_NAME,"身份证号为空不能修改");
		}catch(Exception e){
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改家庭成员失败");
		}
		return new ModelAndView("redirect:/retfamily/"+sfzh+"/detail");
	}
	/**
	 * 显示详情
	 * @param sfzh
	 * @return
	 */
	@RequestMapping("/{sfzh}/detail")
	public ModelAndView detail(@PathVariable String sfzh){
		ModelAndView mav = new ModelAndView("retire/family/detail");
		try{
			mav.addObject("m",mentService.getById(sfzh));
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("{delete:delete;*.?}")
	public ModelAndView delete(RedirectAttributes red,Long... id){
		try{
			faService.delete(id);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"删除失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	/**
	 * 删除家庭住址信息
	 * @param id
	 * @return
	 */
	@RequestMapping("{ajaxremove:ajaxremove;*.?}")
	public ModelAndView ajaxDelete(Long id){
		ModelAndView mav = new ModelAndView("retire/family/_info");
		try{
			Retirefamily f = faService.getById(id);
			String sfzh = f.getRet().getSfzh();
			faService.delete(id);
			mav.addObject("m",mentService.getById(sfzh));
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	/**
	 * 删除家庭成员
	 * @param id
	 * @return
	 */
	@RequestMapping("{ajaxcutmem:ajaxcutmem;*.?}")
	public ModelAndView ajaxCutmem(Long id){
		ModelAndView mav = new ModelAndView("retire/family/_jtcy");
		try{
			Retiremember m = memService.getById(id);
			String sfzh = m.getRet().getSfzh();
			memService.delete(id);
			mav.addObject("m",mentService.getById(sfzh));
		}catch(Exception e){}
		return mav;
	}
	
	/*
	 * 跳转导入家庭成员
	 */
	@RequestMapping("{importjtcy:importjtcy;*.?}")
	public ModelAndView importjtcy(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("retire/family/uploadjtcy");
		return mav;
	}
	/**
	 * 跳转家庭住址
	 * @param xzmob
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("{importjtzz:importjtzz;*.?}")
	public ModelAndView importexecl(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("retire/family/uploadjtzz");
		return mav;
	}
	/**
	 * 家庭住址导入
	 * @param uploadFile
	 * @param request
	 * @param response
	 * @param red
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("{dcjtzzExcel:dcjtzzExcel;*.?}")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView uploadjtzz(@RequestParam("uploadFile") MultipartFile uploadFile,HttpServletRequest request, HttpServletResponse response,RedirectAttributes red)throws Exception{
		try{
			Workbook workbook = WorkbookFactory.create(uploadFile.getInputStream());
			Sheet sheet = workbook.getSheetAt(0);
			for(int i=1;i<sheet.getLastRowNum()+1;i++){
				Row row = sheet.getRow(i);
				Retirement m = null;
				Retirefamily f = new Retirefamily();
				if(row != null){
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if(row.getCell(0).getStringCellValue() != null){
						m = mentService.getById(row.getCell(0).getStringCellValue());
						if(m != null && row.getCell(1) != null){
							f.setRet(m);
							row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
							f.setJtdz(row.getCell(1).getStringCellValue());
							if(row.getCell(2) != null){
								row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
								f.setYzbm(row.getCell(2).getStringCellValue());
							}
							if(row.getCell(3) != null){
								row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
								f.setJtdh(row.getCell(3).getStringCellValue());
							}
							if(row.getCell(4) != null){
								row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
								f.setLxdh(row.getCell(4).getStringCellValue());
							}
							if(row.getCell(5) != null){
								row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
								f.setSfmr(row.getCell(5).getStringCellValue());
							}
							if(row.getCell(6) != null){
								row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
								f.setDescription(row.getCell(6).getStringCellValue());
							}
							faService.save(f);
							if(f.getSfmr() != null && f.getSfmr().equals(Constants.HASYES)){//是否默认地址(只能有一个为是,改变一个其它都为否)
								String sql = "update uf_ltx_family r set r.sfmr='否' where r.ret_sfzh='"+m.getSfzh()+"' and r.id <> "+f.getId();
								faService.updateSql(sql);
							}
						}
					}
				}
			}
			red.addFlashAttribute(Constants.MESSAGE_NAME,"导入成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"导入失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	/**
	 * 导入家庭成员
	 * @param uploadFile
	 * @param request
	 * @param response
	 * @param red
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("{dcjtcyExcel:dcjtcyExcel;*.?}")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView uploadjtcy(@RequestParam("uploadFile") MultipartFile uploadFile,HttpServletRequest request, HttpServletResponse response,RedirectAttributes red)throws Exception{
		try{
			Workbook workbook = WorkbookFactory.create(uploadFile.getInputStream());
			Sheet sheet = workbook.getSheetAt(0);
			for(int i=1;i<sheet.getLastRowNum()+1;i++){
				Row row = sheet.getRow(i);
				Retirement m = null;
				Retiremember f = new Retiremember();
				if(row != null){
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if(row.getCell(0).getStringCellValue() != null){
						m = mentService.getById(row.getCell(0).getStringCellValue());
						if(m != null && row.getCell(1) != null){
							f.setRet(m);
							row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
							f.setMxm(row.getCell(1).getStringCellValue());
							if(row.getCell(2) != null){
								row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
								f.setMgx(row.getCell(2).getStringCellValue());
							}
							if(row.getCell(3) != null){
								row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
								f.setMgzdw(row.getCell(3).getStringCellValue());
							}
							if(row.getCell(4) != null){
								row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
								f.setMzw(row.getCell(4).getStringCellValue());
							}
							if(row.getCell(5) != null){
								row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
								f.setMdh(row.getCell(5).getStringCellValue());
							}
							if(row.getCell(6) != null){
								row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
								f.setMjzgx(row.getCell(6).getStringCellValue());
							}
							this.memService.save(f);
						}
					}
				}
			}
			red.addFlashAttribute(Constants.MESSAGE_NAME,"导入成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"导入失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("{downloadcy:downloadcy;*.?}")
	public void downLoadcy(HttpServletRequest request, HttpServletResponse response){
		try {
			String file = request.getSession().getServletContext().getRealPath("/") + "model/retjtcy.xls";
			response.reset(); 
			response.setContentType("application/vnd.ms-excel"); 
			response.setHeader("Content-Disposition","attachment;filename=retjtcy.xls"); 			
			ExcelUtils.export(file, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ;
	}
	@RequestMapping("{downloadzz:downloadzz;*.?}")
	public void downLoadzz(HttpServletRequest request, HttpServletResponse response){
		try {
			String file = request.getSession().getServletContext().getRealPath("/") + "model/retjtzz.xls";
			response.reset(); 
			response.setContentType("application/vnd.ms-excel"); 
			response.setHeader("Content-Disposition","attachment;filename=retjtzz.xls"); 			
			ExcelUtils.export(file, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ;
	}
}

