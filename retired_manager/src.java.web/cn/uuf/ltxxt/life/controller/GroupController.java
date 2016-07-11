package cn.uuf.ltxxt.life.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.life.DocGrp;
import cn.uuf.ltxxt.life.service.GroupService;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.util.Paginate;

/**
 * 类说明	：资源分组
 */
@Controller
@RequestMapping("/group")
public class GroupController extends BaseController{
	@Autowired
	private GroupService groupService;
	@RequestMapping
	public ModelAndView index(Integer page,DocGrp p,HttpServletRequest request,HttpServletResponse response,RedirectAttributes re){
		ModelAndView mav = new ModelAndView("life/group/index");
		try{
			page = page == null || page < 0 ? 1 : page;
			int start = (page - 1) * size;
			List<DocGrp> list = groupService.queryByPage(p, start, size);
			Long count = groupService.getCount(p);
			paginate = new Paginate(list,count, size, page);
			mav.addObject("paginate",paginate);
			mav.addObject("list",list);
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
		}
		return mav;
	}
}
