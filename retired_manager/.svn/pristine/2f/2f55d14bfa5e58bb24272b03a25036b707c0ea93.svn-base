package cn.uuf.ltxxt.daily.service;

import java.util.Date;
import java.util.List;

import cn.uuf.domain.daily.Workdaily;

/**
 * 工作日志
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-17
 */
public interface WorkdailyService {

	public void save(Workdaily w);
	public void update(Workdaily w);
	public void saveOrUpdate(Workdaily w);
	public List queryByHql(String hql)throws Exception;
	public void delete(Long... id);
	public Workdaily getById(Long id);
	public List<Workdaily> queryByVo(Workdaily w,String st,String en);
	public List<Workdaily> queryCalendarEvents(Workdaily daily,Date startDate,Date endDate);
	public Long queryEventCount(Workdaily re,Date startDate,Date endDate);
	public Long getCount(Workdaily w, String st, String ed, String xrsjst,
			String xrsjend);
	public List<Workdaily> queryList(Workdaily w, int s, Integer size,
			String st, String ed, String xrsjst, String xrsjend);
}

