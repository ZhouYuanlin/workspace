package cn.uuf.stu.framework.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public final class OpenOffice2HtmlUtil {
	public static String IP="127.0.0.1";
	public static String PORT="8100";
	static{
		try {
			Properties properties = new Properties();
			URL resource = OpenOffice2HtmlUtil.class.getResource("/thaus.properties");
			InputStream fis = resource.openStream();
			properties.load(fis);
			fis.close();
			IP = properties.getProperty("openIp");
			PORT= properties.getProperty("openPort");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param inputFilePath 转换文件路径
	 * @param outputFolder 输出文件夹
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static void file2Html(File inputFile,File outputFile){
		OpenOfficeConnection connection = new SocketOpenOfficeConnection(IP, Integer.parseInt(PORT));
		try {
			connection.connect();
		} catch (ConnectException e) {
			System.err.println("文件转换出错，请检查OpenOffice服务是否启动。");
			e.printStackTrace();
		}
		try {
			DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
			converter.convert(inputFile, outputFile);
			connection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String toHtmlString(File docFile,String docImgPath) throws FileNotFoundException {
		 // 获取html文件流
	    StringBuffer htmlSb = new StringBuffer();
	    try {
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	            new FileInputStream(docFile)));
	        while (br.ready()) {
	        htmlSb.append(br.readLine());
	        }
	        br.close();
	     
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    // HTML文件字符串
	    String htmlStr = htmlSb.toString();
		return clearFormat(htmlStr,docImgPath);
	}
	
	 protected static String clearFormat(String htmlStr,String docImgPath) {
		    // 获取body内容的正则
		    String bodyReg = "<BODY .*</BODY>";
		    Pattern bodyPattern = Pattern.compile(bodyReg);
		    Matcher bodyMatcher = bodyPattern.matcher(htmlStr);
		    if (bodyMatcher.find()) {
		        // 获取BODY内容，并转化BODY标签为DIV
		        htmlStr = bodyMatcher.group().replaceFirst("<BODY", "<DIV")
		            .replaceAll("</BODY>", "</DIV>");
		    }
		    // 调整图片地址
		    if(docImgPath!=null)
		    {
			    htmlStr = htmlStr.replaceAll("<IMG SRC=\"", "<IMG SRC=\"" + docImgPath
				        + "/");
			    htmlStr = htmlStr.replaceAll("<img src=\"", "<img src=\"" + docImgPath
				        + "/");
		    }
		    
		    String imgReg="<IMG SRC=\".*\" NAME=\"Line 2\" ALT=\"Line 2\" ALIGN=LEFT HSPACE=12>";
		    Pattern imgPattern = Pattern.compile(imgReg);
		    Matcher imgMatcher = imgPattern.matcher(htmlStr);
		    if(imgMatcher.find()){
		    	String string = imgMatcher.group().replaceFirst("<IMG", "<IMG style=\"width:97%;height:3px\"");
		    	htmlStr = htmlStr.replaceFirst(imgReg, string);
		    }
		    htmlStr= htmlStr.replaceAll("<DIV TYPE=FOOTER>", "<DIV style=\"display:none\" type=FOOTER>");	
		    htmlStr = htmlStr.replaceAll("<TABLE", "<TABLE style=\"border:1px solid #000\"");
		    return htmlStr;
	}
	
	
	
}
