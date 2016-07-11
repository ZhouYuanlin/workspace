package cn.uuf.ltxxt.system.permission.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.User;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.permission.service.AccountService;
import cn.uuf.ltxxt.system.permission.service.UserService;
import cn.uuf.util.AddSQLQuery;

/**
 * 个人信息除退休人员外的用户
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-27
 */
@Controller
@RequestMapping("{information:information;*.?}")
public class InformationController extends BaseController{

	@Resource
	private UserService uService;
	@Resource
	private AccountService aService;
	@RequestMapping
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView("permission/user/info");
		try{
			User u = uService.getById(this.getCurrentUser().getUsername());
			mav.addObject("u",u);
			mav.addObject("dwblist",this.dwbService.getAll());
		}catch(Exception e){
			e.printStackTrace();
			mav.addObject(Constants.MESSAGE_NAME,"未找到数据");
		}
		return mav;
	}
	@RequestMapping("{bindlogin:bindlogin;*.?}")
	public ModelAndView bindlogin(User u,RedirectAttributes red){
		try{
			Account a = aService.queryByLoginName(this.getCurrentUser().getUsername());
			List<Account> list = new ArrayList<Account>();
			if(u.getLxdh() != null && !u.getLxdh().equals("")){
				a = new  Account();
				a.setLxdh(u.getLxdh());
				list = aService.queryList(a,0,Integer.MAX_VALUE);
				if(list.size() > 2){
					red.addFlashAttribute(Constants.MESSAGE_NAME,"手机号已占用，不能绑定");
					return new ModelAndView("redirect:/information");
				}
			}
			if(u.getGzzh() != null && !u.getGzzh().equals("")){
				a = new  Account();
				a.setGzzh(u.getGzzh());
				list = aService.queryList(a,0,Integer.MAX_VALUE);
				if(list.size() > 2){
					red.addFlashAttribute(Constants.MESSAGE_NAME,"用户名已注册，不能绑定");
					return new ModelAndView("redirect:/information");
				}
			}
			if((list.size() == 1 && list.get(0).getUsername().equals(this.getCurrentUser().getUsername())) || list.size() == 0){
				Account ac = this.getCurrentUser();
				ac.setLxdh(u.getLxdh());ac.setGzzh(u.getGzzh());
				aService.update(ac);
				User us = uService.getById(this.getCurrentUser().getUsername());
				us = (User) AddSQLQuery.setObjectValue(u,us);
				uService.update(us);
				red.addFlashAttribute(Constants.MESSAGE_NAME,"绑定成功");
			}else{
				red.addFlashAttribute(Constants.MESSAGE_NAME,"想要绑定的信息已被占用");
			}
		}catch(Exception e){
			e.printStackTrace();
			red.addFlashAttribute(Constants.MESSAGE_NAME,"绑定失败");
		}
		return new ModelAndView("redirect:/information");
	}
}

