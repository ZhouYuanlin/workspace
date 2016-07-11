package cn.uuf.stu.framework.service;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import cn.uuf.stu.framework.common.ExcelDto;

public interface IExcelService {
	Workbook get(ExcelDto excelDto,Workbook workbook,Sheet sheet) throws Exception;
	void export(HttpServletResponse response, ExcelDto excelDto,
			Workbook workbook, Sheet sheet) throws Exception;
	
}
