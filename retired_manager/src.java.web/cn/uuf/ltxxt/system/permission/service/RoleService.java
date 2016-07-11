package cn.uuf.ltxxt.system.permission.service;

import java.util.List;

import cn.uuf.domain.Role;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
public interface RoleService {

	public List<Role> getAll()throws Exception;
	
	public Role getById(Long id)throws Exception;
	
	public void save(Role role)throws Exception;
	
	public void update(Role role)throws Exception;
	
	public Role queryByName(String name)throws Exception;
	
	public void delete(Long... ids)throws Exception;
	
	public List<Role> queryList(Role role,int start,int size);
	
	public Long getCount(Role role);
	
	public Role queryByScope(String scope);

	public List queryBySql(String sql)throws Exception;
}

