package cn.uuf.stu.framework.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;






import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.uuf.domain.Account;
import cn.uuf.stu.constants.Constants;
import cn.uuf.stu.framework.common.Principal;
import cn.uuf.stu.ltx.login.service.IAccountService;

public class BaseController {
	
	@Resource(name="accountService")
	private IAccountService accountService;
	
	/**
	 * 获得当前用户
	 * @return
	 */
	public Account getCurrent(){
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		if (requestAttributes != null) {
			HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
			Principal principal = (Principal) request.getSession().getAttribute(Constants.USER_ATTRIBUTE_NAME);
			if(principal != null){
				Account account = accountService.get(principal.getId());
				return account;
			}
		}
		return null;
	}
	
	/**
	 * 获得当前用户名
	 * @return
	 */
	public String getCurrentUsername(){
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		if (requestAttributes != null) {
			HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
			Principal principal = (Principal) request.getSession().getAttribute(Constants.USER_ATTRIBUTE_NAME);
			if(principal != null){
				return principal.getUsername();
			}
		}
		return null;
	}
	
	/**
	 * 判断是否登录
	 * @return
	 */
	public boolean isAuthenticated() {
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		if (requestAttributes != null) {
			HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
			Principal principal = (Principal) request.getSession().getAttribute(Constants.USER_ATTRIBUTE_NAME);
			if(principal != null){
				return true;
			}
		}
		return false;
	}
	
	
	
	
	

}
