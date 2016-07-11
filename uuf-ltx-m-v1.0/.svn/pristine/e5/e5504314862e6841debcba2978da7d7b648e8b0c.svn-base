package cn.uuf.stu.framework.service;

import cn.uuf.stu.entity.framework.ExceptionMonitor;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;




/**
* 监控异常 service
* @ClassName: IExceptionMonitorService 
* @author tangpeng
* @date 2015年9月8日 下午5:27:22 
*
*/
public interface IExceptionMonitorService extends IBaseService<ExceptionMonitor, Long> {
	
	/**
	* 带查询的分页结果集
	* @param monitor
	* @param startTime
	* @param endTime
	* @param pageable
	* @return    
	* Page<ExceptionMonitor>
	 */
	Page<ExceptionMonitor>getList(ExceptionMonitor monitor,String startTime,String endTime,Pageable pageable);

}
