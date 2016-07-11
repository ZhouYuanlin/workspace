package cn.uuf.stu.framework.common;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 
* <p>标题：excel 工具类</p>
* <p>简介：</p>
* @author tangp
* @date 2016年1月13日 下午8:29:02
 */
public class ExcelUtils {
	
	/**
	 * 普通列的样式
	 * @param workbook
	 * @return
	 */
	public static CellStyle getCellStyle(Workbook workbook){
		Font font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		CellStyle bot = workbook.createCellStyle();
		bot.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直   
		bot.setAlignment(HSSFCellStyle.ALIGN_LEFT);// 水平
		bot.setFont(font);
		return bot;
	}
	
	/**
	 * 标题列的样式
	 * @param workbook
	 * @return
	 */
	public static CellStyle getCellTitleStyle(Workbook workbook){
		Font font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		CellStyle bot = workbook.createCellStyle();
		bot.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直   
		bot.setAlignment(HSSFCellStyle.ALIGN_RIGHT);// 水平
		bot.setFont(font);
		return bot;
	}
	
	

}
