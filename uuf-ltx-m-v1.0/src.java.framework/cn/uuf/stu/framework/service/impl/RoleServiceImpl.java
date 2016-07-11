package cn.uuf.stu.framework.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.type.StringType;
import org.springframework.stereotype.Service;

import cn.uuf.stu.entity.framework.WRole;
import cn.uuf.stu.framework.common.HiParameter;
import cn.uuf.stu.framework.dao.IRoleDao;
import cn.uuf.stu.framework.service.IRoleService;

/**
* 角色  service
* @ClassName: RoleServiceImpl 
* @author tangpeng
* @date 2015年8月6日 下午3:43:00 
*
*/
@Service(value="roleService")
public class RoleServiceImpl extends BaseServiceImpl<WRole,Long> implements IRoleService {
	
	@Resource(name="roleDao")
	private IRoleDao roleDao;
	
	@Resource(name="roleDao")
	public void setBaseDao(IRoleDao roleDao) {
		super.setBaseDao(roleDao);
	}

	@Override
	public List<WRole> getLmglRole(String lMGL) {
		StringBuffer sb = new StringBuffer();
		sb.append("select r from WRole as r inner join r.resoures as s with s.resourceName like :resourceName");
		List<HiParameter> parameters = new ArrayList<HiParameter>();
		parameters.add(new HiParameter("resourceName", lMGL, StringType.INSTANCE));
		return roleDao.getHqlList(sb.toString(), parameters);
	}
	
	
}
