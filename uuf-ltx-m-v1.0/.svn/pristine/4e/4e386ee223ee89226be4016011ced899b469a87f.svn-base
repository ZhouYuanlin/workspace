package cn.uuf.stu.framework.controller;

import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.ArrayUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.uuf.stu.framework.common.SystemParamter;
import cn.uuf.stu.framework.common.SystemParamter.AccountLockType;
import cn.uuf.stu.framework.service.IEncryptService;
import cn.uuf.stu.framework.util.SystemParamterUtils;

/**
* 登陆 controller
* @ClassName: LoginController 
* @author tangpeng
* @date 2015年8月8日 下午8:09:56 
*
*/
@Controller("adminLoginController")
@RequestMapping("/admin/login")
public class LoginController extends BaseController {
	
	@Resource(name="encryptService")
	private IEncryptService encryptService;
	
	/**
	* 登录页面
	* @param model
	* @return    
	* String
	*/
	@RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
	public String index(HttpServletRequest request,ModelMap model){
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()){
			return "redirect:/admin/common/main";
		}
		String captchaId = UUID.randomUUID().toString();
		RSAPublicKey publicKey = encryptService.generateKey(request);
		String modulus = Base64.encodeBase64String(publicKey.getModulus().toByteArray());
		String exponent = Base64.encodeBase64String(publicKey.getPublicExponent().toByteArray());
		model.put("captchaId", captchaId);
		model.put("modulus", modulus);
		model.put("exponent", exponent);
		if(isLoginSubmission(request)){
			doPost(request, model);
		}
		return "/admin/login/login";
	}
	
	/**
	* post请求
	* @param request
	* @param model    
	* void
	*/
	private void doPost(HttpServletRequest request, ModelMap model) {
		String loginFailure = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		String message = null;
		SystemParamter systemParamter = SystemParamterUtils.get();
		Integer failureCount =systemParamter.getAccountLockCount();
		if (loginFailure != null) {
			if (loginFailure.equals("org.apache.shiro.authc.pam.UnsupportedTokenException")) {
				message = "admin.captcha.invalid";
			} else if (loginFailure.equals("org.apache.shiro.authc.UnknownAccountException")) {
				message = "admin.login.unknownAccount";
			} else if (loginFailure.equals("org.apache.shiro.authc.DisabledAccountException")) {
				message = "admin.login.disabledAccount";
			} else if (loginFailure.equals("org.apache.shiro.authc.LockedAccountException")) {
				message = "admin.login.lockedAccount";
			} else if (loginFailure.equals("org.apache.shiro.authc.IncorrectCredentialsException")) {
				if (ArrayUtils.contains(systemParamter.getAccountLockTypes(), AccountLockType.admin)) {
					message = "admin.login.accountLockCount";
				} else {
					message = "admin.login.incorrectCredentials";
				}
			} else if (loginFailure.equals("org.apache.shiro.authc.AuthenticationException")) {
				message = "admin.login.authentication";
			}
		}
		model.put("message", message);
		model.put("failureCount", failureCount);
	}
	
	/**
	* 判断是否是post请求
	* @param request
	* @param response
	* @return    
	* boolean
	*/
	protected boolean isLoginSubmission(ServletRequest request) {
		return (request instanceof HttpServletRequest) && WebUtils.toHttp(request).getMethod().equalsIgnoreCase(AccessControlFilter.POST_METHOD);
	}
	
	
}
