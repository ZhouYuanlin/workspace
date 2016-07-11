package cn.uuf.stu.framework.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.uuf.stu.framework.dao.IResourceDao;
import cn.uuf.stu.framework.service.IResourceService;



/**
* 资源  service
* @ClassName: ResourceServiceImpl 
* @author tangpeng
* @date 2015年8月11日 下午6:17:41 
*
*/
@Service(value="resourceService")
public class ResourceServiceImpl extends BaseServiceImpl<cn.uuf.stu.entity.framework.WResource, Long> implements IResourceService {
	
	@Resource(name="resourceDao")
	private IResourceDao resourceDao;
	

	@Resource(name="resourceDao")
	public void setBaseDao(IResourceDao resourceDao) {
		super.setBaseDao(resourceDao);
	}

	@Override
	public List<cn.uuf.stu.entity.framework.WResource> getRootMenu() {
		return resourceDao.getRootMenu();
	}
	
	
	
}
