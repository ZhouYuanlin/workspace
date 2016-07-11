package cn.uuf.stu.ltx.index.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.uuf.domain.Account;
import cn.uuf.stu.framework.controller.BaseController;
import cn.uuf.stu.ltx.login.service.IAccountService;

/**
 * 首页
* <p>标题：IndexController</p>
* <p>简介：</p>
* @author tl
* @date 2016年6月8日 下午2:49:20
 */
@Controller
@RequestMapping(value="/ytj/index")
public class IndexController extends BaseController {
	
	@Resource(name="accountService")
	private IAccountService accountService;
	
	@RequestMapping
	public String index(ModelMap model){
		Account account = getCurrent();
		model.put("account", account);
		return "/ltx/index/index";
	}
	
}
