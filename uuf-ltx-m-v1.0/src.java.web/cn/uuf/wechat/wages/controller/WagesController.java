package cn.uuf.wechat.wages.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.uuf.domain.Retirewages;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.util.DateUtils;
import cn.uuf.wechat.common.controller.WxBaseController;
import cn.uuf.wechat.wages.service.IWagesService;

@Controller
@RequestMapping(value="/wechat/wages")
public class WagesController extends WxBaseController{
	
	@Resource
	private IWagesService wagesService;
	
	/**
	 * 查询出所有的活动  并将活动信息展示到页面
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Retirewages wages,Pageable pageable,ModelMap model){
		//查询到所有的活动相关信息传入界面
		String userName = getUserName();
		if(userName!=null){
			wages.setSfzh(userName);
		}
		Page<Retirewages> page = wagesService.queryList(wages, pageable);
		model.put("page", page);
		//工资首页显示当前月份第一天和最后一天
		model.put("getMonthFirstDay", new SimpleDateFormat("MM-dd").format(DateUtils.getMonthFirstDay()));
		model.put("getMonthEndDay", new SimpleDateFormat("MM-dd").format(DateUtils.getMonthEndDay(new Date())));
		return "/wechat/wages/index";
	}
	
	/**
	 * 根据传入的人员ID,查询该人员工资详情
	 * @param id
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/detail")
	public String detail(Long id,ModelMap model){
		Retirewages retirewages = wagesService.get(id);
		model.put("retirewages", retirewages);
		return "/wechat/wages/detail";
	}
}