package cn.uuf.ltxxt.activity.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.activity.ActivityApply;
import cn.uuf.ltxxt.activity.service.ActivityApplyService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 活动
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
@Service
public class ActivityApplyServiceImpl extends HibernateDaoSupport<ActivityApply, Long> implements ActivityApplyService{

	@Override
	public Long getCount(ActivityApply t) {
		Criteria c = buildCondition(t);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<ActivityApply> queryList(ActivityApply t, int s, int size) {
		Criteria c = buildCondition(t);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	@Override
	public List<ActivityApply> queryByAid(ActivityApply a) {
		Criteria c = buildCondition(a);
		return c.list();
	}
	private Criteria buildCondition(ActivityApply t){
		Criteria c = getSession().createCriteria(ActivityApply.class);
		if(t.getActivity()!=null){
			c.createAlias("activity","a");
			if(t.getActivity().getId()!=null){
				c.add(Restrictions.eq("a.id", t.getActivity().getId()));
			}
		}
		c.addOrder(Order.asc("enrollTime"));
		return c;
	}

}
