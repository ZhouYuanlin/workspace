package cn.uuf.ltxxt.system.permission.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Resource;
import cn.uuf.domain.Role;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.permission.service.ResourceService;
import cn.uuf.ltxxt.system.permission.service.RoleService;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date May 13, 2013
 */
@Controller
@RequestMapping("/{resource:resource;?.*}")
public class ResourceController extends BaseController{

	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private RoleService roleService;
	
	private final String LIST_ACTION = "redirect:/resource";
	
	@RequestMapping
	public ModelAndView index(Integer page,HttpServletRequest request,HttpServletResponse response,Long rid)throws Exception{
		ModelAndView mav = new ModelAndView("permission/resource/index");
		try{
			List<Resource> list = resourceService.getAll();
			mav.addObject("list",list);
			if (rid==null) {
				mav.addObject("rs", list.get(0));
			}else{
				mav.addObject("rs", resourceService.getById(rid));
			}
			mav.addObject("roList",roleService.getAll());
		}catch(Exception e){
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("create")
	public ModelAndView create(HttpServletRequest request,HttpServletResponse response,Resource resource)throws Exception{
		ModelAndView mav = new ModelAndView("permission/resource/create");
		mav.addObject("list",resourceService.getAll());
		mav.addObject("roList",roleService.getAll());
		mav.addObject("rs", resource);
		return mav;
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,@Valid Resource resource,BindingResult result,Long parentId,RedirectAttributes redAttr,Long... roleId)throws Exception{
		ModelAndView mav = new ModelAndView(LIST_ACTION);
		try{
			if(result.hasErrors()){
				List<ObjectError> ls = result.getAllErrors();
				String error = "";
				for(ObjectError oe : ls){
					error = oe.getDefaultMessage();
				}
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME, error);
				redAttr.addFlashAttribute("rs", resource);
				return new ModelAndView("redirect:/resource/create");
			}
			
			if (roleId!=null) {
				List<Role> rList = new ArrayList<Role>();
				for(Long r : roleId){
					Role role = roleService.getById(r);
					rList.add(role);
				}
				resource.setRoles(rList);				
			}

			if(parentId != null){
				Resource rs = resourceService.getById(parentId);
				resource.setParent(rs);
				rs.addChildren(resource);
				resourceService.update(rs);
			}
			resourceService.save(resource);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加菜单成功！");
			this.writer("添加菜单",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加菜单失败！");
		}
		return mav;
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView modify(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("permission/resource/index");
		mav.addObject("list",resourceService.getAll());
		mav.addObject("rs",this.resourceService.getById(id));
		mav.addObject("roList",roleService.getAll());
		return mav;
	}
	
	@RequestMapping("update")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response,@Valid Resource resource,BindingResult result,Long parentId,RedirectAttributes redAttr,Long... roleId)throws Exception{
		ModelMap params=new ModelMap();
 		try{
			if(result.hasErrors()){
				List<ObjectError> ls = result.getAllErrors();
				for(ObjectError oe : ls){
					redAttr.addFlashAttribute(Constants.MESSAGE_NAME,oe.getDefaultMessage());
					return new ModelAndView("redirect:/resource/"+resource.getId()+"/edit");					
				}
			}
			resource = resourceService.getById(resource.getId());
			List<Role> rList = new ArrayList<Role>();
			for(Long r : roleId){
				Role role = roleService.getById(r);
				rList.add(role);
			}
			resource.setRoles(rList);
			if (parentId == null || parentId.equals("")) {
				resource.setParent(null);
			}else if(resource.getParent()==null){
				resource.setParent(resourceService.getById(parentId));
			}else if(resource.getParent().getId() != parentId){
				List<Resource> list = resource.getParent().getChildren();
				for(int i=list.size()-1;i>=0;i--){
					if(list.get(i).getId() == resource.getId()){
						list.remove(i);
					}
				}
				resource.getParent().setChildren(list);
				Resource rs = new Resource();
				rs.addChildren(resource);
				rs = resourceService.getById(parentId);
				resource.setParent(rs);
				resourceService.update(rs);
			}
			resource.setAction(request.getParameter("action"));
			resource.setCode(request.getParameter("code"));
			resource.setIfleaf(Boolean.parseBoolean(request.getParameter("ifleaf")));
			resource.setImageUrl(request.getParameter("imageUrl"));
			resource.setName(request.getParameter("name"));
			resource.setStatus(request.getParameter("status"));
			resource.setSort(Integer.parseInt(request.getParameter("sort")));
			resource.setAalias(request.getParameter("aalias"));
			resource.setAclass(request.getParameter("aclass"));
			resource.setIclass(request.getParameter("iclass"));
			resource.setAhref(request.getParameter("ahref"));
			resource.setArole(request.getParameter("arole"));
			resource.setDomethod(request.getParameter("domethod"));
			resource.setData_toggle(request.getParameter("data_toggle"));
			resource.setData_formid(request.getParameter("data_formid"));
			resource.setData_action(request.getParameter("data_action"));
			/**
			 * 设置父子，启用和停用
			 */
			if(Constants.DISABLED.equals(resource.getStatus())&&null!=resource.getChildren()){
				this.setChildClosed(resource);
			}
			if(Constants.ENABLE.equals(resource.getStatus())&&null!=parentId){
				resource.setParent( resourceService.getById(parentId));
				this.setParentOpen(resource);
			}
			
			this.resourceService.update(resource);
			params.put("rid", resource.getId());
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "修改菜单成功！");
			this.writer("修改菜单",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "修改菜单失败！");
		}
		return new ModelAndView(LIST_ACTION,params);
	}
	
	@RequestMapping(value="/delete")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redAttr,Long... id)throws Exception{
		try{
			for(Long i : id){
				Resource rs = resourceService.getById(i);
				List<Resource> list = rs.getParent() == null ? new ArrayList<Resource>() : rs.getParent().getChildren();
				for(int j=0;j<list.size();j++){
					if(list.get(j).getId() == rs.getId())
						list.remove(j);
				}
				Resource parent = null;
				if(rs.getParent() != null){
					parent = resourceService.getById(rs.getParent().getId());
					parent.setChildren(list);
				}
				rs.setParent(null);
				resourceService.update(rs);
				if(parent != null)
					resourceService.update(parent);
				resourceService.delete(id);
			}
			
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除菜单成功！");
			this.writer("删除菜单",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除菜单失败！");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	/**
	 * 设置所有子菜单关闭
	 * @param rc
	 * @throws Exception 
	 */
	private void setChildClosed(Resource rc) throws Exception{
		if(rc.getChildren().size()!=0){
			for(int i=0;i<rc.getChildren().size();i++){
				Resource r=rc.getChildren().get(i);
				r.setStatus(rc.getStatus());
				resourceService.update(r);
			}
		}
	}
	/**
	 * 设置父菜单开启
	 * @param rc
	 * @throws Exception 
	 */
	private void setParentOpen(Resource rc) throws Exception{
		if(rc.getParent()!=null){
				Resource r=rc.getParent();
				r.setStatus(rc.getStatus());
				resourceService.update(r);
		}
	}
	
}

