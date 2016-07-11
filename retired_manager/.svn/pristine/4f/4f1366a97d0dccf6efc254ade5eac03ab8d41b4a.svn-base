package cn.uuf.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;
import java.util.Properties;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

/**
 * OpenOffice 把文件转成pdf通用类，可转文件类型为doc,exls,ppt,txt等
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date Sep 27, 2013
 */
public class OpenOfficeToPdfUtil extends java.lang.Thread{

	private File inputFile;			//源文件
	private File outputFile;		//输出文件
	private String ipaddres = "127.0.0.1";		//openoffice的服务地址
	private int port = 8100;			//openoffice的起动端口8100;
	private String exePath = "C:/Program Files (x86)/SWFTools/pdf2swf.exe";
	private String swfLang = "/usr/share/xpdf/xpdf-chinese-simplified";
	
	public OpenOfficeToPdfUtil(File inputFile,File outputFile){
		this.inputFile = inputFile;
		this.outputFile = outputFile;
		try{
			Properties properties = new Properties();
			URL settings = OpenOfficeToPdfUtil.class.getResource("/thaus.properties");
			InputStream fis = settings.openStream();
			properties.load(settings.openStream());
			fis.close();
			ipaddres = properties.getProperty("openIp");
			port = Integer.parseInt(properties.getProperty("openPort"));
			exePath = properties.getProperty("swfpath");
			swfLang = properties.getProperty("swflang");
		}catch(Exception e){
			
		}
	}
	/**
	 * 把传过来的文件转成PDF先，后期再把pdf转成swf文件，供页面显示
	 */
	public void FileToPDF(){
		OpenOfficeConnection connection = new SocketOpenOfficeConnection(ipaddres,port); 
		try {   
            connection.connect();   
            DocumentConverter converter = new OpenOfficeDocumentConverter(connection);   
            String name = inputFile.getName();
            String type = name.substring(name.lastIndexOf("."));
            if(!type.equals(".pdf")){
            	converter.convert(inputFile, outputFile);   
            }
            try {
				pdf2swf(outputFile.getPath());
			} catch (IOException e) {
				System.out.println("pdf转swf文件失败");
				e.printStackTrace();
			}
        } catch (ConnectException e) {   
            e.printStackTrace();   
        } finally {   
            // close the connection   
            if (connection != null) {   
                connection.disconnect();   
                connection = null;   
            }   
        }  
	}
	
	/**  
     * 由于服务是线程不安全的，所以……需要启动线程  
      */  
   public void run() {   
       this.FileToPDF();   
   }
   
   /**
    * 利用SWFTools工具将pdf转换成swf，转换完后的swf文件与pdf同名
    * @param fileDir PDF文件存放路径（包括文件名）
    * @param exePath 转换器安装路径
    * @throws IOException
    */
  public synchronized void pdf2swf(String fileDir) throws IOException {
      //文件路径
       String filePath = "";
       if(isWindowsSystem())
    	   filePath = fileDir.substring(0, fileDir.lastIndexOf("\\"));
       else
    	   filePath = fileDir.substring(0, fileDir.lastIndexOf("/"));
      //文件名，不带后缀
       String fileName = fileDir.substring((filePath.length() + 1), fileDir.lastIndexOf("."));
      Process pro = null;
      if (isWindowsSystem()) {
          //如果是windows系统
          //命令行命令
          String cmd = exePath + " \"" + fileDir + "\" -s flashversion=9 -o \"" + filePath + "/" + fileName + ".swf\"";
          //Runtime执行后返回创建的进程对象
          pro = Runtime.getRuntime().exec(cmd);
      } else {
          //如果是linux系统,路径不能有空格，而且一定不能用双引号，否则无法创建进程
          String[] cmd = new String[10];
          cmd[0] = exePath;
          cmd[1] = "-o";
          cmd[2] = filePath + "//" + fileName + ".swf";
          cmd[3] = fileDir;
          cmd[4] = "-s";
          cmd[5] = "languagedir="+swfLang;
          cmd[6] = "-s";
          cmd[7] = "flashversion=9";
          cmd[8] = "-s";
          cmd[9] = "poly2bitmap";
          
          //Runtime执行后返回创建的进程对象
          pro = Runtime.getRuntime().exec(cmd);
      }
      //非要读取一遍cmd的输出，要不不会flush生成文件（多线程）
      new DoOutput(pro.getInputStream()).start();
      new DoOutput(pro.getErrorStream()).start();
      try {
          //调用waitFor方法，是为了阻塞当前进程，直到cmd执行完
           pro.waitFor();
           File file = new File(filePath + "//" + fileName + ".pdf");
           if(file.isFile() && !inputFile.getName().equals(file.getName()))
           	file.delete();
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
  }
   
  /**
    * 判断是否是windows操作系统
     * @author iori
    * @return
    */
  private static boolean isWindowsSystem() {
      String p = System.getProperty("os.name");
      return p.toLowerCase().indexOf("windows") >= 0 ? true : false;
  }
  
  /**
   * 多线程内部类
   * 读取转换时cmd进程的标准输出流和错误输出流，这样做是因为如果不读取流，进程将死锁
   */
 private static class DoOutput extends Thread {
     public InputStream is;
   
     //构造方法
      public DoOutput(InputStream is) {
         this.is = is;
     }
   
     public void run() {
         BufferedReader br = new BufferedReader(new InputStreamReader(this.is));
         String str = null;
         try {
             //这里并没有对流的内容进行处理，只是读了一遍
               while ((str = br.readLine()) != null);
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             if (br != null) {
                 try {
                     br.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
     }
 }
   
	public File getInputFile() {
		return inputFile;
	}
	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}
	public File getOutputFile() {
		return outputFile;
	}
	public void setOutputFile(File outputFile) {
		this.outputFile = outputFile;
	}
}

