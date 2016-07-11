package cn.uuf.wechat.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.uuf.contants.Constants;
import cn.uuf.stu.framework.shiro.Principal;

public class WechatIntecepter extends HandlerInterceptorAdapter{
	
	
	/** 默认登录URL */
	private static final String DEFAULT_LOGIN_URL = "/wechat/wechatcoreconnect/login";

	/** 登录URL */
	private String loginUrl = DEFAULT_LOGIN_URL;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
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
