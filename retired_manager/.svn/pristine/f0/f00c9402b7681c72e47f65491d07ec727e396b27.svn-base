package cn.uuf.ltxxt.system.permission.service;

import java.util.List;

import cn.uuf.domain.Account;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
public interface AccountService {

	public List<Account> getAll()throws Exception;
	
	public Account getById(Long id) throws Exception;
	
	public Account getByUserName(String username)throws Exception;

	/**
	 * 更具真姓名查询
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public Account getByRealName(String username)throws Exception;

	public Account queryByLoginName(String username)throws Exception;
	
	public List<Account> queryByLoginName1(String username)throws Exception;
	
	public void save(Account account)throws Exception;
	
	public void update(Account account)throws Exception;
	
	public void delete(Long... ids)throws Exception;
	
	public void delete(String sql)throws Exception;
	
	public void delete(Account account)throws Exception;
	
	public List<Account> queryList(Account acc,int start,int size);
	
	public Long getCount(Account acc);
}

