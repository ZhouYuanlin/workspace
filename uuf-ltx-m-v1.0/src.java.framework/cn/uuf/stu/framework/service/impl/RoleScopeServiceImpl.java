package cn.uuf.stu.framework.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.uuf.stu.entity.framework.RoleScope;
import cn.uuf.stu.framework.dao.IRoleScopeDao;
import cn.uuf.stu.framework.service.IRoleScopeService;

/**
 * 
* <p>标题：RoleScopeServiceImpl</p>
* <p>简介：</p>
* @author tangp
* @date 2015年12月31日 下午12:26:30
 */
@Service(value="roleScopeService")
public class RoleScopeServiceImpl extends BaseServiceImpl<RoleScope, Long> implements IRoleScopeService {
	
	@Resource(name="roleScopeDao")
	public void setBaseDao(IRoleScopeDao baseDao) {
		super.setBaseDao(baseDao);
	}
	
}
