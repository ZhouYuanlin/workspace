package cn.uuf.stu.framework.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 
* <p>标题：系统口令</p>
* <p>简介：</p>
* @author tangp
* @date 2016年1月9日 下午7:06:12
 */
public class SystemCustomToken extends UsernamePasswordToken {
	private static final long serialVersionUID = -6907642814729279959L;
	
	/** 验证码ID*/
	private String captchaId;
	
	/** 验证码*/
	private String captcha;
    
	
	/**
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param captchaId
	 *            验证码ID
	 * @param captcha
	 *            验证码
	 * @param rememberMe
	 *            记住我
	 * @param host
	 *            IP
	 */
	public SystemCustomToken(String username, String password, String captchaId, String captcha, boolean rememberMe, String host) {
		super(username, password, rememberMe);
		this.captchaId = captchaId;
		this.captcha = captcha;
	}
	
	
	/**
	* 获取验证码ID
	* @return 验证码ID   
	 */
	public String getCaptchaId() {
		return captchaId;
	}
    
	/**
	* 设置验证码ID
	* @param captchaId 验证码ID    
	* void
	 */
	public void setCaptchaId(String captchaId) {
		this.captchaId = captchaId;
	}
	
	/**
	* 获取验证码
	* @return 验证码   
	*/
	public String getCaptcha() {
		return captcha;
	}
	
	/**
	* 设置验证码
	* @param captcha 验证码    
	* 
	*/
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

}
