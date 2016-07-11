package cn.uuf.stu.framework.service.impl;

import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import cn.uuf.stu.framework.common.ExcelDto;
import cn.uuf.stu.framework.common.ExcelVo;
import cn.uuf.stu.framework.service.IExcelService;
import cn.uuf.stu.framework.util.DateUtils;

/**
 * 
* <p>标题：excel 服务类</p>
* <p>简介：</p>
* @author tangp
* @date 2016年1月13日 下午3:24:44
 */
@Service(value="excelService")
public class ExcelServiceImpl implements IExcelService {
	
	@Override
	public void export(HttpServletResponse response, ExcelDto excelDto,
			Workbook workbook, Sheet sheet) throws Exception {
		String fileName =excelDto.getSheetName()+DateUtils.getFormatDateString(DateUtils.DEFAULT_DATE_FORMAT, new Date());
		Workbook workbook2 = get(excelDto, workbook, sheet);
		response.setHeader("Content-Disposition", "attachment;filename="+fileName+".xls");// 设定输出文件头
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");// 定义输出类型
		OutputStream out = response.getOutputStream();			
		workbook2.write(out);
		out.flush();
		out.close();
	}
	
	
	@Override
	public Workbook get(ExcelDto excelDto, Workbook workbook, Sheet sheet) throws Exception {
		int startRow = excelDto.getStartRow(); //标题开始行
		Map<String, ExcelVo> map = excelDto.getMap();
		List<Object> excelDatas = excelDto.getList();
		CellStyle cs = workbook.createCellStyle();
		cs.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直   
		cs.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		cs.setBorderTop(HSSFCellStyle.SOLID_FOREGROUND);
		cs.setBorderLeft(HSSFCellStyle.SOLID_FOREGROUND);
		cs.setBorderRight(HSSFCellStyle.SOLID_FOREGROUND);
		cs.setBorderBottom(HSSFCellStyle.SOLID_FOREGROUND);
		
		Font font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		cs.setFont(font);
		
		//总数 签名公章 底部样式
		CellStyle bot = workbook.createCellStyle();
		bot.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		bot.setAlignment(HSSFCellStyle.ALIGN_RIGHT);// 水平
		bot.setFont(font);
		
		/*
		CellStyle bot1 = workbook.createCellStyle();
		bot1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		bot1.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 水平
		bot1.setFont(font);
		*/
		// 设置表头样式
		CellStyle cs0 = workbook.createCellStyle();
		cs0.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		cs0.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平

		Font font0 = workbook.createFont();
		font0.setFontHeightInPoints((short) 16);// 设置字体大小
		font0.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		cs0.setFont(font0);
		
		//设置普通单元格边框样式
		CellStyle csbk = workbook.createCellStyle();
		csbk.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		csbk.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		csbk.setBorderTop(HSSFCellStyle.SOLID_FOREGROUND);
		csbk.setBorderLeft(HSSFCellStyle.SOLID_FOREGROUND);
		csbk.setBorderRight(HSSFCellStyle.SOLID_FOREGROUND);
		csbk.setBorderBottom(HSSFCellStyle.SOLID_FOREGROUND);
		
		Row row0 = sheet.createRow(startRow);
		row0.setHeightInPoints(30);//设置行高
		sheet.addMergedRegion(new CellRangeAddress(startRow,(short)startRow,0,(short)(map.size()-1))); //合并单元格
		Cell cell0 = row0.createCell(0);
		cell0.setCellStyle(cs0);
		cell0.setCellValue(excelDto.getSheetTitle());
		
		Row row = sheet.createRow(startRow+1);
		for(int i=0;i<map.size();i++){
			sheet.setColumnWidth(i, 5000);//设置列宽
			Cell cell = row.createCell(i);
			cell.setCellStyle(cs);
			cell.setCellValue(map.get(i+"").getSxz());
		}
		int mapSize = map.size();
		for(int i=0;i<excelDatas.size();i++){
			Row dataRow = sheet.createRow(i+startRow+2);
			row0.setHeightInPoints(20);
			Object object = excelDatas.get(i);
				for(int j=0;j<mapSize;j++){
					ExcelVo excelVo = map.get(j+"");
					Object proValue = PropertyUtils.getNestedProperty(object, excelVo.getSxm());
					Cell cell = dataRow.createCell(j);
					cell.setCellStyle(csbk);
					cell.setCellValue(proValue != null ? proValue.toString() : "");
				}
		}
		
		//负责人签字   公章
		Row fzrRow = sheet.createRow(excelDatas.size()+6);
		Cell fzrcell = fzrRow.createCell(excelDto.getFzrqzCell());
		fzrcell.setCellStyle(bot);
		fzrcell.setCellValue("负责人签字：");
		Row gzRow = sheet.createRow(excelDatas.size()+7);
		gzRow.setHeightInPoints(20);
		Cell gzcell = gzRow.createCell(excelDto.getGzCell());
		gzcell.setCellStyle(bot);
		gzcell.setCellValue("公章：");
		return workbook;
	}

	

}
