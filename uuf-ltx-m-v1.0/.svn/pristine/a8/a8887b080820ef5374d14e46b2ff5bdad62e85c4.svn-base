package cn.uuf.stu.framework.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import cn.uuf.stu.entity.framework.ExceptionMonitor;
import cn.uuf.stu.framework.controller.BaseController;
import cn.uuf.stu.framework.service.IExceptionMonitorService;


/**
* 自定义异常控制业务类
* @ClassName: CustomBusinessExceptionResolver 
* @author tangpeng 
* @date 2015年8月1日 下午12:18:25 
*
*/
public class CustomBusinessExceptionResolver implements HandlerExceptionResolver {
	
	private final static String[] DEFAULT_IGNORE_PARAMETERS = new String[] { "password"};
	
	/** 忽略不显示的参数*/
	private String[] ignoreParameters = DEFAULT_IGNORE_PARAMETERS;
	/**默认的异常页*/
	private String defaultErrorView;
	
	
	public void setDefaultErrorView(String defaultErrorView) {
		this.defaultErrorView = defaultErrorView;
	}
	
	

	@Resource(name="exceptionMonitorService")
	private IExceptionMonitorService exceptionMonitorService;
	
	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ex.printStackTrace();
		ExceptionMonitor monitor = new ExceptionMonitor();
		monitor.setMessage(ex.getMessage());
		monitor.setPath(request.getServletPath());
		monitor.setException(ex.getLocalizedMessage());
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
		monitor.setParameter(parameter.toString());
		exceptionMonitorService.save(monitor);
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Object bean = handlerMethod.getBean();
		if(bean instanceof BaseController){
			return new ModelAndView(defaultErrorView);
		}
		return new ModelAndView(defaultErrorView);
	}
	
	/**
	* 获得异常信息
	* @param ex
	* @return    
	* String
	*/
	public String getExceptionInfo(Exception ex){
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(out);
		ex.printStackTrace(printStream);
		String exinfo = new String(out.toByteArray());
		printStream.close();
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return exinfo;
	}

	

}
