package cn.uuf.stu.framework.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.stu.entity.framework.WRole;
import cn.uuf.stu.entity.framework.RoleScope;
import cn.uuf.stu.framework.common.Message;
import cn.uuf.stu.framework.service.IResourceService;
import cn.uuf.stu.framework.service.IRoleScopeService;
import cn.uuf.stu.framework.service.IRoleService;


/**
* 角色  controller
* @ClassName: RoleController 
* @author tangpeng
* @date 2015年8月18日 下午9:27:55 
*
 */
@RequestMapping("/admin/role")
@Controller(value="roleController")
public class RoleController extends BaseController {
	
	@Resource(name="roleService")
	private IRoleService roleService;
	
	@Resource(name="resourceService")
	private IResourceService resourceService;
	
	@Resource(name="roleScopeService")
	private IRoleScopeService roleScopeService;
	
	@RequiresPermissions("role:view")
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model){
		List<WRole> roleList = roleService.getAll();
		model.put("roleList", roleList);
		return "/admin/role/index";
	}
	
	/**
	* 创建
	* @param role
	* @return    
	* String
	*/
	@RequiresPermissions("role:create")
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String Create(WRole role,ModelMap model){
		List<cn.uuf.stu.entity.framework.WResource> resources = resourceService.getAll();
		List<RoleScope> roleScopeList = roleScopeService.getAll();
		model.put("rcList", roleScopeList);
		model.put("resources", resources);
		model.put("role", role);
		return "/admin/role/create";
	}
	
	/**
	* 保存
	* @param role
	* @param ids
	* @return    
	* String
	 */
	@RequiresPermissions("role:create")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(WRole role,RedirectAttributes redirectAttributes,Long ... ids){
		if(!isValid(role)){
			return ERROR_VIEW;
		}
		role.setResoures(resourceService.getList(ids));
		roleService.save(role);
		addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		return "redirect:/admin/role";
	}
	
	/**
	* 编辑
	* @param id
	* @param model
	* @param redirectAttributes
	* @return    
	* String
	 */
	@RequiresPermissions("role:edit")
	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public String edit(Long id,ModelMap model,RedirectAttributes redirectAttributes){
		WRole role = roleService.load(id);
		List<cn.uuf.stu.entity.framework.WResource> resources = resourceService.getAll();
		List<RoleScope> roleScopeList = roleScopeService.getAll();
		model.put("rcList", roleScopeList);
		model.put("role", role);
		model.put("resources", resources);
		return "/admin/role/edit";
	}
	
	/**
	* 更新
	* @param role
	* @param redirectAttributes
	* @param ids
	* @return    
	* String
	*/
	@RequiresPermissions("role:edit")
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String update(WRole role,RedirectAttributes redirectAttributes,Long ... ids){
		if(!isValid(role)){
			return ERROR_VIEW;
		}
		role.setResoures(resourceService.getList(ids));
		roleService.update(role, role.getId(),"accounts","categorys");
		addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		return "redirect:/admin/role";
	}
	
	/**
	 * 删除
	 * @param ids
	 */
	@RequiresPermissions("role:delete")
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public @ResponseBody Message delete(Long[] ids){
		if(ids != null){
			for (Long id : ids) {
				WRole role = roleService.load(id);
				if(role.getAccounts() != null && ! role.getAccounts().isEmpty()){
					return Message.error("admin.role.deleteExistNotAllowed", role.getRoleName());
				}
			}
			roleService.delete(ids);
			return SUCCESS_MESSAGE;
		}
		return ERROR_MESSAGE;
	}
	
	

}
