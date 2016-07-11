package cn.uuf.stu.framework.service.impl;

import java.awt.image.BufferedImage;

import javax.annotation.Resource;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import cn.uuf.stu.framework.common.SystemParamter;
import cn.uuf.stu.framework.common.SystemParamter.CaptchaType;
import cn.uuf.stu.framework.service.ICaptchaService;
import cn.uuf.stu.framework.util.SystemParamterUtils;



/**
* 验证码实现
* @ClassName: CaptchaServiceImpl 
* @author tangpeng
* @date 2015年8月3日 下午2:54:32 
*/
@Service("captchaService")
public class CaptchaServiceImpl implements ICaptchaService {
	
	@Resource(name = "imageCaptchaService")
	private com.octo.captcha.service.CaptchaService imageCaptchaService;
    
	@Override
	public BufferedImage buildImage(String captchaId) {
		return (BufferedImage) imageCaptchaService.getChallengeForID(captchaId);
	}

	@Override
	public boolean isValid(CaptchaType captchaType, String captchaId,
			String captcha) {
		SystemParamter paramter = SystemParamterUtils.get();
		if(captchaType != null &&  ArrayUtils.contains(paramter.getCaptchaTypes(), captchaType)){
			if (StringUtils.isNotEmpty(captchaId) && StringUtils.isNotEmpty(captcha)) {
				try {
					return imageCaptchaService.validateResponseForID(captchaId, captcha.toUpperCase());
				} catch (Exception e) {
					return false;
				}
			} else {
				return false;
			}
		}else{
			return true;
		}
	}

}
