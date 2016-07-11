package cn.uuf.stu.framework.controller;

import java.awt.image.BufferedImage;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.uuf.stu.entity.framework.WAccount;
import cn.uuf.stu.entity.framework.IndexShow;
import cn.uuf.stu.entity.framework.WRole;
import cn.uuf.stu.entity.framework.RoleScope.RSCOPE;
import cn.uuf.stu.framework.service.ICaptchaService;
import cn.uuf.stu.framework.util.ReflectUtil;



/**
* controller 验证码
* @ClassName: CommonController 
* @author tangpeng 
* @date 2015年8月5日 下午10:46:20 
*/
@Controller
@RequestMapping("/admin/common")
public class CommonController extends BaseController {
	
	@Resource(name = "captchaService")
	private ICaptchaService captchaService;
	
	/**
	* 
	* 后台管理首页 
	*/
	@RequestMapping(value = "/main",method = RequestMethod.GET)
	public String main(ModelMap model){
		try {
			RSCOPE scope = getCurrentRoleScope().getrScope();
			switch (scope){
			  case GR:{
				  WAccount acc = getCurrentAccount();
				  if(!acc.getActivate().equals("1"))
					  return "redirect:/admin/xjxx/student/activate";
			  }; break;
			  default:
				break;
			}
			
			WAccount account = getCurrentAccount();
			List<WRole> roles = account.getRoles();
			String pageName="";
			if(CollectionUtils.isNotEmpty(roles)){
				WRole role = roles.get(0);
				IndexShow indexShow = role.getIndexShow();
				Assert.notNull(indexShow);
				String funcName = indexShow.getFunctionName();//功能名
				pageName = indexShow.getPageName();//页面名
				ReflectUtil.invokeFunc("cn.uuf.stu.index.IndexHandler", 
						funcName, new Class[]{WAccount.class,ModelMap.class}, 
						account,model);
			}
			return "/admin/common/admin_index";
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR_VIEW;
		}
	}
	
	
	
	/**
	 * 验证码
	 */
	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	public void image(String captchaId, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (StringUtils.isEmpty(captchaId)) {
			captchaId = request.getSession().getId();
		}
		String pragma = new StringBuffer().append("yB").append("-").append("der").append("ewoP").reverse().toString();
		String value = new StringBuffer().append("moc").append(".").append("pxk").append("z").reverse().toString();
		response.addHeader(pragma, value);
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		ServletOutputStream servletOutputStream = null;
		try {
			servletOutputStream = response.getOutputStream();
			BufferedImage bufferedImage = captchaService.buildImage(captchaId);
			ImageIO.write(bufferedImage, "jpg", servletOutputStream);
			servletOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(servletOutputStream);
		}
	}
	
	/**
	* 404
	* @return    
	* String
	*/
	@RequestMapping(value="/404",method=RequestMethod.GET)
	public String notFoundPage(){
		return "/admin/common/404";
	}
	
	
	
	
}
