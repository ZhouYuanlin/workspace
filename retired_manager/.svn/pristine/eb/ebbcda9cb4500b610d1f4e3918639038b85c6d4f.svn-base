package cn.uuf.ltxxt.system.permission.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.User;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.permission.service.UserService;
import cn.uuf.servlet.ImageUploadServlet;
import cn.uuf.util.Image;

/**
 * 上传头像
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-28
 */
@Controller
@RequestMapping("{avator:avator;*.?}")
public class AvatorController extends BaseController{

	@Resource
	private UserService uService;
	private static final Integer AVATOR_MEDIUM_SIZE = 90;	//大头像尺寸
	private static final Integer AVATOR_THUMB_SIZE = 50;	//小头像尺寸
	
	/**
	 * 上传头像
	 * @param message
	 * @return
	 */
	@RequestMapping
	public ModelAndView toAvator(String message) {
		ModelAndView mav = new ModelAndView("permission/user/avatorEdit");
		try{
			User u = uService.getById(this.getCurrentUser().getUsername());
			mav.addObject("u",u);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * 上传和修改头像
	 * @return
	 */
	@RequestMapping(value="/avatorCrop")
	public ModelAndView avatorCrop(HttpServletRequest request,String originalImage,Integer scaleWidth,Integer scaleHeight,int startX,int startY,int endX,int endY,RedirectAttributes red) {
		try{
			User u = uService.getById(this.getCurrentUser().getUsername());
			String defaultImageSuffix = "jpg";
			String uploadDir = request.getRealPath("/") + ImageUploadServlet.DEFAULT_UPLOAD_DIR
							   + File.separator + "user" + File.separator + u.getSfzh();
			File originalImageFile = new File(uploadDir + File.separator + originalImage);//上传存放原图
			Image _originalImage = new Image(originalImageFile);
			String zoomImagePath = uploadDir + File.separator//缩略图路径
					+ "zoom." + defaultImageSuffix;
			_originalImage.resize(scaleWidth, scaleHeight);
			_originalImage.crop(startX, startY, endX, endY);
			_originalImage.saveAs(zoomImagePath);//存放修剪后的图片
			//存放大小为90的jpg格式的图片 
			String toNewImgPath = uploadDir + File.separator + "middle." + defaultImageSuffix;
			_originalImage.quertyToSave(zoomImagePath, toNewImgPath, AVATOR_MEDIUM_SIZE, AVATOR_MEDIUM_SIZE);
			//存放大小为50的jpg格式的图片 
			toNewImgPath = uploadDir + File.separator + "small." + defaultImageSuffix;
			_originalImage.quertyToSave(zoomImagePath, toNewImgPath, AVATOR_THUMB_SIZE, AVATOR_THUMB_SIZE);
			if(originalImageFile.isFile() && originalImageFile.exists())
				originalImageFile.delete();
			u.setImgsfsc(Constants.HASYES);
			uService.update(u);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"上传头像成功");
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"上传头像失败！");
		}
		return new ModelAndView("redirect:/avator");
	}
}

