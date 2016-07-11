package cn.uuf.ltxxt.login.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.uuf.domain.Account;
import cn.uuf.domain.data.Carousel;
import cn.uuf.ltxxt.carousel.service.CarouselService;
import cn.uuf.ltxxt.system.permission.service.AccountService;

/**
 * 登录处理类
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date May 12, 2013
 */
@Controller
@RequestMapping("/{auth:auth;?.*}")
public class AuthController extends BaseController{
	
	private final String SUCCESS_URL = "redirect:/index";//登录成功转向页面
	private Ehcache passwordRetryCache;
	@Resource(name="carouseService")
	private CarouselService cService;
	
	@Resource(name="accountService")
	private AccountService accountServer;
	/**
	 * 无参构造方法
	 */
	public AuthController(){
		try{
			CacheManager cacheManager = CacheManager.create(CacheManager.class.getClassLoader().getResource("spring/ehcache.xml"));
			passwordRetryCache = cacheManager.getCache("passwordRetryCache");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 登录页
	 * @return
	 */
	@RequestMapping(value= {"/{login:login;?.*}"})
	public @ResponseBody ModelAndView login(HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("/auth/login");
		mav.addObject("clist",cService.queryList(new Carousel(),0,4));
		return mav;
	}
	/**
	 * 验证登录成功与否
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value= {"/{main:main;?.*}"})
	public ModelAndView signIn(HttpServletRequest request,HttpServletResponse response)throws Exception{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String targetUri = request.getParameter("targetUri");
		if(targetUri == null || !targetUri.equals(""))
			targetUri = "/";
		UsernamePasswordToken token = null;
		token = new UsernamePasswordToken(username, password);
//		token.setRememberMe(true);
		Element element = passwordRetryCache.get(username);
		if (element == null) {
			element = new Element(username, new AtomicInteger(0));
			passwordRetryCache.put(element);
		}
		AtomicInteger retryCount = (AtomicInteger) element.getObjectValue();
		int count = 4-retryCount.get();
		try{
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			beOverdue(getCurrentUser());//过期验证
			this.writer("登录",request.getRemoteAddr(),username);
			return new ModelAndView(SUCCESS_URL);
		}catch(UnknownAccountException e){
			request.setAttribute("message","用户不存在或已停用！");
			this.writer(username+"不存在或已停用",request.getRemoteAddr(),username);
		}catch(IncorrectCredentialsException e){
			request.setAttribute("message","密码不正确！您还有"+count+"次机会");
			this.writer("用户："+username+"密码不正确",request.getRemoteAddr(),username);
		}catch(LockedAccountException e){
			request.setAttribute("message","账户被停用！");
			this.writer(username+"账户被停用",request.getRemoteAddr(),username);
		}catch(ExcessiveAttemptsException e){
			request.setAttribute("message","错误次数已超过5次，账户锁定10分钟");
			this.writer(username+"错误次数过多，被锁定1小时",request.getRemoteAddr(),username);
		}catch(ExpiredCredentialsException e)
		{
			request.setAttribute("message","您的账户已经过期！！");
			this.writer(username+"账户已过期",request.getRemoteAddr(),username);
		}
		return login(request,response);
	}
	/**
	 * 过期验证方法
	 * @param acc
	 * @throws Exception
	 */
	private void beOverdue(Account acc) throws Exception
	{
		String dqsj=acc.getDqsj();
		try {
			if(dqsj==null||dqsj.equals(""))//如果查询不到时间，就没有限制，直接跳过验证
			{
				return ;
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();//判断为空
			return ;
		}
		Date data=new Date();//获取当前时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		Calendar calendar = Calendar.getInstance();
		data=df.parse(df.format(data));  
		Date dateUser=null;
		try {
			dateUser = df.parse(dqsj);//判断时间的格式
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ;
		}
		calendar.setTime(dateUser);
		long tempTime1=calendar.getTimeInMillis();
		calendar.setTime(data);
		long tempTime2=calendar.getTimeInMillis();
		if(tempTime1<=tempTime2)
		{
			throw new ExpiredCredentialsException();//抛出过期的错误
		}
	}
	
	/**
	 * 安全退出
	 * @return
	 */
	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response)throws Exception{
		SecurityUtils.getSubject().logout();
		return login(request, response);
	}
	
	/**
	 * 无权访问
	 * @return
	 */
	@RequestMapping("unauthorized")
	public ModelAndView unauthorized(){
		return new ModelAndView("/auth/unauthorized");
	}
	
}

