package cn.uuf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class Doc2HtmlUtil {
	static String soffice_host = "127.0.0.1";
	static String soffice_port = "8100";

	/**
	 * 转换文件
	 * @param fromFileInputStream
	 * @throws FileNotFoundException 
	 * */
	public static String doc2Html(String inputFilePath, String outputFolder) throws FileNotFoundException {
		File inputFile = new File(inputFilePath);
		if (!inputFile.exists()) {
			throw new FileNotFoundException("要转换的文件不存在：" + inputFilePath);
		}
		File toFileFolder = new File(outputFolder);
		if (!toFileFolder.exists()) {
			toFileFolder.mkdirs();
		}
		
		InputStream fromFileInputStream = new FileInputStream(inputFile);
		
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
//		String timesuffix = sdf.format(date);
		
//		String htmFileName = inputFile.getName().substring(0, inputFile.getName().lastIndexOf(".")) + ".html";
//
//		File htmlOutputFile = new File(toFileFolder.toString() + File.separatorChar + htmFileName);
//		File docInputFile = new File(toFileFolder.toString() + File.separatorChar + inputFile.getName());
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timesuffix = sdf.format(date);
		String htmFileName = "htmlfile" + timesuffix + ".html";
		String docFileName = "docfile" + timesuffix + inputFilePath.substring(inputFilePath.lastIndexOf("."));

		File htmlOutputFile = new File(toFileFolder.toString() + File.separatorChar + htmFileName);
		File docInputFile = new File(toFileFolder.toString() + File.separatorChar + docFileName);
		
		/**
		 * 由fromFileInputStream构建输入文件
		 * */
		try {
			OutputStream os = new FileOutputStream(docInputFile);
			int bytesRead = 0;
			byte[] buffer = new byte[1024 * 8];
			while ((bytesRead = fromFileInputStream.read(buffer)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				fromFileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		OpenOfficeConnection connection = new SocketOpenOfficeConnection(soffice_host, Integer.parseInt(soffice_port));
		try {
			connection.connect();
		} catch (ConnectException e) {
			System.err.println("文件转换出错，请检查OpenOffice服务是否启动。");
			e.printStackTrace();
		}
		// convert
		DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
		converter.convert(docInputFile, htmlOutputFile);
		connection.disconnect();

		// 转换完之后删除word文件
		// docInputFile.delete();
		return htmFileName;
	}

	public static void main(String[] args) throws IOException {
		Doc2HtmlUtil.doc2Html("E://Javabase.pdf", "E://pdf//");
		
		//Doc2HtmlUtil.doc2Html("D://pdf//转换用.ppt", "D://pdf//ttttt444//");
//		Doc2HtmlUtil.doc2Html("D://pdf//专业与院系对应关系.xls", "D://pdf//ttttt444//");
		//Doc2HtmlUtil.doc2Html("D://pdf//2010110档案管理系统需求分析说明书正式.doc", "D://pdf//ttttt444//");
	}
}