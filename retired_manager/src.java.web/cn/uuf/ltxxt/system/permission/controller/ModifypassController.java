package cn.uuf.ltxxt.system.permission.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.permission.service.AccountService;

/**
 * 修改密码
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-28
 */
@Controller
@RequestMapping("{modifypass:modifypass;*.?}")
public class ModifypassController extends BaseController{

	@Resource
	private AccountService aService;
	
	@RequestMapping
	public ModelAndView edit(){
		ModelAndView mav = new ModelAndView("permission/user/editpass");
		mav.addObject("a",this.getCurrentUser());
		return mav;
	}
	/**
	 * 修改密码
	 * @param newp
	 * @param request
	 * @param red
	 * @return
	 */
	@RequestMapping("{modify:modify;*.?}")
	public ModelAndView modify(String newp,HttpServletRequest request,RedirectAttributes red){
		try{
			Account accc = aService.getByUserName(this.getCurrentUser().getUsername());
			accc.setPassword(new Md5Hash(newp).toHex());
			aService.update(accc);
			red.addFlashAttribute(Constants.MESSAGE_NAME,"修改密码成功");
		}catch(Exception e){
			red.addFlashAttribute(Constants.MESSAGE_NAME, "修改密码失败！");
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/modifypass");
	}
	
}

