package cn.uuf.stu.framework.shiro;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import cn.uuf.stu.entity.framework.WLog;
import cn.uuf.stu.framework.service.IEncryptService;
import cn.uuf.stu.framework.service.ILogService;


/**
 * 
* <p>标题：AuthenticationFilter</p>
* <p>简介：</p>
* @author tangp
* @date 2016年1月9日 下午6:59:36
 */
public class AuthenticationFilter extends FormAuthenticationFilter {
	
	/** 默认"加密密码"参数名称 */
	private static final String DEFAULT_EN_PASSWORD_PARAM = "enPassword";
	
	/** 默认"验证ID"参数名称 */
	private static final String DEFAULT_CAPTCHA_ID_PARAM = "captchaId";

	/** 默认"验证码"参数名称 */
	private static final String DEFAULT_CAPTCHA_PARAM = "captcha";
	
	/** "加密密码"参数名称 */
	private String enPasswordParam = DEFAULT_EN_PASSWORD_PARAM;

	/** "验证ID"参数名称 */
	private String captchaIdParam = DEFAULT_CAPTCHA_ID_PARAM;

	/** "验证码"参数名称 */
	private String captchaParam = DEFAULT_CAPTCHA_PARAM;
	
	@Resource(name="encryptService")
	private IEncryptService encryptService;
	
	@Resource(name="logService")
	private ILogService logService;
	
	/**
	 * 创建口令
	 */
	@Override
	protected org.apache.shiro.authc.AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) {
		String username = getUsername(servletRequest);
		String password = getPassword(servletRequest);
		String captchaId = getCaptchaId(servletRequest);
		String captcha = getCaptcha(servletRequest);
		boolean rememberMe = isRememberMe(servletRequest);
		String host = getHost(servletRequest);
		return new SystemCustomToken(username, password, captchaId, captcha, rememberMe, host);
	}
	
	@Override
	protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String requestType = request.getHeader("X-Requested-With");
		if (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) {
			response.addHeader("loginStatus", "accessDenied");
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}
		return super.onAccessDenied(request, response);
	}

	@Override
	protected boolean onLoginSuccess(org.apache.shiro.authc.AuthenticationToken token, Subject subject, ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
		Session session = subject.getSession();
		Map<Object, Object> attributes = new HashMap<Object, Object>();
		Collection<Object> keys = session.getAttributeKeys();
		for (Object key : keys) {
			attributes.put(key, session.getAttribute(key));
		}
		session.stop();
		session = subject.getSession();
		for (Entry<Object, Object> entry : attributes.entrySet()) {
			session.setAttribute(entry.getKey(), entry.getValue());
		}
		saveLog(token,servletRequest);
		return super.onLoginSuccess(token, subject, servletRequest, servletResponse);
	}
	
	/**
	* 保存日志
	* @param token
	* @param servletRequest    
	* void
	*/
	protected void saveLog(org.apache.shiro.authc.AuthenticationToken token,ServletRequest servletRequest){
		SystemCustomToken principal = (SystemCustomToken)token;
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		WLog log = new WLog();
		log.setIp(request.getLocalAddr());
		log.setContent("登录成功！");
		log.setOperation("登录操作");
		log.setOperator(principal.getUsername());
		logService.save(log);
	}
	
	
	

	@Override
	protected String getPassword(ServletRequest servletRequest) {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String password = encryptService.decryptParameter(enPasswordParam, request);
		encryptService.removePrivateKey(request);
		return password;
	}

	/**
	 * 获取验证ID
	 * 
	 * @param servletRequest
	 *            ServletRequest
	 * @return 验证ID
	 */
	protected String getCaptchaId(ServletRequest servletRequest) {
		String captchaId = WebUtils.getCleanParam(servletRequest, captchaIdParam);
		if (captchaId == null) {
			captchaId = ((HttpServletRequest) servletRequest).getSession().getId();
		}
		return captchaId;
	}

	/**
	 * 获取验证码
	 * 
	 * @param servletRequest
	 *            ServletRequest
	 * @return 验证码
	 */
	protected String getCaptcha(ServletRequest servletRequest) {
		return WebUtils.getCleanParam(servletRequest, captchaParam);
	}

	/**
	 * 获取"加密密码"参数名称
	 * 
	 * @return "加密密码"参数名称
	 */
	public String getEnPasswordParam() {
		return enPasswordParam;
	}

	/**
	 * 设置"加密密码"参数名称
	 * 
	 * @param enPasswordParam
	 *            "加密密码"参数名称
	 */
	public void setEnPasswordParam(String enPasswordParam) {
		this.enPasswordParam = enPasswordParam;
	}

	/**
	 * 获取"验证ID"参数名称
	 * 
	 * @return "验证ID"参数名称
	 */
	public String getCaptchaIdParam() {
		return captchaIdParam;
	}

	/**
	 * 设置"验证ID"参数名称
	 * 
	 * @param captchaIdParam
	 *            "验证ID"参数名称
	 */
	public void setCaptchaIdParam(String captchaIdParam) {
		this.captchaIdParam = captchaIdParam;
	}

	/**
	 * 获取"验证码"参数名称
	 * 
	 * @return "验证码"参数名称
	 */
	public String getCaptchaParam() {
		return captchaParam;
	}

	/**
	 * 设置"验证码"参数名称
	 * 
	 * @param captchaParami
	 *            "验证码"参数名称
	 */
	public void setCaptchaParam(String captchaParam) {
		this.captchaParam = captchaParam;
	}
}
