package cn.uuf.stu.ltx.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.uuf.stu.constants.Constants;
import cn.uuf.stu.framework.common.Principal;

public class LoginIntercepter extends HandlerInterceptorAdapter{

	/** 默认登录URL */
	private static final String DEFAULT_LOGIN_URL = "/login";

	/** 登录URL */
	private String loginUrl = DEFAULT_LOGIN_URL;
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Principal principal = (Principal) session.getAttribute(Constants.USER_ATTRIBUTE_NAME);
		if(principal != null){
			return true;
		} else {
			response.sendRedirect(request.getContextPath() + loginUrl);
		}
		return false;
	}
	
}
