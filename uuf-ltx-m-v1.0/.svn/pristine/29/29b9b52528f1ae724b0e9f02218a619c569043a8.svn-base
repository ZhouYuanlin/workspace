package cn.uuf.stu.framework.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.uuf.stu.entity.framework.WLog;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.service.ILogService;


/**
* 日志管理
* @ClassName: LogController 
* @author tangpeng
* @date 2015年9月9日 下午3:30:09 
*
**/
@Controller
@RequestMapping("/admin/log")
public class LogController extends BaseController {
	
	@Resource(name="logService")
	private ILogService logService;
	
	/**
	* 日志列表
	* @param log
	* @param startTime 开始时间
	* @param endTime 结束时间
	* @param model
	* @return    
	* String
	 */
	@RequiresPermissions("log:view")
	@RequestMapping(method=RequestMethod.GET)
	public String index(WLog log,String startTime,String endTime,Pageable pageable,ModelMap model){
		pageable.setPageSize(10);
		Page<WLog> page = logService.getList(log, startTime, endTime, pageable);
		model.put("page", page);
		model.put("log", log);
		model.put("startTime", startTime);
		model.put("endTime", endTime);
		return "/admin/log/index";
	}
	

}
