package cn.uuf.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.Role;
import cn.uuf.ltxxt.system.param.service.RetparamService;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
public class PermissionInterceptor implements HandlerInterceptor{

	private List<String> uncheckUrls;
	@Resource
	RetparamService pService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object obj) throws Exception {
		request.setAttribute("xmmc",pService.qeryByName(Constants.XXMC).getPvalue());
		request.setAttribute("xmbb",pService.qeryByName(Constants.XXBB).getPvalue());
		String url = request.getRequestURI();
		url = url.split(";")[0];
		url = url.replace(".do","");
		url = url.endsWith("/") ? url.substring(0,url.lastIndexOf("/")) : url;
		Subject subject = SecurityUtils.getSubject();
		boolean isCheck = false;
		if(url.toLowerCase().indexOf(".css") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".js") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".png") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".jpg") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".gif") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".swf") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".mp4") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".swf") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".xml") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".flv") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".mov") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".f4v") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".ppt") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".ico") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".xls") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".woff") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".ttf") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".svg") != -1)
			isCheck = true;
		else if(url.toLowerCase().indexOf(".html") != -1){
			isCheck = true;
		}
		else if(uncheckUrls.contains(url)){
			isCheck=true;
		}
		else
			isCheck = false;
		try{
			if(!isCheck)
			{
				url = url.replaceFirst("/","#");//主要是把每二个/后的字符去掉
				url = url.indexOf("/") != -1 ? url.substring(0,url.indexOf("/")).replace("#","/") : url.replace("#","/");
				if(url.toLowerCase().indexOf("index")== -1 && url.toLowerCase().indexOf("auth") == -1 && !subject.isPermitted(url)){
					response.sendRedirect("/auth/unauthorized");
				}
				request.setAttribute("Mpath",url);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,Object arg2, ModelAndView mav) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object obj, Exception e)
			throws Exception {
	}

	/**
	 * @return the uncheckUrls
	 */
	public List<String> getUncheckUrls() {
		return uncheckUrls;
	}

	/**
	 * @param uncheckUrls the uncheckUrls to set
	 */
	public void setUncheckUrls(List<String> uncheckUrls) {
		this.uncheckUrls = uncheckUrls;
	}
}

