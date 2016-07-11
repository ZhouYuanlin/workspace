package cn.uuf.stu.framework.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import cn.uuf.stu.entity.framework.WAccount;
import cn.uuf.stu.framework.dao.IAccountDao;




/**
* 账号  
* @ClassName: AccountDaoImpl 
* @author tangpeng
* @date 2015年8月4日 下午2:59:47 
*/
@Repository(value="accountDao")
public class AccountDaoImpl extends BaseDaoImpl<WAccount, Long> implements IAccountDao {
		
	@Override
	public boolean usernameExists(String username) {
		return false;
	}

	public Session getSession()
	{
		return super.getSession();
	}
}
