package cn.uuf.interceptor;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.uuf.domain.Account;
import cn.uuf.domain.Log;
import cn.uuf.ltxxt.system.permission.service.LogService;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-6
 */
public class LogInterceptor implements HandlerInterceptor{

	LogDescript ld = new LogDescript();
	@Resource
	LogService lService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse respose,
			Object arg2) throws Exception {
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse respose, Object o1, Exception o2)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse respose,
			Object o, ModelAndView mav) throws Exception {
		String url = request.getRequestURI();
		try{
			if(url.split("/").length > 2 && LogDescript.map.get(url.split("/")[1]).length() > 0){
				Subject subject = SecurityUtils.getSubject();
				Account account = (Account) subject.getPrincipal();
				Log log = new Log();log.setPath(url);
				log.setAction(LogDescript.map.get(url.split("/")[1]) + (url.toLowerCase().contains("save") ? "添加" : (url.toLowerCase().contains("update") ? "修改" : (url.toLowerCase().contains("exc") ? "导入" : (url.toLowerCase().contains("edit") ? "跳转修改" : (url.toLowerCase().contains("detail") ? "详情" : (url.toLowerCase().contains("create") ? "跳转添加" : (url.toLowerCase().contains("delete") ? "删除" : ""))))))));
				log.setIp(request.getRemoteAddr());
				log.setLoginName(account.getRealname() + "【"+account.getUsername()+"】");
				log.setLoginDate(new Date());
				lService.save(log);
			}
		}catch(Exception e){
		}//不处理
	}
}

