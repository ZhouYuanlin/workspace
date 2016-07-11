package cn.uuf.stu.framework.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import cn.uuf.stu.entity.framework.ExceptionMonitor;
import cn.uuf.stu.framework.common.Filter;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.dao.IExceptionMonitorDao;
import cn.uuf.stu.framework.service.IExceptionMonitorService;




/**
* 异常 service
* @ClassName: ExceptionMonitorServiceImpl 
* @author tangpeng
* @date 2015年9月8日 下午5:29:13 
*
*/
@Service(value="exceptionMonitorService")
public class ExceptionMonitorServiceImpl extends BaseServiceImpl<ExceptionMonitor, Long> implements IExceptionMonitorService {
	
	@Resource(name="exceptionMonitorDao")
	private IExceptionMonitorDao exceptionMonitorDao;
	
	@Resource(name="exceptionMonitorDao")
	public void setBaseDao(IExceptionMonitorDao exceptionMonitorDao) {
		super.setBaseDao(exceptionMonitorDao);
	}

	@Override
	public Page<ExceptionMonitor> getList(ExceptionMonitor monitor,
			String startTime, String endTime, Pageable pageable) {
		List<Filter> params = new ArrayList<Filter>();
		if(StringUtils.isNotEmpty(startTime)){
			params.add(Filter.ge("createDate", Timestamp.valueOf(startTime)));
		}
		if(StringUtils.isNotEmpty(endTime)){
			params.add(Filter.le("createDate", Timestamp.valueOf(endTime)));
		}
		pageable.setFilters(params);
		return exceptionMonitorDao.getPage(pageable);
	}
	
}
