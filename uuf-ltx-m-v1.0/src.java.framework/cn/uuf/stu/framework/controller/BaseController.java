package cn.uuf.stu.framework.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import cn.uuf.stu.entity.framework.WAccount;
import cn.uuf.stu.entity.framework.WLog;
import cn.uuf.stu.entity.framework.WRole;
import cn.uuf.domain.Account;
import cn.uuf.domain.User;
import cn.uuf.stu.entity.framework.RoleScope;
import cn.uuf.stu.framework.common.Message;
import cn.uuf.stu.framework.service.IAccountService;
import cn.uuf.stu.framework.shiro.Principal;
import cn.uuf.stu.framework.util.SpringUtils;




/**
* controller 基类
* 
* @ClassName: BaseController 
* @author tangpeng
* @date 2015年7月27日 下午3:07:09 
*
*/
public class BaseController {
	
	/**错误视图*/
	protected static final String ERROR_VIEW ="/admin/common/error";
	
	/** 错误消息 */
	protected static final Message ERROR_MESSAGE = Message.error("admin.message.error");

	/** 成功消息 */
	protected static final Message SUCCESS_MESSAGE = Message.success("admin.message.success");

	/** "验证结果"参数名称 */
	private static final String CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME = "constraintViolations";
	
	/** 瞬时消息属性名*/
	private static final String FLASH_MESSAGE_ATTRIBUTE_NAME = "flash_message";
	//码表通用服务

	
	@Resource(name = "validator")
	private Validator validator;
	
	@Resource(name="accountService")
	private IAccountService accountService;

	
	/**
	 * 数据验证
	 * 
	 * @param target
	 *            验证对象
	 * @param groups
	 *            验证组
	 * @return 验证结果
	 */
	protected boolean isValid(Object target, Class<?>... groups) {
		Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target, groups);
		if (constraintViolations.isEmpty()) {
			return true;
		} else {
			RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
			requestAttributes.setAttribute(CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME, constraintViolations, RequestAttributes.SCOPE_REQUEST);
			return false;
		}
	}

	/**
	 * 数据验证
	 * 
	 * @param type
	 *            类型
	 * @param property
	 *            属性
	 * @param value
	 *            值
	 * @param groups
	 *            验证组
	 * @return 验证结果
	 */
	protected boolean isValid(Class<?> type, String property, Object value, Class<?>... groups) {
		Set<?> constraintViolations = validator.validateValue(type, property, value, groups);
		if (constraintViolations.isEmpty()) {
			return true;
		} else {
			RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
			requestAttributes.setAttribute(CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME, constraintViolations, RequestAttributes.SCOPE_REQUEST);
			return false;
		}
	}
	
	/**
	 * 获取国际化消息
	 * 
	 * @param code
	 *            代码
	 * @param args
	 *            参数
	 * @return 国际化消息
	 */
	protected String message(String code, Object... args) {
		return SpringUtils.getMessage(code, args);
	}

	/**
	 * 添加瞬时消息
	 * 
	 * @param redirectAttributes
	 *            RedirectAttributes
	 * @param message
	 *            消息
	 */
	protected void addFlashMessage(RedirectAttributes redirectAttributes, Message message) {
		if (redirectAttributes != null && message != null) {
			redirectAttributes.addFlashAttribute(FLASH_MESSAGE_ATTRIBUTE_NAME, message);
		}
	}
	
	/**
	* 添加日志内容
	* @param content    
	* void
	*/
	protected void addLogContent(String content){
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		requestAttributes.setAttribute(WLog.LOG_CONTENT_ATTRIBUTE_NAME, content,RequestAttributes.SCOPE_REQUEST);
	}
	
	/**
	 *获得当前登录身份信息
	 * @return
	 */
	public Principal getCurrentPrincipal() {
		Subject subject = SecurityUtils.getSubject();
		if(subject!=null){
			Principal principal = (Principal) subject.getPrincipal();
			if(principal!=null){
				return principal;
			}
		}
		return null;
	}
	
	/**
	 * 当前用户账号
	 * @return
	 */
	public WAccount getCurrentAccount(){
		Principal principal = getCurrentPrincipal();
		WAccount account = accountService.getUniqueEntity("username", principal.getUsername());
		return account;
	}
	
	
	
	/**
	 * 获得当前角色的域
	 * @return
	 */
	public RoleScope getCurrentRoleScope(){
		
		try {
			WAccount account = getCurrentAccount();
			List<RoleScope> scopeList = new ArrayList<RoleScope>();
			List<WRole> roles = account.getRoles();
			for (WRole role : roles) {
				scopeList.add(role.getRoleScope());
			}
			if(scopeList.size()>1){
				Collections.sort(scopeList,new Comparator<RoleScope>() {
					@Override
					public int compare(RoleScope src, RoleScope target) {
						return src.getSort().compareTo(target.getSort());
					}
				});
			}
			return scopeList.get(0);	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
