package cn.uuf.stu.framework.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.uuf.stu.entity.framework.ExceptionMonitor;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.service.IExceptionMonitorService;


/**
* 	 
* @ClassName: ExceptionMonitorController 
* @author tangpeng
* @date 2015年9月10日 下午4:17:49 
* 
*/
@Controller
@RequestMapping(value="/admin/exceptionmonitor")
public class ExceptionMonitorController extends BaseController {
	@Resource(name="exceptionMonitorService")
	private IExceptionMonitorService exceptionMonitorService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ExceptionMonitor monitor,String startTime,String endTime,Pageable pageable,ModelMap model){
		model.put("startTime", startTime);
		model.put("endTime", endTime);
		model.put("page", exceptionMonitorService.getList(monitor, startTime, endTime, pageable));
		return "/admin/exceptionmonitor/index";
	}
	
}
