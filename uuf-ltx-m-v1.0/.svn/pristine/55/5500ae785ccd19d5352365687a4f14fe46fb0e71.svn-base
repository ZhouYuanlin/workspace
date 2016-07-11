package cn.uuf.stu.framework.service.impl;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import cn.uuf.stu.framework.common.FileInfo.FileType;
import cn.uuf.stu.framework.common.SystemParamter;
import cn.uuf.stu.framework.service.IFileService;
import cn.uuf.stu.framework.util.DateUtils;
import cn.uuf.stu.framework.util.SystemParamterUtils;



/**
* 文件  service
* @ClassName: FileServiceImpl 
* @author tangpeng
* @date 2015年8月25日 上午10:23:11 
*
*/
@Service(value="fileService")
public class FileServiceImpl implements IFileService,ServletContextAware  {
	
	/** servletContext */
	private ServletContext servletContext;

	@Override
	public boolean isValid(FileType fileType, MultipartFile multipartFile) {
		if (multipartFile == null) {
			return false;
		}
		SystemParamter systemParamter = SystemParamterUtils.get();
		if (systemParamter.getUploadMaxSize() != null && systemParamter.getUploadMaxSize() != 0 && multipartFile.getSize() > systemParamter.getUploadMaxSize() * 1024L * 1024L) {
			return false;
		}
		String[] uploadExtensions;
		if (fileType == FileType.file) {
			uploadExtensions = systemParamter.getUploadFileExtensions();
		} else if((fileType == FileType.image)) {
			uploadExtensions = systemParamter.getUploadImageExtensions();
		}else{
			uploadExtensions = systemParamter.getUploadOtherExtensions();
		}
		if (!ArrayUtils.isEmpty(uploadExtensions)) {
			return FilenameUtils.isExtension(multipartFile.getOriginalFilename(), uploadExtensions);
		}
		return false;
	}

	@Override
	public String uploadLocal(FileType fileType, MultipartFile multipartFile) {
		if (multipartFile == null) {
			return null;
		}
		 SystemParamter systemParamter = SystemParamterUtils.get();
		String uploadPath;
	    if (fileType == FileType.file) {
			uploadPath = systemParamter.getFileUploadPath();
		} else {
			uploadPath = systemParamter.getImageUploadPath();
		}
		try {
			
			String destPath = getDestPath(uploadPath,multipartFile);
			File destFile = new File(servletContext.getRealPath(destPath));
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			multipartFile.transferTo(destFile);
			return destPath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public String uploadLocal(MultipartFile multipartFile,String path){
		if (multipartFile == null) {
			return null;
		}
		try {
			String fileNewName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()); 
			path = path+File.separator+fileNewName+"."+FilenameUtils.getExtension(multipartFile.getOriginalFilename());
			File destFile = new File(servletContext.getRealPath(path));
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			multipartFile.transferTo(destFile);
			return fileNewName+"."+FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	private String getDestPath(String uploadPath, MultipartFile multipartFile){
		String[] uploadPaths = uploadPath.split("/");
		Assert.assertTrue(uploadPaths.length>0);
		uploadPath = File.separator;
		for (String s : uploadPaths) {
			if(StringUtils.isNotEmpty(s)){
				uploadPath=uploadPath+s+File.separator;
			}
		}
		String path = uploadPath+DateUtils.getFormatDateString("yyyy-MM-dd")+File.separator;
		String destPath = path + UUID.randomUUID() + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		return destPath;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Override
	public String uploadLocal(String basePath, String fileName,
			MultipartFile multipartFile) {
		try {
			if (multipartFile == null) {
				return null;
			}
			String[] uploadPaths = basePath.split("/");
			Assert.assertTrue(uploadPaths.length>0);
			basePath = File.separator;
			for (String s : uploadPaths) {
				if(StringUtils.isNotEmpty(s)){
					basePath=basePath+s+File.separator;
				}
			}
			String destPath="";
			if(StringUtils.isNotEmpty(fileName)){
				destPath = basePath + fileName + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
			}else{
				destPath = basePath + UUID.randomUUID() + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
			}
			File destFile = new File(servletContext.getRealPath(destPath));
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			multipartFile.transferTo(destFile);
			return destPath;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public String downFile(String url, String fileName, HttpServletRequest request,
			HttpServletResponse response) {
		  String path= request.getSession().getServletContext().getRealPath(url) ;
		  File f = new File(path);
		  if(!f.exists()){
			  return "notFindFile";
		  }
		  try {
			  response.reset();
			  response.setContentType("application/octet-stream");
			  response.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(fileName,"UTF-8"));  
			  BufferedInputStream fis = new BufferedInputStream(new FileInputStream(f), 512*1024);
			  OutputStream output = response.getOutputStream();
			  byte[] b = new byte[512*1024];
			  while(fis.read(b)!=-1){
			      output.write(b);
			  }
			  output.flush();
			  fis.close();
			  output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;  
	}

	@Override
	public String getFileName(String path) {
		Assert.assertNotNull(path);
		String filName = path.substring(path.lastIndexOf(File.separator)+1, path.length());
		return filName;
	}

}
