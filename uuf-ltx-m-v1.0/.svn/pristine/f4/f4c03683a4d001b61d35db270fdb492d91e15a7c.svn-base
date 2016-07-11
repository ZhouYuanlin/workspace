package cn.uuf.stu.framework.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import cn.uuf.stu.entity.framework.WAccount;
import cn.uuf.stu.entity.framework.WRole;
import cn.uuf.stu.entity.framework.RoleScope;
import cn.uuf.stu.entity.framework.Save;
import cn.uuf.stu.entity.framework.RoleScope.RSCOPE;

import cn.uuf.stu.framework.common.Message;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.service.IAccountService;
import cn.uuf.stu.framework.service.IRoleService;



/**
* 账号  controller
* @ClassName: AccountController
* @author tangpeng 
* @date 2015年8月6日 上午10:53:10
*
*/
@Controller("accountController")
@RequestMapping("/admin/account")
public class AccountController extends BaseController {
	
	@Resource(name="accountService")
	private IAccountService accountService;
	
	@Resource(name="roleService")
	private IRoleService roleService;
	
	
	
	/**
	* 检查用户名是否存在
	*/
	@RequiresPermissions("account:view")
	@RequestMapping(value="/ckeckUsername",method = RequestMethod.GET)
	public @ResponseBody 
	boolean checkUsername(String username){
		if(StringUtils.isEmpty(username)){
			return false;
		}
		return accountService.count("username", username)==0?true:false;
	}
	
	/**
	* 账号列表
	 */
	@RequiresPermissions("account:view")
	@RequestMapping(method = RequestMethod.GET)
	public String index(WAccount account,Pageable pageable,ModelMap model,Long roleId){
		WRole role = new WRole();
		role.setId(roleId);
		Page<WAccount> page = accountService.getList(account,pageable,role);
		List<WRole> list = roleService.getAll();
		model.put("page",page);
		model.put("account", account);
		model.put("roleList", list);
		model.put("roleId", roleId);
		return "/admin/account/index";
	}
	
	/**
	* 添加
	 */
	@RequiresPermissions("account:create")
	@RequestMapping(value="/create",method = RequestMethod.GET)
	public String add(ModelMap model,WAccount account){
		
		model.put("roles",roleService.getAll());
		model.put("account", account);
		
		return "/admin/account/create";
	}
	
	/**
	* 编辑
	* @param id
	* @param map
	* @return    
	* String
	*/
	@RequiresPermissions("account:edit")
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(Long id,ModelMap model){
		
		WAccount account = accountService.load(id);
		List<WRole> roles = roleService.getAll();
		List<WRole> roles2 = account.getRoles();
		if(CollectionUtils.isNotEmpty(roles2)){
			WRole role = roles2.get(0);
			RoleScope scope = role.getRoleScope();
			
		}
		model.put("account", account);
		model.put("roles", roles);
//		model.put("jxdwList", jxdwList);
		return "/admin/account/edit";
	}
	
	
	/**
	* 更新
	* @return    
	* String
	*/
	@RequiresPermissions("account:edit")
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(WAccount account,Long[] roleIds,Long dwId,Long[] bjh,RedirectAttributes redirectAttributes){
		account.setRoles(new ArrayList<WRole>(roleService.getList(roleIds)));
		if(!isValid(account, Save.class)){
			return ERROR_VIEW;
		}
		WAccount account2 = accountService.load(account.getId());
		List<WRole> roles2 = account2.getRoles();
		if(CollectionUtils.isNotEmpty(roles2)){
			WRole role = roles2.get(0);
			RoleScope scope = role.getRoleScope();
			if(scope.getrScope().toString().equals(RSCOPE.GR.toString())){
				//学生
//				accountService.updateXsAccount(account,xjb);
				addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
			}else{
				//教师
				//教师账号
				   if(scope.toString().equals(RSCOPE.FDY.toString())){
					   if(bjh==null){
						   addFlashMessage(redirectAttributes, Message.error("辅导员角色必须选择班号！"));
						   return "redirect:/admin/account/edit";
					   }
				   }
//				   accountService.updateJsbAccount(codeJsb,account,bjh);
				   addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
			}
		}
		return "redirect:/admin/account";
	}

	
	
	/**
	* 保存
	 */
	@RequiresPermissions("account:create")
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(WAccount account,Long dwId,Long[] bjh,Long[] roleIds,RedirectAttributes redirectAttributes){
		account.setRoles(new ArrayList<WRole>(roleService.getList(roleIds)));
		if(!isValid(account, Save.class)){
			return ERROR_VIEW;
		}
		if(accountService.count("username", account.getUsername())>0){
			return ERROR_VIEW;
		}
		account.setPassword(DigestUtils.md5Hex(account.getPassword()));
		account.setIsLocked(false);
		account.setLoginFailureCount(0);
		account.setLockedDate(null);
		account.setLoginDate(null);
		account.setLoginIp(null);
		
		WRole role = roleService.load(roleIds[0]);
		RSCOPE scope = role.getRoleScope().getrScope();
//		CodeDwb codeDwb = new CodeDwb();
//		codeDwb.setId(dwId);
		switch (scope){
		   case GR:{
			   //学生账号
			   if(bjh==null||bjh.length!=1){
				   addFlashMessage(redirectAttributes, Message.error("学生角色请选择一个班号"));
				   return "redirect:/admin/account/create";
			   }
//			   Xjb xjb = new Xjb();
//			   CodeBjb codeBjb = new CodeBjb();
//			   codeBjb.setId(bjh[0]);
//			   account.setActivate("0");
//			   xjb.setXh(account.getUsername());
//			   xjb.setXm(account.getXm());
//			   xjb.setCodebjb(codeBjb);
//			   xjb.setCodedwb(codeDwb);
//			   accountService.saveXsAccount(account,xjb);
			   addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		   };break;
		   default:{
			   //教师账号
			   if(scope.toString().equals(RSCOPE.FDY.toString())){
				   if(bjh==null){
					   addFlashMessage(redirectAttributes, Message.error("辅导员角色必须选择班号！"));
					   return "redirect:/admin/account/create";
				   }
			   }
//			   CodeJsb jsb = new CodeJsb();
//			   jsb.setJsh(account.getUsername());
//			   jsb.setJsm(account.getXm());
//			   jsb.setDwb(codeDwb);
			   account.setActivate("1");
//			   accountService.saveJsbAccount(jsb,account,bjh);
		   }break;
		}
		return "redirect:/admin/account";
	}
	
	/**
	* 删除
	* @param ids
	* @return    
	* Message
	 */
	@RequiresPermissions("account:delete")
	@RequestMapping("/delete")
	public @ResponseBody Message delete(Long[] ids){
		try {
			if(ids != null){
				for (Long id : ids) {
					WAccount account = accountService.load(id);
					
				}
			}
			accountService.delete(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return Message.error("delete.fail","");
		}
		return SUCCESS_MESSAGE;
	}
	
	
	/**
	 * 编辑密码
	 * @return
	 */
	@RequiresPermissions(value="account:editPass")
	@RequestMapping(value="/editPass",method=RequestMethod.GET)
	public String editPass(Long id,ModelMap model){
		WAccount account = accountService.get(id);
		model.put("account", account);
		return "/admin/account/editPass";
	}
	
	/**
	 * 保存密码
	 * @param account
	 * @param redirectAttributes
	 * @return
	 */
	@RequiresPermissions(value="account:editPass")
	@RequestMapping(value="/updatePass",method=RequestMethod.POST)
	public String updatePass(WAccount account,RedirectAttributes redirectAttributes){
		try {
			WAccount account_ = accountService.load(account.getId());
			account_.setPassword(DigestUtils.md5Hex(account.getPassword()));
			accountService.update(account_);
			addFlashMessage(redirectAttributes,SUCCESS_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			addFlashMessage(redirectAttributes, ERROR_MESSAGE);
		}
		return "redirect:/admin/account";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
