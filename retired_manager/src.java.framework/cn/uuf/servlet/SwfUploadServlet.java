package cn.uuf.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
/**
 * @Author:huangdawei;
 * @Date:2016-45-12;
 * @Comment：利用swf进行上传图片
 * */
public class SwfUploadServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
	}

}
