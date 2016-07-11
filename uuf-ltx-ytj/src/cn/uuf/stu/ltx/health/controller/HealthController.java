package cn.uuf.stu.ltx.health.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.uuf.domain.Retirement;
import cn.uuf.domain.health.Rethealth;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.controller.BaseController;
import cn.uuf.stu.ltx.grxx.service.IGrxxService;
import cn.uuf.stu.ltx.health.service.IHealthService;

@Controller
@RequestMapping(value="/ytj/health")
public class HealthController extends BaseController{
	
	@Resource(name="healthService")
	private IHealthService healthService;
	
	@Resource(name="grxxService")
	private IGrxxService grxxService;
	
	/**
	 * 体检信息列表展示
	 * @param rethealth
	 * @param pageable 分页
	 * @param kssj
	 * @param jzsj
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Rethealth rethealth,Pageable pageable,String kssj,String jzsj,ModelMap model)
	{
		String username = getCurrentUsername();
		Retirement retirement = grxxService.get(username);
		Page<Rethealth> page = healthService.queryList(kssj,jzsj,rethealth,retirement,pageable);
		model.put("page", page);
		model.put("kssj", kssj);
		model.put("jzsj", jzsj);
		model.put("tjxxColor", "#008cbf");
		return "/ltx/health/index";
	}
	
	/**
	 * 查看体检详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/detail")
	public String detail(Long id,ModelMap model){
		Rethealth rethealth = healthService.get(id);
		model.put("rethealth", rethealth);
		return "/ltx/health/detail";
	}
}
