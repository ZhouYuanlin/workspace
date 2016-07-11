package cn.uuf.ltxxt.party.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import cn.uuf.domain.Retirement;

/**
 * 类说明	：导出离退休人员
 */
public class ExportExcel {

	public ExportExcel() {

	}
	/**
	 * 根据条件导出离退休人员
	 * @param title
	 * @param headers
	 * @param dataset
	 * @param out
	 * @return: void
	 */
	public void exportExcel(String title, String[] headers,
			List<Retirement> dataset, OutputStream out) {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(30);
		HSSFCellStyle style = creatStyle(workbook);
		WriteExcel(sheet,headers,dataset,workbook,style,out);

	}
	/**
	 * 具体生成excel的数据
	 * @author: pgf
	 * @creation: Sep 24, 2013 1:29:54 PM
	 * @param sheet
	 * @param headers
	 * @param dataset
	 * @param workbook
	 * @param style
	 * @param out
	 * @return: void
	 */
	public void WriteExcel(HSSFSheet sheet,String[] headers,
			List<Retirement> dataset,HSSFWorkbook workbook,HSSFCellStyle style, OutputStream out){
		try {
			// 产生表格标题行
			HSSFRow row = sheet.createRow(0);
			for (int i = 0; i < headers.length; i++) {
				HSSFCell cell = row.createCell(i);
//				cell.setCellStyle(style);
				cell.setCellValue(headers[i]);
			}
			// 遍历集合数据，产生数据行
			int index = 1;
			for (int i = 0; i < dataset.size(); i++) {
				row = sheet.createRow(index);
				Retirement r = dataset.get(i);
				HSSFFont font3 = workbook.createFont();
				font3.setColor(HSSFColor.BLUE.index);
				for (int j = 0; j < headers.length; j++) {
					HSSFCell cell = row.createCell(j);
//					cell.setCellStyle(style);
					switch (j) {
					case 0:
						cell.setCellValue(r.getSfzh() != null ? r.getSfzh() : "");
						break;
					case 1:
						cell.setCellValue(r.getXm() != null ? r.getXm() : "");
						break;
					case 2:
						cell.setCellValue(r.getXb() != null ? r.getXb() : "");
						break;
					case 3:
						cell.setCellValue(r.getCsrq() != null ? r.getCsrq(): "");
						break;
					case 4:
						cell.setCellValue(r.getDwb() != null ? r.getDwb().getName(): "");
						break;
					case 5:
						cell.setCellValue(r.getParty() != null ? r.getParty().getDzbmc(): "");
						break;
					case 6:
						cell.setCellValue(r.getZwb() != null ? r.getZwb().getName(): "");
						break;
					case 7:
						cell.setCellValue(r.getZjb() != null ? r.getZjb().getName(): "");
						break;
					case 8:
						cell.setCellValue(r.getZzmm() != null ? r.getZzmm().getName(): "");
						break;
					case 9:
						cell.setCellValue(r.getLxb() != null ? r.getLxb().getName(): "");
						break;
					case 10:
						cell.setCellValue(r.getJg() != null ? r.getJg(): "");
						break;
					case 11:
						cell.setCellValue(r.getFyzk() != null ? r.getFyzk(): "");
						break;
					case 12:
						cell.setCellValue(r.getGrxl() != null ? r.getGrxl(): "");
						break;
					case 13:
						cell.setCellValue(r.getGrxw() != null ? r.getGrxw(): "");
						break;
					case 14:
						cell.setCellValue(r.getCsrq() != null ? r.getCsrq(): "");
						break;
					case 15:
						cell.setCellValue(r.getCsrq() != null ? r.getCsrq(): "");
						break;
					case 16:
						cell.setCellValue(r.getSfdj() != null ? r.getSfdj(): "");
						break;
					case 17:
						cell.setCellValue(r.getSfgg() != null ? r.getSfgg(): "");
						break;
					case 18:
						cell.setCellValue(r.getSssn()!= null ? r.getSssn(): "");
						break;
					case 19:
						cell.setCellValue(r.getSfyfz() != null ? r.getSfyfz(): "");
						break;
					case 20:
						cell.setCellValue(r.getEmail() != null ? r.getEmail(): "");
						break;
					case 21:
						cell.setCellValue(r.getWeix() != null ? r.getWeix(): "");
						break;
					}

				}
				index++;
			}
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 创建一个生成excel的样式
	 * @author: pgf
	 * @creation: Sep 25, 2013 10:49:43 AM
	 * @param workbook
	 * @return: HSSFCellStyle
	 */
	public HSSFCellStyle creatStyle (HSSFWorkbook workbook){
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		return style;
	}
}
