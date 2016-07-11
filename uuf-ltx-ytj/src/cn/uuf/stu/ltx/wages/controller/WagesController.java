/**
 * 
 */
package cn.uuf.stu.ltx.wages.controller;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.uuf.domain.Retirewages;
import cn.uuf.domain.Retirement;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.controller.BaseController;
import cn.uuf.stu.ltx.wages.service.IWagesService;
import cn.uuf.stu.ltx.grxx.service.IGrxxService;

@Controller
@RequestMapping(value="/ytj/wages")
public class WagesController extends BaseController{
	
	@Resource(name="wagesService")
	private IWagesService wagesService;
	
	@Resource(name="grxxService")
	private IGrxxService grxxService;
	
	/**
	 * 查询出所有的活动  并将活动信息展示到页面
	 * @param wages
	 * @param pageable
	 * @param kssj 发放时间起
	 * @param jzsj 发放时间止
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(Retirewages wages,Pageable pageable,String kssj,String jzsj,ModelMap model){
		try{
		//查询到所有的活动相关信息传入界面
		String userName = getCurrentUsername();
		Retirement retirement = grxxService.get(userName);
		Page<Retirewages> page = wagesService.queryList(kssj, jzsj, wages,retirement,pageable);
		model.put("page", page);
		model.put("kssj", kssj);
		model.put("jzsj", jzsj);
		model.put("gzxxColor", "#008cbf");
		}
		catch(Exception e){
			e.printStackTrace();
		}
			return "/ltx/wages/index";
	}
	
	/**
	 * 根据传入的人员ID,查询该人员工资详情
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/detail")
	public String detail(Long id,String status,ModelMap model){
		try{
			Retirewages retirewages = wagesService.get(id);
			switch(status)
			{
			case "0":
				model.put("retirewages", retirewages);
				break;
			case "1":
				Retirewages nextRetirewages = wagesService.getnextMonth(retirewages);
				if(nextRetirewages == null){
					model.put("status", "1");
					model.put("retirewages", retirewages);
					return "/ltx/wages/detail";
				}
				model.put("retirewages", nextRetirewages);
				break;
			case "-1":
				Retirewages lastRetirewages = wagesService.getlastMonth(retirewages);
				if(lastRetirewages == null){
					model.put("status", "-1");
					model.put("retirewages", retirewages);
					return "/ltx/wages/detail";
				}
				model.put("retirewages", lastRetirewages);
				break;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "/ltx/wages/detail";
	}
}
