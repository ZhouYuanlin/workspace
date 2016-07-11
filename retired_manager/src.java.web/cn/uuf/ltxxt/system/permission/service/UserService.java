package cn.uuf.ltxxt.system.permission.service;

import java.util.List;

import cn.uuf.domain.User;

/**
 * 用户服务
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
public interface UserService {

	public void save(User u);
	
	public void update(User u);
	
	public void delete(String... s);
	
	public User getById(String s);
	
	public Long getCount(User u);
	
	public List<User> queryList(User u,int start,int size);
}

