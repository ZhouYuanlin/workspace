package cn.uuf.stu.framework.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.util.Assert;

import cn.uuf.stu.entity.framework.WAccount;
import cn.uuf.stu.entity.framework.WResource;
import cn.uuf.stu.entity.framework.WRole;
import cn.uuf.stu.framework.service.IAccountService;
import cn.uuf.stu.framework.shiro.Principal;
import cn.uuf.stu.framework.util.SpringUtils;

/**
* 资源菜单处理
* @ClassName: ResourcesHandler 
* @author tangpeng
* @date 2015年8月11日 下午1:46:47 
*
*/
public final class ResourcesHandler {
	
	public final static String  NOT_LOGIN_USER = "用户还没有登录!";
	
	public final static String NOT_ROLE_USER ="还没有给用户授予角色！";
	
	public final static String NOT_RESOURCE_USER ="用户没有任何可以查看的菜单!";
	
	/**
	 * 获取后台管理菜单
	 */
	public static List<WResource> getAdminResources(){
		Subject subject = SecurityUtils.getSubject();
		IAccountService accountService = SpringUtils.getBean("accountService", IAccountService.class);
		Principal principal = (Principal) subject.getPrincipal();
		Assert.notNull(principal, NOT_LOGIN_USER);
		WAccount account = accountService.load(principal.getId());
		List<WRole> roles = account.getRoles();
		Assert.notEmpty(roles, NOT_ROLE_USER);
		Set<WResource> resources = new HashSet<WResource>();
		for (WRole role : roles) {
			resources.addAll(role.getResoures());
		}
		Assert.notEmpty(resources, NOT_RESOURCE_USER);
		Set<WResource> targetSet = new HashSet<WResource>();
		for(WResource resource : resources){
			if(resource.getParent() == null && resource.getIsEnabled() == true){
				targetSet.add(resource);
			}
		}
		return compareCollection(targetSet);
	}

	/**
	* 资源集合排序
	* @param resources
	* @return    
	* List<Resource>
	 */
	private static List<WResource> compareCollection(Set<WResource> resources) {
		Assert.notEmpty(resources, NOT_RESOURCE_USER);
		List<WResource> resourceList = new ArrayList<WResource>(resources);
		Collections.sort(resourceList,new Comparator<WResource>() {
			@Override
			public int compare(WResource src, WResource target) {
				return src.getSort().compareTo(target.getSort());
			}
		});
		return resourceList;
	}

}
