package cn.uuf.ltxxt.system.permission.service;

import java.util.List;

import cn.uuf.domain.Resource;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
public interface ResourceService {

	public List<Resource> getAll()throws Exception;
	
	public Resource getById(Long id)throws Exception;
	
	public void save(Resource resource)throws Exception;
	
	public void update(Resource resource)throws Exception;
	
	public void delete(Long... ids)throws Exception;
	
	public List<Resource> queryList(Resource resource,int start,int size);
	
	public Long getCount(Resource res);
	
	public Resource querybyVo(Resource vo);
	
	public List<Resource> queryByParent();
	
	public void excuteSql(String sql)throws Exception;
}

