package cn.uuf.stu.framework.service;

import java.util.List;

import cn.uuf.stu.entity.framework.WResource;




/**
* 资源  service
* @ClassName: IResourceService 
* @author tangpeng
* @date 2015年8月11日 下午6:16:33 
*
*/
public interface IResourceService extends IBaseService<WResource, Long> {
	
	/**
	* 获得顶级菜单
	* @return    
	* List<Resource>
	*/
	public List<WResource> getRootMenu();

}
