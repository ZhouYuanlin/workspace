package cn.uuf.stu.ltx.login.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.uuf.domain.Account;
import cn.uuf.stu.constants.Constants;
import cn.uuf.stu.framework.common.Message;
import cn.uuf.stu.framework.common.Principal;
import cn.uuf.stu.framework.controller.BaseController;
import cn.uuf.stu.ltx.login.service.IAccountService;
import zkteco.id100com.jni.*;

/**
* 
* <p>标题：LoginController</p>
* <p>简介：</p>
* @author tl
* @date 2016年5月27日 下午4:35:04
*/
@Controller
@RequestMapping(value="/login")
public class LoginController extends BaseController {
	
	@Resource(name="accountService")
	private IAccountService accountService;
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String index(){
		return "/ltx/login/index";
	}
	
	/**
	 * 登录提交
	 * @return
	 */
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	public @ResponseBody Message submit(String username,String password, HttpServletRequest request, HttpServletResponse response, HttpSession session){
		
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
			return Message.error("用户名或密码不能为空！");
		}
		Account account = accountService.getUniqueEntity("username", username);
		if(account == null){
			return Message.error("用户名不存在！");
		}
		if(!DigestUtils.md5Hex(password).equals(account.getPassword())){
			return Message.error("密码错误！");
		}
		session.setAttribute(Constants.USER_ATTRIBUTE_NAME, new Principal(account.getId(), account.getUsername()));
		return Message.success("登录成功！");
	}
	

	
	/**
	 * 身份证登录提交
	 * @return
	 */
	@RequestMapping(value="/sfzhSubmit",method=RequestMethod.POST)
	public @ResponseBody Message sfzSubmit(HttpServletRequest request, HttpServletResponse response, HttpSession session){
		try{
			int nPort;//串口号
			id100sdk.HIDVoice(0);
			if((nPort=id100sdk.InitCommExt()) <= 0){
				return Message.error("身份证阅读器还在调试，请换机操作！");
			}
			if(id100sdk.Authenticate() != 1){
				return Message.error("身份证无法认证，请再次尝试！");
			}
			if(id100sdk.ReadContent(1) != 1){
				return Message.error("读卡错误，请再次尝试！");
			}
			String username = id100sdk.getIDNum();
			Account account = accountService.getUniqueEntity("username", username);
			if(account == null){
				return Message.error("用户不存在！");
			}
			session.setAttribute(Constants.USER_ATTRIBUTE_NAME, new Principal(account.getId(), account.getUsername()));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return Message.success("登录成功！");
	}
	
	
	
	
	
	
	
	
	

}
