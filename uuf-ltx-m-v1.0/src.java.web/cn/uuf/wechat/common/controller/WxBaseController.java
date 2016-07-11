package cn.uuf.wechat.common.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.Role;
import cn.uuf.stu.framework.service.IAccountService;
import cn.uuf.stu.framework.shiro.Principal;
import cn.uuf.wechat.connect.service.ILtxAccountService;

public class WxBaseController {
	
	/**
	 * ltx账号service
	 */
	@Resource
	private ILtxAccountService ltxAccountService;
	
	
	/**
	 * 账号相关
	 */
	@Resource
	private IAccountService accountService;
	
	/**
	 * 获得当前用户
	 * @return
	 */
	public Account getCurrentAccount(){
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		if (requestAttributes != null) {
			HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
			Principal principal = (Principal) request.getSession().getAttribute(Constants.USER_ATTRIBUTE_NAME);
			if(principal != null){
				Account account = ltxAccountService.get(principal.getId());
				return account;
			}
		}
		return null;
	}
	
	/**
	 * 获取到当前openid关联的用户
	 * @return
	 */
	protected String getUserName() {
		Account account = getCurrentAccount();
		return account.getUsername();
	}
	
	/**
	 * 取得当前用户拥有的角色可访问的用户信息
	 * @return
	 */
	public String getRoleScope(Account account){
		if(account!=null){
			List<Account> accountList = ltxAccountService.getAccount(account);
			List<Role> roles = accountList.get(0).getRoles();
			if(CollectionUtils.isNotEmpty(roles)){
				return roles.get(0).getScope();
			}
		}
		return null;
	}
}
