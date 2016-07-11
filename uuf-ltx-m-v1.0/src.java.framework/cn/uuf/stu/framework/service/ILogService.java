package cn.uuf.stu.framework.service;

import cn.uuf.stu.entity.framework.WLog;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;




/**
* 日志 service
* @ClassName: ILogService 
* @author tangpeng
* @date 2015年9月8日 上午11:32:25 
*
*/
public interface ILogService extends IBaseService<WLog, Long> {
	
	/**
	* 带查询分页的结果集
	* @param log
	* @param startTime
	* @param endTime
	* @param pageable
	* @return    
	* Page<Log>
	 */
	Page<WLog> getList(WLog log,String startTime,String endTime,Pageable pageable);
	
}
