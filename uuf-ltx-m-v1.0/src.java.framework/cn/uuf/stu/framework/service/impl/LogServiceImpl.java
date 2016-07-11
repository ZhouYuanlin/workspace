package cn.uuf.stu.framework.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import cn.uuf.stu.entity.framework.WLog;
import cn.uuf.stu.framework.common.Filter;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.dao.ILogDao;
import cn.uuf.stu.framework.service.ILogService;



/**
* 日志 service
* @ClassName: LogServiceImpl 
* @author tangpeng
* @date 2015年9月8日 下午2:30:30 
*
*/
@Service(value="logService")
public class LogServiceImpl extends BaseServiceImpl<WLog, Long> implements ILogService {
	
	@Resource(name="logDao")
	private ILogDao logDao;
	
	@Resource(name="logDao")
	public void setBaseDao(ILogDao logDao) {
		super.setBaseDao(logDao);
	}

	@Override
	public Page<WLog> getList(WLog log, String startTime, String endTime,
			Pageable pageable) {
		List<Filter> params = new ArrayList<Filter>();
		if(StringUtils.isNotEmpty(log.getOperation())){
			params.add(Filter.like("operation", "%"+log.getOperation()+"%"));
		}
		if(StringUtils.isNotEmpty(log.getOperator())){
			params.add(Filter.like("operator", "%"+log.getOperator()+"%"));
		}
		if(StringUtils.isNotEmpty(startTime)){
			params.add(Filter.ge("createDate", Timestamp.valueOf(startTime)));
		}
		if(StringUtils.isNotEmpty(endTime)){
			params.add(Filter.le("createDate", Timestamp.valueOf(endTime)));
		}
		pageable.setFilters(params);
		return logDao.getPage(pageable);
	}
	
	
	
}
