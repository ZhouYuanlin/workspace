package cn.uuf.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
public class UUFExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object object, Exception exp) {
//		exp.printStackTrace();
		if(exp instanceof RuntimeException)
			return new ModelAndView("error");
		else
			return new ModelAndView("error");
	}
}

