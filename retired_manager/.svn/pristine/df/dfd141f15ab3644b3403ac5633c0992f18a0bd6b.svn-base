package cn.uuf.ltxxt.util.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class FileUploadAction {

	public static final int MB = 1024 * 1024;
	public static final String UPLOAD_PATH = "upload";
	
	@RequestMapping("/admin/upload/swfupload11")
	public void swfUpload(HttpServletRequest request,HttpServletResponse response)throws IOException{
		String str=request.getSession().getServletContext().getRealPath("/");
		String filepath=str+"upload";//最后存放文件的位置
		MultipartFile[] files =null;
		File tmp=new File("c:\\tmp\\");//临时存放位置
		if(!tmp.exists()){
			tmp.mkdirs();
		}
		DiskFileItemFactory factory =new DiskFileItemFactory();//创建磁盘工程
		factory.setRepository(tmp);//文件的缓存路径
		factory.setSizeThreshold(10*1096);
		ServletFileUpload sfu=new ServletFileUpload(factory);//创建处理工具;
		sfu.setSizeMax(10*1024*1024);//目前设置的是10M;
		String fileName=null;
		try{
			List<FileItem> items=sfu.parseRequest(request);//解析请求
			FileItem item=null;
			System.out.println(items.size());
			if(items!=null&&items.size()>0){
				item=(FileItem) items.get(1);
				fileName=item.getName();
			}
			if(fileName.equals("")){
				request.getRequestDispatcher("").forward(request, response);//准对文件不存在做出的反应；
			}
			int naturepoint=fileName.lastIndexOf("\\");
			String natureName=null;
			if(naturepoint>0){
				natureName=fileName.substring(naturepoint+1);//文件的原始名；
				
			}
			int pos=fileName.lastIndexOf(".");//获取文件格式
			Date date=new Date();
			String filetype="jpg";
			if(pos>0){
				filetype=fileName.substring(pos);
				fileName=filepath+"/"+date.getTime()+fileName.substring(pos);
			}
			File fileresult=new File(fileName);
			if(!fileresult.exists()){
				fileresult.createNewFile();
			}
			item.write(fileresult);//写到磁盘
			//url为fileName;
			//int fid=Integer.parseInt(request.getParameter("fid"));
			fileName=fileName.replace("\\", "/");
			//int id=this.savefujian(fid, natureName, fileName).getId();
			//保存对象
			String urlstr="upload/"+date.getTime()+filetype;
			response.getWriter().print(urlstr);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		/*
		 * 
		 
		 * */
		
		
		/*
		 MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest)request;
		List<MultipartFile> files= multipartRequest.getFiles("resume_file");   
        StringBuffer sb = new StringBuffer();
        for (MultipartFile file : files) {   
            if (file.isEmpty()) continue;   
            sb.append(processUploadFile(file.getBytes(), request.getSession().getServletContext(), file.getOriginalFilename()) + ",");
            
        }
        if(sb.length() > 0){
        	response.getWriter().print(sb.substring(0, sb.length() - 1));
        }
		 * */
	}
	
	public String processUploadFile(byte[] bytes,ServletContext context,String tempFileName){
		String firstName = "";
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH )+1;
		int day = cal.get(Calendar.DATE);
		firstName += year;
		firstName += month;
		firstName += day;
		
		String fileName = UUID.randomUUID().toString(); 
		String picName = fileName + tempFileName.substring(tempFileName.lastIndexOf("."),tempFileName.length()); //获取文件名
		String relpath = context.getRealPath("/")+"/"+UPLOAD_PATH+"/"+firstName;
		String url = relpath+"/"+picName;
		String returnUrl = UPLOAD_PATH+"/"+firstName+"/"+picName;
		// 图片上传服务器的路径
		
		// 文件上传至文件服务器
		File dirs = new File(relpath);
		
		if(!dirs.exists()){
			dirs.mkdirs();
		}
		try {
			FileOutputStream fileOS=new FileOutputStream(url);   
            fileOS.write(bytes);   
            fileOS.close();   
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 文件上传完毕
		return returnUrl;
		
	}
	
	/**
	 * 图片上传完成后的后续处理过程.
	 * 
	 * @param fileItem
	 * @param basePath
	 * @throws Exception
	 */
	private String processUploadFile(FileItem fileItem, String basePath,ServletContext context)
			throws Exception {
		String firstName = "";
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH )+1;
		int day = cal.get(Calendar.DATE);
		firstName += year;
		firstName += month;
		firstName += day;
		
		String fileName = UUID.randomUUID().toString(); 
		String picName = fileName+ fileItem.getName().substring(fileItem.getName().lastIndexOf("."),fileItem.getName().length()); //获取文件名
		String relpath = context.getRealPath("/")+"/"+UPLOAD_PATH+"/"+firstName;
		String url = relpath+"/"+picName;
		String returnUrl = UPLOAD_PATH+"/"+firstName+"/"+picName;
		// 图片上传服务器的路径
		
		// 文件上传至文件服务器
		File dirs = new File(relpath);
		
		if(!dirs.exists()){
			dirs.mkdirs();
		}
		try {
			fileItem.write(new File(url));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 文件上传完毕
		return returnUrl;
	}
}
