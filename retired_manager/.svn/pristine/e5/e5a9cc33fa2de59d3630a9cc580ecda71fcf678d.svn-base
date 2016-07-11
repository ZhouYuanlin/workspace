package cn.uuf.ltxxt.login.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import cn.uuf.domain.Account;
import cn.uuf.domain.CodeAssetSource;
import cn.uuf.domain.Role;
import cn.uuf.domain.User;
import cn.uuf.domain.meetingroom.MeetingRoom;
import cn.uuf.ltxxt.asset.service.AssetFushuService;
import cn.uuf.ltxxt.asset.service.AssetManageService;
import cn.uuf.ltxxt.meetingRoom.service.MeetingRoomService;
import cn.uuf.ltxxt.party.service.RetirepartyService;
import cn.uuf.ltxxt.retire.service.RetirementService;
import cn.uuf.ltxxt.system.code.service.CodeAssetService;
import cn.uuf.ltxxt.system.code.service.CodeAssetSourceService;
import cn.uuf.ltxxt.system.code.service.CodeBfxmService;
import cn.uuf.ltxxt.system.code.service.CodeBjbjService;
import cn.uuf.ltxxt.system.code.service.CodeDwbService;
import cn.uuf.ltxxt.system.code.service.CodeDybService;
import cn.uuf.ltxxt.system.code.service.CodeJbbService;
import cn.uuf.ltxxt.system.code.service.CodeKtlbService;
import cn.uuf.ltxxt.system.code.service.CodeKtzwService;
import cn.uuf.ltxxt.system.code.service.CodeLxbService;
import cn.uuf.ltxxt.system.code.service.CodeModeService;
import cn.uuf.ltxxt.system.code.service.CodeMzbService;
import cn.uuf.ltxxt.system.code.service.CodeSydService;
import cn.uuf.ltxxt.system.code.service.CodeWwlxService;
import cn.uuf.ltxxt.system.code.service.CodeXlbService;
import cn.uuf.ltxxt.system.code.service.CodeXwbService;
import cn.uuf.ltxxt.system.code.service.CodeXzlbService;
import cn.uuf.ltxxt.system.code.service.CodeZjbService;
import cn.uuf.ltxxt.system.code.service.CodeZwbService;
import cn.uuf.ltxxt.system.code.service.CodeZzmmService;
import cn.uuf.ltxxt.system.permission.service.LogService;
import cn.uuf.ltxxt.system.permission.service.UserService;
import cn.uuf.util.Paginate;


/**
 * 所有controller的父类做些公用方法
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date May 12, 2013
 */
@Controller
public class BaseController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	private static cn.uuf.domain.Log log;
	protected final Integer size = 30;
	protected Paginate paginate;
	protected static String UNAUTHOR_LIST = "redirect:/auth/unauthorized";//无权访问通用页
	@Resource
	private LogService logService;
	@Resource
	protected RetirementService mentService;
	@Resource
	protected CodeDwbService dwbService;
	@Resource
	protected CodeLxbService lxbService;
	@Resource
	protected CodeSydService sydService;
	@Resource
	protected CodeMzbService mzbService;
	@Resource
	protected CodeZwbService zwbService;
	@Resource
	protected CodeZjbService zjbService;
	
	@Resource
	protected CodeAssetService codeAssetService;

	@Resource
	protected CodeAssetSourceService codeAssetSourceService;
	
	@Resource
	protected CodeModeService modeService;
	@Resource
	protected CodeZzmmService zzmmService;
	@Resource
	protected CodeXwbService xwbService;
	@Resource
	protected CodeXlbService xlbService;
	@Resource
	protected CodeWwlxService wwlxService;
	@Resource
	protected CodeKtlbService ktlbService;
	@Resource
	protected CodeKtzwService ktzwService;
	@Resource
	protected CodeXzlbService xzlbService;
	@Resource
	protected CodeBfxmService bfxmService;
	@Resource
	protected CodeJbbService jbbService;
	@Resource
	protected CodeDybService dybService;
	@Resource
	protected CodeBjbjService bjbjService;
	@Resource
	protected UserService userService;
	@Resource
	private RetirepartyService pService;
	@Resource
	private MeetingRoomService meetServce;
	@Resource
	protected AssetFushuService assetFushuService;
	
	/**
	 * 通用的取码表信息，只需要传参可取得，省得每个地方再写相同的代码
	 * @param mav
	 */
	public void getCodeInf(ModelAndView mav){
		try{
			mav.addObject("dwblist",dwbService.getAll());
			mav.addObject("lxblist",lxbService.getAll());
			mav.addObject("sydlist",sydService.getAll());
			mav.addObject("mzblist",mzbService.getAll());
			mav.addObject("zwblist",zwbService.getAll());
			mav.addObject("zjblist",zjbService.getAll());
			mav.addObject("assetlist",codeAssetService.getAll());
			mav.addObject("assetSourcelist",codeAssetSourceService.getAll());
			mav.addObject("zzmmlist",zzmmService.getAll());
			mav.addObject("modelist",modeService.getAll());
			mav.addObject("xwblist",xwbService.getAll());
			mav.addObject("xlblist",xlbService.getAll());
			mav.addObject("wwlxlist",wwlxService.getAll());
			mav.addObject("ktlblist",ktlbService.getAll());
			mav.addObject("ktzwlist",ktzwService.getAll());
			mav.addObject("xzlblist",xzlbService.getAll());
			mav.addObject("bfxmlist",bfxmService.getAll());
			mav.addObject("jbblist",jbbService.getAll());
			mav.addObject("dyblist",dybService.getAll());
			mav.addObject("bjbjlist",bjbjService.getAll());
			mav.addObject("dzblist",pService.getAll());
			mav.addObject("roomlist",meetServce.getAll());
			mav.addObject("assetSublist",assetFushuService.getAll());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			mav.addObject("cd",sdf.format(new Date()));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 判断用户是否有某角色
	 * @param name
	 * @return
	 */
	public boolean hasRole(String name){
		boolean roles = false;
		Subject subject = SecurityUtils.getSubject();
		if(subject.hasRole(name) || subject.hasAllRoles(Arrays.asList(name.split(","))))
			roles = true;
		return roles;
	}
	
	/**
	 * 取得当前登录用户
	 * @return
	 */
	public Account getCurrentUser(){
		Subject subject = SecurityUtils.getSubject();
		return (Account)subject.getPrincipal();
	}
	
	public User getUser(){
		Account account = getCurrentUser();
		return userService.getById(account.getUsername());
	}
	/**
	 * 取得当前用户拥有的角色可访问的用户信息
	 * @return
	 */
	public String hasRoleScope(){
		Account account = getCurrentUser();
		try{
			if(account != null){
				List<Role> r = account.getRoles();
				return r.get(0).getScope();
			}
		}catch(Exception e){
			return null;
		}
		return null;
	}
	
	/**
	 * 记录日志
	 * @param action//动作
	 * @param loginName//登陆名
	 * @param ip//
	 */
	public void writer(String action, String ip, String loginName){
		try{
			 log = new cn.uuf.domain.Log();
			log.setIp(ip);
			log.setAction(action);
			log.setLoginDate(new Date());
			if(loginName != null)
				log.setLoginName(loginName);
			new Thread(){//异步处理
				public void run(){
					try{
						if(BaseController.log != null){
							logService.save(BaseController.log);
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}.start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 身份证号  根据逗号切分
	 * @param sfzh
	 * @return
	 */
	public String splitSfzh(String sfzh){
		String[] split = sfzh.split(",");
		return split[0];
	}
}

