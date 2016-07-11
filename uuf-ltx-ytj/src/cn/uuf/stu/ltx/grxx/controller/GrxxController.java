package cn.uuf.stu.ltx.grxx.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.uuf.domain.Retirefamily;
import cn.uuf.domain.Retirement;
import cn.uuf.stu.framework.controller.BaseController;
import cn.uuf.stu.ltx.grxx.service.IGrxxService;


/**
 * 个人信息
 * @author Suntingwen
 *
 */
@Controller
@RequestMapping("/ytj/grxx")
public class GrxxController extends BaseController {
	
	@Resource(name="grxxService")
	private IGrxxService grxxService;
	
	/**
	 * 个人信息首页
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(ModelMap model){
		//得到当前登录的用户名(对应人员身份证号)
		String username = getCurrentUsername();
		//得到当前人员信息
		Retirement retirement = grxxService.get(username);
		boolean flag = true;
		//得到对应的家庭信息
		List<Retirefamily> familys = retirement.getFamilys();
		for (Retirefamily retirefamily : familys) {
			if(flag){
				//如果是默认地址,优先展示默认地址
				if(retirefamily.getSfmr().equals("是")){
					model.put("family", retirefamily);
					flag = false;
				}
			}
		}
		if(flag){
			if(familys.size()>0){
				//不是默认地址的情况下,返回查询的结果集中的第一个家庭地址
				model.put("family", familys.get(0));
			}
		}
		model.put("familys", familys);
		model.put("retment", retirement);
		model.put("grxxColor", "#008cbf");
		return "/ltx/person/grxx";
	}
}
