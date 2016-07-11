package cn.uuf.stu.framework.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import cn.uuf.stu.framework.common.FileInfo.FileType;



/**
* 文件  服务 
* @ClassName: FileService 
* @author tangpeng
* @date 2015年8月25日 上午10:16:52 
*
*/
public interface IFileService {
	
	/**
	* 文件验证
	* @param fileType
	* @param multipartFile
	* @return    
	* boolean
	 */
	boolean isValid(FileType fileType,MultipartFile multipartFile);
	
	/**
	* 文件上传至本地
	* @param fileType 文件类型
	* @param multipartFile 上传文件
	* @return    
	* String
	*/
	String uploadLocal(FileType fileType,MultipartFile multipartFile);
	
	
	String uploadLocal(MultipartFile multipartFile,String path);
	
	
	/**
	 * @param basePath 基本路径  如：/upload/jxj/2011002
	 * @param fileName 生成的文件名  如果不指定就用默认的
	 * @param multipartFile 文件流
	 * @return
	 */
	String uploadLocal(String basePath,String fileName,MultipartFile multipartFile);
	
	/**
	 * 
	 * @param url 下载路径
	 * @param fileName 文件名
	 * @param request 请求
	 * @param response 
	 */
	String downFile(String url,String fileName,HttpServletRequest request,HttpServletResponse response);
	
	/**
	 * 获得文件名
	 * @param path
	 * @return
	 */
	String getFileName(String path);
	

}
