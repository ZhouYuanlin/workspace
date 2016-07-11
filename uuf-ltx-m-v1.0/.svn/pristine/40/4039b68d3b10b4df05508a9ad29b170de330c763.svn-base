package cn.uuf.stu.framework.common;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.uuf.stu.entity.framework.WResource.Type;
import cn.uuf.stu.framework.service.IResourceService;




/**
* 角色菜单拦截器
* @ClassName: ResourceButtonIntercepter 
* @author tangpeng
* @date 2015年8月11日 下午6:06:41 
*
*/
public class ResourceButtonIntercepter extends HandlerInterceptorAdapter {
	
	@Resource(name="resourceService")
	private IResourceService resourceService;
	
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,ModelAndView modelAndView) throws Exception {
		cn.uuf.stu.entity.framework.WResource resource = resourceService.getUniqueEntity("accessUrl",request.getRequestURI().trim());
		if(resource!=null){
			Type type = resource.getType();
			switch (type){
				case onemenu: {
						request.setAttribute("selectOnemenu", resource);
						request.setAttribute("silderMenu",resource.getChildrens());
						List<cn.uuf.stu.entity.framework.WResource> targetList = resource.getChildrens().get(0).getChildrens();
						if(!CollectionUtils.isEmpty(targetList)){
							request.setAttribute("buttonList", targetList);
						}
						request.setAttribute("breadMenu", resource.getChildrens().get(0));
				}; break;
				case twomenu:{
						request.setAttribute("selectOnemenu", resource.getParent());
						request.setAttribute("selectTwomenu", resource);
						request.setAttribute("silderMenu",resource.getParent().getChildrens());
						List<cn.uuf.stu.entity.framework.WResource> targetList = resource.getChildrens();
						if(!CollectionUtils.isEmpty(targetList)){
							request.setAttribute("buttonList", targetList);
						}
						request.setAttribute("breadMenu", resource);
				};break;
				case button:{
						request.setAttribute("selectOnemenu", resource.getParent().getParent());
						request.setAttribute("selectTwomenu", resource.getParent());
						request.setAttribute("silderMenu",resource.getParent().getParent().getChildrens());
						request.setAttribute("breadMenu", resource);
					
				};break;
			}
		}
		
		
	}



	

	
	
	
}
