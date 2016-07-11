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
import cn.uuf.domain.CodeTjb;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.code.service.CodeGjtjbService;
import cn.uuf.util.Paginate;

/**
 * 高级查询表
 * @author Suntingwen
 *
 */
@Controller
@RequestMapping("{codegjcxb:codegjcxb;*.?}")
public class CodeGjtjbController extends BaseController{

	private final String LIST_ACTION = "redirect:/codegjcxb";
	
	@Resource
	CodeGjtjbService gjtjbService;
	
	
	@RequestMapping
	public ModelAndView index(Integer page,CodeTjb tjb,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("code/gjcxb/index");
		try{
			page = page == null || page < 0 ? 1 : page;
			int start = (page - 1) * size;
			Long count = gjtjbService.getCount(tjb);
			List<CodeTjb> list = gjtjbService.queryList(tjb, start, size);
			paginate = new Paginate(list, count, size, page);
			mav.addObject("tjb", tjb);
			mav.addObject("list",list);
			mav.addObject("paginate",paginate);
		}catch(Exception e){
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
			e.printStackTrace();
		}
		mav.addObject("url","/codegjcxb");
		return mav;
	}
	
	
	@RequestMapping("create")
	public ModelAndView create( CodeTjb tjb,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("/code/gjcxb/create");
		return mav;
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ModelAndView save(@Valid CodeTjb tjb,BindingResult binding,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redAttr)throws Exception{
		try{
			if(binding.hasErrors()){
				List<ObjectError> ls = binding.getAllErrors();
				String error = "";
				for(ObjectError oe : ls){
					error = oe.getDefaultMessage();
				}
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME, error);
				redAttr.addFlashAttribute("tjb", tjb);
				return new ModelAndView("redirect:/codegjcxb/create");
			}
			gjtjbService.save(tjb);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加成功！");
			/*this.writer("添加民族表",request.getRemoteAddr(),this.getCurrentUser().getUsername());*/
		}catch(Exception e){
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加失败！");
		}
		return new ModelAndView(LIST_ACTION);
	}
	@RequestMapping(value="/{id}/edit")
	public ModelAndView modify(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("code/gjcxb/update");
		try{
			CodeTjb tjb = gjtjbService.getById(id);
			mav.addObject("tjb",tjb);
		}catch(Exception e){
			e.printStackTrace();
		}
		return  mav;
	}
	
	@RequestMapping("update")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response,@Valid CodeTjb tjb,BindingResult result,RedirectAttributes redAttr)throws Exception{
		try{
			if(result.hasErrors()){
				ModelAndView mav = new ModelAndView("/code/gjcxb/update");
				List<ObjectError> ls = result.getAllErrors();
				String error = "";
				for(ObjectError oe : ls){
					error = oe.getDefaultMessage();
				}
				mav.addObject(Constants.MESSAGE_NAME, error);
				mav.addObject("tjb",tjb);
				return mav;
			}
			gjtjbService.update(tjb);
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
			
			gjtjbService.delete(id);
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
		ModelAndView mav = new ModelAndView("code/gjcxb/upload");
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
				CodeTjb tjb = new CodeTjb();
				if(row != null){
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					if(row.getCell(0).getStringCellValue() != null){
						tjb.setCode(row.getCell(0).getStringCellValue());
						if( row.getCell(1) != null){
							row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
							tjb.setTjbywm(row.getCell(1).getStringCellValue());
						}
						if( row.getCell(2) != null){
							row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
							tjb.setTjbzwm(row.getCell(2).getStringCellValue());
						}
						if( row.getCell(3) != null){
							row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
							tjb.setBz(row.getCell(3).getStringCellValue());
						}
						gjtjbService.save(tjb);
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
	public void exportExcel(CodeTjb tjb,HttpServletResponse response){
		try{
			Workbook wb = new HSSFWorkbook();//创建工作表
			Sheet createSheet = wb.createSheet("sheet1");//创建sheet
			Row row = createSheet.createRow(0);//创建标题
			String[] cellTitle = {
				"代码","表英文名","表中文名","备注"};
			for (int i = 0; i < cellTitle.length; i++) {
				createSheet.setColumnWidth(i, 3500);
				Cell createCell = row.createCell(i);
				createCell.setCellValue(cellTitle[i]);
			}
			List<CodeTjb> list = gjtjbService.queryList(tjb,0,Integer.MAX_VALUE);
			int s = 1;
			for(CodeTjb tj : list){
				Row dataRow = createSheet.createRow((short) s);
				for(int i = 0;i<cellTitle.length;i++){
					Cell da = dataRow.createCell(i);
					switch (i) {
						case 0:
							da.setCellValue(tj.getCode());
							break;
						case 1:
							da.setCellValue(tj.getTjbywm());
							break;
						case 2:
							da.setCellValue(tj.getTjbzwm());
							break;
						case 3:
							da.setCellValue(tj.getBz());
							break;
					}
				}
				s++;
			}
			
			Date date=new Date(System.currentTimeMillis());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
			response.setHeader("Content-Disposition", "attachment;filename="+sdf.format(date)+".xls");// 设定输出文件头
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
			String file = request.getSession().getServletContext().getRealPath("/") + "model/codegjcxb.xls";
			response.reset();
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition","attachment;filename=codegjcxb.xls");
			ExcelUtils.export(file, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ;
	}
}

