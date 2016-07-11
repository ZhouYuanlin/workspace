package cn.uuf.ltxxt.activity.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.activity.Activity;
import cn.uuf.ltxxt.activity.service.ActivityService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 活动
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
@Service
public class ActivityServiceImpl extends HibernateDaoSupport<Activity, Long> implements ActivityService{

	@Override
	public Long getCount(Activity t) {
		Criteria c = buildCondition(t);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<Activity> queryList(Activity t, int s, int size) {
		Criteria c = buildCondition(t);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Activity t){
		Criteria c = getSession().createCriteria(Activity.class);
		if(t!=null){
			if(t.getActivityName()!=null&&!"".equals(t.getActivityName())){
				c.add(Restrictions.like("activityName",t.getActivityName(),MatchMode.ANYWHERE));
			}
			if(t.getAddress()!=null&&!"".equals(t.getAddress())){
				c.add(Restrictions.like("address",t.getAddress(),MatchMode.ANYWHERE));
			}
		}
		c.addOrder(Order.desc("startTime"));
		return c;
	}

}

