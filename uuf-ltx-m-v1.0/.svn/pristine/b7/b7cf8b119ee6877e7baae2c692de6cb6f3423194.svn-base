package cn.uuf.stu.framework.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public final class HostUtil {
	
	/**
	 * 获得访问IP
	 * @param request
	 * @return
	 */
	public static String getRemortIP(HttpServletRequest request) {  
	    if (request.getHeader("x-forwarded-for") == null) {  
	        return request.getRemoteAddr();  
	    }  
	    return request.getHeader("x-forwarded-for");  
	}
	
	/**
	 * 获得用户的url
	 * @return
	 */
	public static String getUserURL(){
		String userURL = System.getProperty("user.dir");
		userURL = userURL.substring(0,userURL.lastIndexOf(File.separator) + 1);
		return userURL;
	}
}
