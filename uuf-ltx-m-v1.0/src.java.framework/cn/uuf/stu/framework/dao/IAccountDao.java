package cn.uuf.stu.framework.dao;

import org.hibernate.Session;

import cn.uuf.stu.entity.framework.WAccount;





/**
* Dao  账号
* @ClassName: IAccountDao 
* @author tangpeng
* @date 2015年8月4日 下午2:36:59 
*
*/
public interface IAccountDao extends IBaseDao<WAccount, Long> {

	Session getSession();
	/**
	* 用户名是否存在
	* @param username
	* @return    
	* boolean
	 */
	public boolean usernameExists(String username);
}
