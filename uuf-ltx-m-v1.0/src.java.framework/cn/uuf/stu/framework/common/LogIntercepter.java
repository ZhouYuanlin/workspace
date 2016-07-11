package cn.uuf.stu.framework.common;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.uuf.stu.entity.framework.WLog;
import cn.uuf.stu.framework.service.IAccountService;
import cn.uuf.stu.framework.service.ILogConfigService;
import cn.uuf.stu.framework.service.ILogService;





/**
* 日志记录
* @ClassName: LogIntercepter 
* @author tangpeng 
* @date 2015年9月8日 下午2:38:45 
*
*/
public class LogIntercepter extends HandlerInterceptorAdapter {
	
	private final static String[] DEFAULT_IGNORE_PARAMETERS = new String[] { "password"};
	/** 忽略不显示的参数*/
	private String[] ignoreParameters = DEFAULT_IGNORE_PARAMETERS;
	
	private static AntPathMatcher antPathMatcher = new AntPathMatcher();
	
	@Resource(name="logService")
	private ILogService logService;
	
	@Resource(name="accountService")
	private IAccountService accountService;
	
	@Resource(name="logConfigService")
	private ILogConfigService logConfigService;

	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		List<LogConfig> logConfigs = logConfigService.getAll();
		if(CollectionUtils.isNotEmpty(logConfigs)){
			String path = request.getServletPath();
			for (LogConfig logConfig : logConfigs) {
				if(antPathMatcher.match(logConfig.getUrlPattern(), path)){
					String content = (String) request.getAttribute(WLog.LOG_CONTENT_ATTRIBUTE_NAME);
					String ip = request.getRemoteAddr();
					String username = accountService.getCurrentUsername();
					String operation = logConfig.getOperation();
					request.removeAttribute(WLog.LOG_CONTENT_ATTRIBUTE_NAME);
					WLog log = new WLog();
					log.setContent(content);
					if(StringUtils.isEmpty(content)){
						log.setContent(operation+"成功！");
					}
					log.setIp(ip);
					log.setOperation(operation);
					log.setOperator(username);
					log.setParameter(getRequestParameter(request));
					logService.save(log);
					break;
				}
			}
		}
	}
	
	/**
	* 生成请求参数
	* @param request
	* @return    
	* String
	*/
	@SuppressWarnings("unchecked")
	private String getRequestParameter(HttpServletRequest request) {
		StringBuffer parameter = new StringBuffer();
		Map<String, String[]> parameterMap = request.getParameterMap();
		if (parameterMap != null) {
			for (Entry<String, String[]> entry : parameterMap.entrySet()) {
				String parameterName = entry.getKey();
					String[] parameterValues = entry.getValue();
					if (!ArrayUtils.contains(ignoreParameters, parameterName)) {
						if (parameterValues != null) {
							for (String parameterValue : parameterValues) {
								parameter.append(parameterName + " = " + parameterValue + ";");
							}
						}
					}
			}
		}
		return parameter.toString();
	}
	
	
}














