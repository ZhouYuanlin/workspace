package cn.uuf.ltxxt.system.permission.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Log;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.permission.service.LogService;
import cn.uuf.util.Paginate;
/**
 * @author <a href="waxwing819230@sina.com">wyl</a>
 * @version 2.0
 * @date Feb 27, 2014
 */
@Controller
@RequestMapping("/log")
public class LogController extends BaseController{

	
	@Autowired
	private LogService logService;
	
	private final String LIST_ACTION = "redirect:/log";
	
	@RequestMapping
	public ModelAndView index(Integer page,Log log,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("permission/log/index");
		try{
			page = page == null || page < 0 ? 1 : page;
			int start = (page - 1) * size;
			Long count = logService.getCount(log);
			List<Log> list = logService.queryList(log, start, size);
			mav.addObject("list",list);
			paginate = new Paginate(list,count, size, page);
			mav.addObject("paginate",paginate);
			mav.addObject("log",log);
		}catch(Exception e){
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
		}
		return mav;
	}
	
	
	@RequestMapping(value="delete")
	@Transactional(rollbackFor =  Exception.class)
	public ModelAndView  delete(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redAttr,Long... id)throws Exception{
		try{
			logService.delete(id);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除日志成功");
			this.writer("删除日志记录",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除日志失败");
		}
		return new ModelAndView(LIST_ACTION);
	}
}

