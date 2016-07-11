package cn.uuf.wechat.connect.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.stu.framework.common.Message;
import cn.uuf.stu.framework.shiro.Principal;
import cn.uuf.wechat.common.controller.WxBaseController;
import cn.uuf.wechat.connect.common.Lejian;
import cn.uuf.wechat.connect.service.ILtxAccountService;

/**
* 微信核心链接类
* <p>标题：WeChatCoreConnectController</p>
* <p>简介：</p>
* @author tl
* @date 2016年5月16日 下午7:13:49
*/
@Controller
@RequestMapping(value="/wechat/wechatcoreconnect")
public class WeChatCoreConnectController extends WxBaseController {
	
	@Resource
	private ILtxAccountService ltxAccountService;
	
	/**
	 * get请求验证
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void getHandle(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			Lejian lejian = new Lejian(request);
			String result = lejian.execute();
			response.getOutputStream().write(result.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * post请求分化请求处理
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void postHandle(HttpServletRequest request, HttpServletResponse response) throws IOException{
		 Lejian lejian = new Lejian(request);
		 String result = lejian.execute();
		 response.getOutputStream().write(result.getBytes());
	}
	
	/**
	 * 调整到欢迎页
	 * @param openId
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(ModelMap model){
		return "/wechat/welcome";
	}
	
	/**
	 * 调整到首页
	 * @param openId
	 * @return
	 */
	@RequestMapping(value="/index/home")
	public String indexs(ModelMap model){
		Account account = getCurrentAccount();
		String scope = this.getRoleScope(account);
		model.put("scope", scope);
		return "/wechat/index";
	}
	
	/**
	 * 登录页
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(String message,ModelMap model){
		model.put("message", message);
		return "/wechat/login";
	}
	
	
	/**
	 * 去登录
	 * @param association
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/toLogin",method=RequestMethod.POST)
	public @ResponseBody Message toLogin(Account account,ModelMap model,HttpServletRequest request, HttpServletResponse response, HttpSession session){
		List<Account> account2 = ltxAccountService.getAccount(account);
		if(CollectionUtils.isEmpty(account2)){
			return Message.error("用户名不存在!");
		}else{
			String password = account.getPassword();
			if(account2.get(0).getPassword().equals(password)){
				session.setAttribute(Constants.USER_ATTRIBUTE_NAME, new Principal(account2.get(0).getId(), account2.get(0).getUsername(),account2.get(0).getRealname()));
				return Message.success("登录成功！");
			}else{
				return Message.error("密码错误！");
			}
		}
	}
	
	@RequestMapping("testqx")
	public String testQx(String openId){
		return "/wechat/testqx";
	}
}
