package cn.uuf.ltxxt.system.code.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sf.excelutils.ExcelUtils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import cn.uuf.domain.CodeLxb;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.code.service.CodeLxbService;
import cn.uuf.util.Paginate;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Controller
@RequestMapping("{codelxb:codelxb;*.?}")
public class CodeLxbController extends BaseController{

	private final String LIST_ACTION = "redirect:/codelxb";
	@Resource
	CodeLxbService lxbService;
	
	@RequestMapping
	public ModelAndView index(Integer page,CodeLxb lxb,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("code/lxb/index");
		try{
			page = page == null || page < 0 ? 1 : page;
			int start = (page - 1) * size;
			Long count = lxbService.getCount(lxb);
			List<CodeLxb> list = lxbService.queryList(lxb, start, size);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("lxb", lxb);
			mav.addObject("list",list);
			mav.addObject("paginate",paginate);
		}catch(Exception e){
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
			e.printStackTrace();
		}
		mav.addObject("url","/lxb");
		return mav;
	}
	@RequestMapping("create")
	public ModelAndView create( CodeLxb lxb,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("code/lxb/create");
		return mav;
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ModelAndView save(@Valid CodeLxb lxb,BindingResult binding,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redAttr)throws Exception{
		try{
			if(binding.hasErrors()){
				List<ObjectError> ls = binding.getAllErrors();
				String error = "";
				for(ObjectError oe : ls){
					error = oe.getDefaultMessage();
				}
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME, error);
				redAttr.addFlashAttribute("lxb", lxb);
				return new ModelAndView("redirect:/codelxb/create");
			}
			lxbService.save(lxb);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加成功！");
			/*this.writer("添加民族表",request.getRemoteAddr(),this.getCurrentUser().getUsername());*/
		}catch(Exception e){
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加失败！");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping(value="/{id}/edit")
	public ModelAndView modify(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("code/lxb/update");
		try{
			CodeLxb lxb = lxbService.getById(id);
			mav.addObject("lxb",lxb);
		}catch(Exception e){
			e.printStackTrace();
		}
		return  mav;
	}
	
	@RequestMapping("update")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response,@Valid CodeLxb lxb,BindingResult result,RedirectAttributes redAttr)throws Exception{
		try{
			if(result.hasErrors()){
				ModelAndView mav = new ModelAndView("code/lxb/update");
				List<ObjectError> ls = result.getAllErrors();
				String error = "";
				for(ObjectError oe : ls){
					error = oe.getDefaultMessage();
				}
				mav.addObject(Constants.MESSAGE_NAME, error);
				mav.addObject("lxb",lxb);
				return mav;
			}
			lxbService.update(lxb);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "修改成功！");
			/*this.writer("修改民族表",request.getRemoteAddr(),this.getCurrentUser().getUsername());*/
		}catch(Exception e){
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "修改失败！");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping(value="/delete")
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redAttr,Long... id)throws Exception{
		try{
			lxbService.delete(id);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除成功！");
			/*this.writer("删除民族",request.getRemoteAddr(),this.getCurrentUser().getUsername());*/
		}catch(Exception e){
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除失败！");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	/*
	 * 跳转导入
	 */
	@RequestMapping(value="/importexecl")
	public ModelAndView importexecl(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("code/lxb/upload");
		return mav;
	}
	
	@RequestMapping("{dcExcel:dcExcel;*.?}")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView uploadxsl(@RequestParam("uploadFile") MultipartFile uploadFile,HttpServletRequest request, HttpServletResponse response,RedirectAttributes red)throws Exception{
		try{
			Workbook workbook = WorkbookFactory.create(uploadFile.getInputStream());
			Sheet sheet = workbook.getSheetAt(0);
			for(int i=1;i<sheet.getLastRowNum()+1;i++){
				Row row = sheet.getRow(i);
				CodeLxb p = new CodeLxb();
				if(row != null){
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if(row.getCell(0).getStringCellValue() != null){
						p.setCode(row.getCell(0).getStringCellValue());
							if( row.getCell(1) != null){
								row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
								p.setName(row.getCell(1).getStringCellValue());
							}
							if( row.getCell(2) != null){
								row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
								p.setBz(row.getCell(2).getStringCellValue());
							}
							lxbService.save(p);
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
	 * 导出到excel
	 * @param m
	 * @param response
	 * @return
	 */
	@RequestMapping("{export:export;*.?}")
	public void exportExcel(CodeLxb p,HttpServletResponse response){
		try{
			Workbook wb = new HSSFWorkbook();//创建工作表
			Sheet createSheet = wb.createSheet("sheet1");//创建sheet
			Row row = createSheet.createRow(0);//创建标题
			String[] cellTitle = {
				"代码","名称","备注"};
			for (int i = 0; i < cellTitle.length; i++) {
				createSheet.setColumnWidth(i, 3500);
				Cell createCell = row.createCell(i);
				createCell.setCellValue(cellTitle[i]);
			}
			List<CodeLxb> list = lxbService.queryList(p,0,Integer.MAX_VALUE);
			int s = 1;
			for(CodeLxb r : list){
				Row dataRow = createSheet.createRow((short) s);
				for(int i = 0;i<cellTitle.length;i++){
					Cell da = dataRow.createCell(i);
					switch (i) {
						case 0:
							da.setCellValue(r.getCode());
							break;
						case 1:
							da.setCellValue(r.getName());
							break;
						case 2:
							da.setCellValue(r.getBz());
							break;
					}
				}
				s++;
			}
			
			Date d=new Date(System.currentTimeMillis());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
			response.setHeader("Content-Disposition", "attachment;filename="+sdf.format(d)+".xls");// 设定输出文件头
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");// 定义输出类型
			OutputStream out = response.getOutputStream();
			wb.write(out);
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 下载模板
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="download",method = RequestMethod.POST)
	public void downLoad(HttpServletRequest request, HttpServletResponse response){
		try {
			String file = request.getSession().getServletContext().getRealPath("/") + "model/codelxb.xls";
			response.reset(); 
			response.setContentType("application/vnd.ms-excel"); 
			response.setHeader("Content-Disposition","attachment;filename=lxb.xls"); 			
			ExcelUtils.export(file, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ;
	}
}

