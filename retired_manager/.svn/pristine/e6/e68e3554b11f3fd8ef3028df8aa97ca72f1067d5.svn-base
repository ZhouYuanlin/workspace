package cn.uuf.ltxxt.system.permission.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Account;
import cn.uuf.domain.Resource;
import cn.uuf.domain.Role;
import cn.uuf.ltxxt.login.controller.BaseController;
import cn.uuf.ltxxt.system.permission.service.ResourceService;
import cn.uuf.ltxxt.system.permission.service.RoleService;
import cn.uuf.util.Paginate;

/**
 * 角色维护
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date May 13, 2013
 */
@Controller
@RequestMapping("/{role:role;?.*}")
public class RoleController extends BaseController{

	private final String LIST_ACTION = "redirect:/role";
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private ResourceService rService;
	
	@RequestMapping
	public ModelAndView index(Integer page,Role role,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("permission/role/index");
		try{
			page = page == null || page < 0 ? 1 : page;
			int start = (page - 1) * size;
			List<Role> list = roleService.queryList(role, start, size);
			mav.addObject("list",list);
			paginate = new Paginate(list, roleService.getCount(role), size, page);
			mav.addObject("paginate",paginate);
			mav.addObject("role",role);
		}catch(Exception e){
			mav.addObject(Constants.MESSAGE_NAME, "未找到数据");
		}
		return mav;
	}
	
	@RequestMapping("/create")
	public ModelAndView create(Model model)throws Exception{
		ModelAndView mav = new ModelAndView("permission/role/create");
		return mav;
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public ModelAndView save(HttpServletRequest request,Model model,@Valid @ModelAttribute("role") Role role,BindingResult result,RedirectAttributes redAttr)throws Exception{
		try{
			if(result.hasErrors()){
				List<ObjectError> ls = result.getAllErrors();
				String error = "";
				for(ObjectError oe : ls){
					error = oe.getDefaultMessage();
				}
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME, error);
				redAttr.addFlashAttribute("command", role);
				return new ModelAndView("redirect:/role/create");
			}
			role.setCreateDate(new Date());
			role.setLastDate(new Date());
			roleService.save(role);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加角色成功！");
			this.writer("添加角色",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "添加角色失败！");
		}
		
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping("/{id}/edit")
	public ModelAndView modify(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("permission/role/update");
		mav.addObject("role", roleService.getById(id));
		return mav;
	}
	
	@RequestMapping("update")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response,@Valid Role role,BindingResult result,RedirectAttributes redAttr)throws Exception{
		try{
			if(result.hasErrors()){
				List<ObjectError> ls = result.getAllErrors();
				String error = "";
				for(ObjectError oe : ls){
					error = oe.getDefaultMessage();
				}
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME, error);
				return new ModelAndView("redirect:/role/"+role.getId()+"/edit");
			}
			role.setLastDate(new Date());
			role.setCreateDate(new Date());
			roleService.update(role);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "修改角色成功！");
			this.writer("添修改角色",request.getRemoteAddr(),this.getCurrentUser().getUsername());
		}catch(Exception e){
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "修改角色失败！");
		}
		
		return new ModelAndView(LIST_ACTION);
	}
	
	@RequestMapping(value="delete")
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response,RedirectAttributes redAttr,Long... id)throws Exception{
		try{
			roleService.delete(id);
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除成功！");
		}catch(Exception e){
			e.printStackTrace();
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME, "删除失败！");
		}
		return new ModelAndView(LIST_ACTION);
	}
	
	
	@RequestMapping("/{id}/detail")
	public ModelAndView detail(@PathVariable Long id,HttpServletRequest request,HttpServletResponse response)throws Exception{
		ModelAndView mav = new ModelAndView("permission/role/detail");
		try{
			Role role = roleService.getById(id);
			mav.addObject("role",role);
		}catch(Exception e){
			mav.addObject(Constants.MESSAGE_NAME, "未找到记录！");
		}
		return mav;
	}
	/**
	 * 异步查询角色下的用户
	 * @param response
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("{ajaxdetail:ajaxdetail;*.?}")
	public ModelAndView ajaxDetail(HttpServletResponse response,Long id)throws Exception{
		ModelAndView mav = new ModelAndView("permission/role/_show");
		try{
			Role role = roleService.getById(id);
			mav.addObject("role",role);
		}catch(Exception e){
			mav.addObject(Constants.MESSAGE_NAME, "未找到记录！");
		}
		return mav;
	}
	
	
	@RequestMapping("ajaxGetAccount")
	@Transactional(rollbackFor = Exception.class)
	public ModelAndView ajaxGetAccount(HttpServletRequest request,HttpServletResponse response,Long rid)throws Exception{
		ModelAndView mav = new ModelAndView("permission/role/_account");
		try{
			Role r = roleService.getById(rid);
			List<Account> accl = r.getAccounts();
			mav.addObject("accl",accl);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/console")
	public ModelAndView console(Long pid){
		ModelAndView mav = new ModelAndView("permission/role/console");
		try{
			List<Role> list = roleService.getAll();
			if(pid == null)
				pid = list.get(0).getId();
			mav.addObject("rlist",list);
			mav.addObject("slist",rService.queryByParent());
			mav.addObject("pid",pid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/grant")
	public ModelAndView saveconsole(@ModelAttribute("vo") Vo vo,Long pid,RedirectAttributes redAttr){
		ModelAndView mav = new ModelAndView("redirect:/role/console");
		try{
			String sql = "";
			if(pid != null){
				sql = "delete from uf_resource_uf_role t where t.roles_id=" + pid;
				rService.excuteSql(sql);
				List<Resource> list = vo.getResList();
				for(Resource r : list){
					if(r.getId() != null){
						sql = "insert into uf_resource_uf_role(resources_id,roles_id) values(" + r.getId() + "," + pid + ")";
						rService.excuteSql(sql);
					}
				}
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"授权成功");
			}else{
				redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"未选角色，不能授权");
			}
			redAttr.addFlashAttribute("pid",pid);
		}catch(Exception e){
			redAttr.addFlashAttribute(Constants.MESSAGE_NAME,"授权失败");
			e.printStackTrace();
		}
		return mav;
	}
	
	
	@ModelAttribute("vo")
	public Vo initVo() {
		Vo vo = new Vo();
		return vo;
	}
	/**
	 * 自定义内部类
	 */
	public class Vo{
		private List<cn.uuf.domain.Resource> resList;

		/**
		 * @return the resList
		 */
		public List<cn.uuf.domain.Resource> getResList() {
			return resList;
		}

		/**
		 * @param resList the resList to set
		 */
		public void setResList(List<cn.uuf.domain.Resource> resList) {
			this.resList = resList;
		}
	}
}

