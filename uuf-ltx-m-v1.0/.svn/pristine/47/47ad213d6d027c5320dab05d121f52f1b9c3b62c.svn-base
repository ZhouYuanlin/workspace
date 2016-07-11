package cn.uuf.stu.framework.service;

import java.util.List;

import cn.uuf.stu.entity.framework.WAccount;
import cn.uuf.stu.entity.framework.WRole;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;



/**
* 账号 service
* @ClassName: IAccountService 
* @author tangpeng
* @date 2015年8月4日 下午3:03:12 
*
*/
public interface IAccountService extends IBaseService<WAccount, Long> {
	
	/**
	* 获取当前登录用户名
	* @return    
	* String
	*/
	String getCurrentUsername();
	

	/**
	 * 获得分页list
	 * @param account
	 * @param pageable
	 * @return
	 */
	Page<WAccount> getList(WAccount account, Pageable pageable, WRole role);

	
}
