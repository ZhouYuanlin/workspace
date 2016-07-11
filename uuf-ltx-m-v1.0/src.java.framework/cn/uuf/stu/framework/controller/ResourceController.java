package cn.uuf.stu.framework.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.stu.entity.framework.WRole;
import cn.uuf.stu.framework.common.Message;
import cn.uuf.stu.framework.service.IResourceService;
import cn.uuf.stu.framework.service.IRoleService;




/**
* 资源 controller
* @ClassName: ResourceController 
* @author tangpeng
* @date 2015年8月12日 下午3:42:16 
*
*/
@Controller
@RequestMapping("/admin/resource")
public class ResourceController extends BaseController {
	
	@Resource(name="resourceService")
	private IResourceService resourceService;
	@Resource(name="roleService")
	private IRoleService roleService;
	
	/**
	* 首页
	* @return    
	* String
	 */
	@RequiresPermissions("resource:view")
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model,Long id){
		List<cn.uuf.stu.entity.framework.WResource> resources = resourceService.getAll("sort");
		Long rId = 0L;
		if(id != null){
			model.put("rId", id);
		}else{
			for (cn.uuf.stu.entity.framework.WResource resource : resources) {
				if(resource.getParent()==null){
					rId = resource.getId();
					break;
				}
			}
			model.put("rId", rId);
		}
		model.put("resources", resources);
		return "/admin/resource/index";
	}
	
	/**
	* 创建资源
	* @param resource
	* @return    
	* String
	 */
	@RequiresPermissions("resource:create")
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String create(cn.uuf.stu.entity.framework.WResource resource,ModelMap model){
		List<cn.uuf.stu.entity.framework.WResource> rootMenus = resourceService.getRootMenu();
		model.put("rootMenus", rootMenus);
		model.put("types",cn.uuf.stu.entity.framework.WResource.Type.values());
		model.put("resource", resource);
		return "/admin/resource/create";
	}
	
	/**
	* 保存资源信息
	* @param resource
	* @param parentId
	* @param redirectAttributes
	* @return    
	* String
	 */
	@RequiresPermissions("resource:create")
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(cn.uuf.stu.entity.framework.WResource resource,Long parentId,RedirectAttributes redirectAttributes){
		if(!isValid(resource)){
			return ERROR_VIEW;
		}
		cn.uuf.stu.entity.framework.WResource chiResource=null;
		if(parentId != null){
			cn.uuf.stu.entity.framework.WResource pResource = resourceService.load(parentId);
			List<cn.uuf.stu.entity.framework.WResource> childrens = pResource.getChildrens();
			if(CollectionUtils.isNotEmpty(childrens)){
				chiResource = childrens.get(childrens.size()-1);
				resource.setSort(chiResource.getSort()+1);
			}else{
				resource.setSort(1);
			}
			resource.setParent(resourceService.load(parentId));
		}else{
			List<cn.uuf.stu.entity.framework.WResource> rootMenus = resourceService.getRootMenu();
			chiResource = rootMenus.get(rootMenus.size()-1);
			resource.setSort(chiResource.getSort()+1);
		}
		resourceService.save(resource);
		addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		return "redirect:/admin/resource";
	}
	
	
	
	
	/**
	* 更新
	* @param id
	* @param model
	* @return    
	* String
	 */
	@SuppressWarnings("unused")
	@RequiresPermissions("resource:edit")
	@RequestMapping(value ="/edit",method = RequestMethod.GET)
	public String edit(Long id,ModelMap model,RedirectAttributes redirectAttributes){
		cn.uuf.stu.entity.framework.WResource resource = resourceService.load(id);
		List<cn.uuf.stu.entity.framework.WResource> rootMenus = resourceService.getRootMenu();
		cn.uuf.stu.entity.framework.WResource parentResource = resource.getParent();
		List<cn.uuf.stu.entity.framework.WResource> brotherResource = null;
		if(parentResource != null){
			brotherResource = parentResource.getChildrens();
		}else{
			brotherResource = rootMenus;
		}
		model.put("brotherResource", brotherResource);
		model.put("rootMenus", rootMenus);
		model.put("types",cn.uuf.stu.entity.framework.WResource.Type.values());
		model.put("resource", resource);
		return "/admin/resource/edit";
	}
	
	/**
	* 更新
	* @param resource
	* @param parentId
	* @param redirectAttributes
	* @return    
	* String
	*/
	@RequiresPermissions("resource:edit")
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(cn.uuf.stu.entity.framework.WResource resource,Long parentId,Long preId,RedirectAttributes redirectAttributes){
		if(!isValid(resource)){
			return ERROR_VIEW;
		}
		cn.uuf.stu.entity.framework.WResource srcResource = resourceService.load(resource.getId());
		if(parentId != null){
			cn.uuf.stu.entity.framework.WResource parentResource = resourceService.load(parentId);
			resource.setParent(parentResource);
			if(preId != null){
				cn.uuf.stu.entity.framework.WResource preResource = resourceService.load(preId);
				List<cn.uuf.stu.entity.framework.WResource> brotherList = preResource.getParent().getChildrens();
				if(srcResource.getSort()>preResource.getSort()){
					for (cn.uuf.stu.entity.framework.WResource brother : brotherList) {
						if(brother.getSort()>preResource.getSort()&&brother.getSort()<srcResource.getSort()){
							brother.setSort(brother.getSort()+1);
						}
					}
					resource.setSort(preResource.getSort()+1);
				}else{
					resource.setSort(preResource.getSort());
					for (cn.uuf.stu.entity.framework.WResource brother : brotherList) {
						if(brother.getSort()>srcResource.getSort()&&brother.getSort()<preResource.getSort()+1){
							brother.setSort(brother.getSort()-1);
						}
					}
				}
			}else{
				List<cn.uuf.stu.entity.framework.WResource> brotherList = srcResource.getParent().getChildrens();
				for (cn.uuf.stu.entity.framework.WResource brother : brotherList) {
					if(brother.getSort()>0&&brother.getSort()<srcResource.getSort()){
						brother.setSort(brother.getSort()+1);
					}
				}
				resource.setSort(1);
			}
		}else{
			List<cn.uuf.stu.entity.framework.WResource> rootMenus = resourceService.getRootMenu();
			if(preId != null){
				cn.uuf.stu.entity.framework.WResource preResource = resourceService.load(preId);
				if(srcResource.getSort()>preResource.getSort()){
					for (cn.uuf.stu.entity.framework.WResource brother : rootMenus) {
						if(brother.getSort()>preResource.getSort()&&brother.getSort()<srcResource.getSort()){
							brother.setSort(brother.getSort()+1);
						}
					}
					resource.setSort(preResource.getSort()+1);
				}else{
					resource.setSort(preResource.getSort());
					for (cn.uuf.stu.entity.framework.WResource brother : rootMenus) {
						if(brother.getSort()>srcResource.getSort()&&brother.getSort()<preResource.getSort()+1){
							brother.setSort(brother.getSort()-1);
						}
					}
				}
			}else{
				for (cn.uuf.stu.entity.framework.WResource brother : rootMenus) {
					if(brother.getSort()>0&&brother.getSort()<srcResource.getSort()){
						brother.setSort(brother.getSort()+1);
					}
				}
				resource.setSort(1);
			}
		}
		resourceService.update(resource,resource.getId(),"roles","childrens");
		addFlashMessage(redirectAttributes, SUCCESS_MESSAGE);
		return "redirect:/admin/resource/edit?id="+resource.getId();
	}
	
	/**
	* 删除
	* @param id
	* @return    
	* Message
	*/
	@RequiresPermissions("resource:delete")
	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public @ResponseBody Message delete(Long id){
		cn.uuf.stu.entity.framework.WResource resource = resourceService.load(id);
		if(resource == null){
			return ERROR_MESSAGE;
		}
		List<cn.uuf.stu.entity.framework.WResource> childrens = resource.getChildrens();
		if(!CollectionUtils.isEmpty(childrens)){
			return Message.error("admin.resource.deleteExistChildrenNotAllowed");
		}
		List<WRole> roles = resource.getRoles();
		if(!CollectionUtils.isEmpty(roles)){
			for (WRole role : roles) {
				role.getResoures().remove(resource);
			}
		}
		//重新维护排序
		if(resource.getParent()!=null){
			List<cn.uuf.stu.entity.framework.WResource> brothers = resource.getParent().getChildrens();
			if(brothers.size()>1){
				for (cn.uuf.stu.entity.framework.WResource brother : brothers) {
					if(resource.getSort()<brother.getSort()){
						brother.setSort(brother.getSort()-1);
					}
				}
			}
		}else{
			List<cn.uuf.stu.entity.framework.WResource> brothers = resourceService.getRootMenu();
			if(brothers.size()>1){
				for (cn.uuf.stu.entity.framework.WResource brother : brothers) {
					if(resource.getSort()<brother.getSort()){
						brother.setSort(brother.getSort()-1);
					}
				}
			}
		}
		resourceService.update(resource);
		resourceService.delete(id);
		return SUCCESS_MESSAGE;
	}

	
	
	
	
	
	
}
