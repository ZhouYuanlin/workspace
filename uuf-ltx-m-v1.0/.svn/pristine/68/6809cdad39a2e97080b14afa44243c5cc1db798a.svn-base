package cn.uuf.stu.framework.service;

import java.awt.image.BufferedImage;

import cn.uuf.stu.framework.common.SystemParamter.CaptchaType;




/**
* 验证码
* @ClassName: CaptchaService 
* @author tangpeng
* @date 2015年8月3日 下午2:48:33 
*
*/
public interface ICaptchaService {
	
	/**
	 * 生成验证码图片
	 * 
	 * @param captchaId
	 *            验证ID
	 * @return 验证码图片
	 */
	BufferedImage buildImage(String captchaId);

	/**
	 * 验证码验证
	 * 
	 * @param captchaType
	 *            验证码类型
	 * @param captchaId
	 *            验证ID
	 * @param captcha
	 *            验证码(忽略大小写)
	 * @return 验证码验证是否通过
	 */
	boolean isValid(CaptchaType captchaType, String captchaId, String captcha);
}
