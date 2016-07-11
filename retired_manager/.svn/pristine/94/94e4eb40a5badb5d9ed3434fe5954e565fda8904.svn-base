package cn.uuf.ltxxt.system.permission.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Log;
import cn.uuf.ltxxt.system.permission.service.LogService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
@Service("logService")
public class LogServiceImpl extends HibernateDaoSupport<Log,Long> implements LogService{

	@Override
	public Long getCount(Log log) {
		Criteria criteria = buildCriteriaByEntity(log);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Log> queryList(Log log, int start, int size) {
		Criteria c = buildCriteriaByEntity(log);
		c.setFirstResult(start).setMaxResults(size);
		return this.queryByPage(c);
	}

	private Criteria buildCriteriaByEntity(Log log){
		Criteria criteria = getSession().createCriteria(log.getClass());
		if(log!=null){
			if(log.getLoginName()!=null&&log.getLoginName().trim().length()>0)
				criteria.add(Restrictions.like("loginName", log.getLoginName(), MatchMode.ANYWHERE));
			if(log.getAction()!=null&&log.getAction().trim().length()>0)
				criteria.add(Restrictions.like("action", log.getAction(), MatchMode.ANYWHERE));
		}
		criteria.addOrder(Order.desc("loginDate"));
		return criteria;
	}

}

