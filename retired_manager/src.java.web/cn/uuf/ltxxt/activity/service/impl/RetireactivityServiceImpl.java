package cn.uuf.ltxxt.activity.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.activity.Retireactivity;
import cn.uuf.domain.honor.Retirehonor;
import cn.uuf.ltxxt.activity.service.RetireactivityService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 活动
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
@Service
public class RetireactivityServiceImpl extends HibernateDaoSupport<Retireactivity, Long> implements RetireactivityService{

	@Override
	public Long getCount(Retireactivity t) {
		Criteria c = buildCondition(t);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<Retireactivity> queryList(Retireactivity t, int s, int size) {
		Criteria c = buildCondition(t);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	@Override
	public List<Retireactivity> queryByVo(Retireactivity act) {
		Criteria c = buildCondition(act);
		return c.list();
	}
	private Criteria buildCondition(Retireactivity t){
		Criteria c = getSession().createCriteria(Retireactivity.class);
		if(t != null){
			if(t.getTitle() != null && t.getTitle().length() > 0)
				c.add(Restrictions.like("title",t.getTitle(),MatchMode.ANYWHERE));
			if(t.getXzlx() != null && t.getXzlx().length() > 0)
				c.add(Restrictions.eq("xzlx",t.getXzlx()));
			if(t.getCyzh() != null &&t.getCyzh().length() > 0)
				c.add(Restrictions.like("cyzh",t.getCyzh(),MatchMode.ANYWHERE));
		}
		c.addOrder(Order.desc("createDate"));
		return c;
	}

}

