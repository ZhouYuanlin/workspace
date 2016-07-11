package cn.uuf.wechat.personal.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.CodeDwb;
import cn.uuf.domain.Retirefamily;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.User;
import cn.uuf.domain.daily.Workdaily;
import cn.uuf.domain.ret.Retireparty;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.wechat.common.controller.WxBaseController;
import cn.uuf.wechat.connect.service.ILtxAccountService;
import cn.uuf.wechat.connect.service.IUserService;
import cn.uuf.wechat.personal.service.ICodeDwbService;
import cn.uuf.wechat.personal.service.IPartyService;
import cn.uuf.wechat.personal.service.IPersonalService;
import cn.uuf.wechat.personal.service.WorkdailyService;

@Controller
@RequestMapping(value="/wechat/personal")
public class PersonalController extends WxBaseController {
	
	@Resource(name="personalService")
	private IPersonalService personalService;
	
	@Resource
	private ILtxAccountService ltxAccountService;
	
	@Resource(name="workdailyService")
	private WorkdailyService workdailyService;
	
	@Resource(name="dwbService")
	private ICodeDwbService dwbService;

	@Resource(name="partyService")
	private IPartyService partyService;
	
	@Resource
	private IUserService userService;
	
	
	/**
	 * 查看个人信息(本人)
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/index")
	public String index(ModelMap model,HttpServletRequest request){
		//根据登录的账号对应的username(身份证号)查询人员的信息
		String userName = getUserName();
		String realPath = request.getSession().getServletContext().getContextPath();
		File file = new File(realPath+"\\upload\\photo\\"+userName+".jpg");
		if(!file.exists()){
			model.put("file", null);
		}
		Retirement retirement = personalService.get(userName);
		if(retirement!=null){
			List<Retirefamily> familys = retirement.getFamilys();
			boolean flag = true;
			String address = null;
			for (Retirefamily retirefamily : familys) {
				if(flag){
					if(retirefamily.getSfmr().equals("是")){
						model.put("address", retirefamily.getJtdz());
						address = retirefamily.getJtdz();
					}
				}
			}
			if(address==null){
				if(familys.size()>0){
					model.put("address", familys.get(0).getJtdz());
				}
			}
		}
		//将提取到的人员信息值返回给界面
		model.put("personal", retirement);
		return "/wechat/personal/index";
	}
	
	/**
	 * 日程信息页面跳转
	 * @param retirement
	 * @param openId
	 * @param model
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/journal")
	public String journal(ModelMap model) throws ParseException{
		getDwDetail(model,null);
		Workdaily workdaily = new Workdaily(); 
		Workdaily workdaily2 = new Workdaily(); 
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date); 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		String dstr=time;  
		Date date1=sdf.parse(dstr); 
		workdaily.setCreateDate(date1);
		//获取当用户姓名,查看对应日志
		String userName = getUserName();
		Account account = ltxAccountService.getUniqueEntity("username", userName);
		workdaily.setXm(account.getRealname());
		workdaily2.setXm(account.getRealname());
		List<Workdaily> list=workdailyService.queryList(workdaily);
		List<Workdaily> list2=workdailyService.queryList(workdaily2);
		for(int i=0;i<list2.size();i++){
			SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-M-d");
			Date dats=list2.get(i).getCreateDate();
			list2.get(i).setType(dateFormater.format(dats)); 
		}
		model.put("list", list);
		model.put("list2", list2);
		return "/wechat/personal/journal";
	}
	
	/**
	 * 日程信息页面刷新
	 * @param retirement
	 * @param openId
	 * @param model
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/journalajax" , method =RequestMethod.POST)
	public void journalLoad(String dateyear,HttpServletRequest request,HttpServletResponse response) throws ParseException{
		Workdaily workdaily = new Workdaily(); 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		String dstr=dateyear;  
		Date date1=sdf.parse(dstr); 
		workdaily.setCreateDate(date1);
		String userName = getUserName();
		Account account = ltxAccountService.getUniqueEntity("username", userName);
		workdaily.setXm(account.getRealname());
		List<Workdaily> list2=workdailyService.queryList(workdaily);
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(JSONArray.fromObject(list2));
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 搜索人员信息页面跳转
	 * @param retirement
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/search")
	public String search(ModelMap model){
		getDwDetail(model,null);
		List<CodeDwb> dwbList = dwbService.getAll("code");
		List<Retireparty> partyList = partyService.getAll("dzbdm");
		model.put("dwList", dwbList);
		model.put("partyList", partyList);
		return "/wechat/personal/search";
	}
	
	
	
	/**
	 * 将搜索到人员信息列表展示
	 * @param retirement
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/search/detail")
	public String search(Retirement retirement,Pageable pageable,ModelMap model){
		getDwDetail(model,retirement);
		Page<Retirement> page = personalService.queryList(retirement,pageable);
		model.put("ret", retirement);
		model.put("page", page);
		return "/wechat/personal/searchDetail";
	}
	
	
	/**
	 * 根据搜索列表的人员信息对应身份证号查询该人员信息
	 * @param sfzh
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/info")
	public String getInfo(String sfzh,ModelMap model){
		Retirement retirement = personalService.get(sfzh);
		if(retirement!=null){
			List<Retirefamily> familys = retirement.getFamilys();
			boolean flag = true;
			String address = null;
			for (Retirefamily retirefamily : familys) {
				if(flag){
					if(retirefamily.getSfmr().equals("是")){
						model.put("address", retirefamily.getJtdz());
						address = retirefamily.getJtdz();
					}
				}
			}
			if(address==null){
				if(familys.size()>0){
					model.put("address", familys.get(0).getJtdz());
				}
			}
		}
		//将提取到的人员信息值返回给界面
		model.put("personal", retirement);
		return "/wechat/personal/info";
	}
	
	
	/**
	 * 个人中心页面跳转
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/center")
	public String center(String message,ModelMap model){
		
		model.put("message", message);
		return "/wechat/personal/center";
	}
	
	
	/**
	 * 个人中心_查看个人资料
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/information")
	public String centerInformation(ModelMap model,HttpServletRequest request){
		String userName = getUserName();
		String realPath = request.getSession().getServletContext().getContextPath();
		File file = new File(realPath+"\\upload\\photo\\"+userName+".jpg");
		if(!file.exists()){
			model.put("file", null);
		}else{
			model.put("file", userName);
		}
		Account account = getCurrentAccount();
		model.put("account", account);
		return "/wechat/personal/information";
	}
	
	/**
	 * 个人中心-密码重置界面跳转
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/pwdreset")
	public String pwdresetSkip(String message,ModelMap model){
		Account account = getCurrentAccount();
		model.put("account", account);
		model.put("message", message);
		return "/wechat/personal/repassword";
	}
	
	/**
	 * 密码修改操作
	 * @param openId
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/repwd")
	public String rePwd(String password,ModelMap model){
		try {
			Account account = getCurrentAccount();
			String pwd = new Md5Hash(password).toHex();
			account.setPassword(pwd);
			ltxAccountService.update(account);
			return "redirect:/wechat/wechatcoreconnect/login?message=true";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/wechat/personal/pwdreset?message=false";
		}
		
	}
	
	/**
	 * 退出当前账号
	 * @param openId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/exitAccount")
	public String exitAccount(ModelMap model){
		return "redirect:/wechat/wechatcoreconnect/login?message=false";
	}
	
	
	/**
	 * 通用方法,用来判断本部门人员你的访问权限
	 * @param openId
	 * @param model
	 * @param retirement
	 */
	private void getDwDetail(ModelMap model,Retirement retirement){
		String hasRoleScope = this.getRoleScope(getCurrentAccount());
		String userName = this.getUserName();
		Retirement ret = personalService.get(userName);
		if(hasRoleScope.equals(Constants.INFOYX)){
			if(ret.getDwb().getSfejdw().equals(Constants.HASYES)){
				model.put("dw", ret.getDwb().getName());
				if(retirement!=null){
					retirement.setDwb(ret.getDwb());
				}
			}
		}
	}
}
