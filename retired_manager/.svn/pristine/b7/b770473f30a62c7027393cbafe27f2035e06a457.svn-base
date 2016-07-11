package cn.uuf.ltxxt.record.service.impl;

import java.util.List;
import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.record.Retdepart;
import cn.uuf.ltxxt.record.service.RetdepartService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 通信录部门
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-28
 */
@Service
public class RetdepartServiceImpl extends HibernateDaoSupport<Retdepart,Long> implements RetdepartService{

	@Override
	public Long getCount(Retdepart d) {
		Criteria criteria = buildCondition(d);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retdepart> queryList(Retdepart d, int s, int size) {
		Criteria c = buildCondition(d);
		c.setFirstResult(s).setMaxResults(size);
		c.addOrder(Order.asc("id"));
		return c.list();
	}
	
	private Criteria buildCondition(Retdepart d){
		Criteria c = getSession().createCriteria(Retdepart.class);
		if(d != null){
			if(d.getName() != null && d.getName().length() > 0)
				c.add(Restrictions.like("name",d.getName(),MatchMode.ANYWHERE));
			if(d.getParent() != null && d.getParent().getId() != null)
				c.add(Restrictions.eq("parent",d.getParent()));
		}
		c.addOrder(Order.asc("id"));
		return c;
	}

	@Override
	public List<Retdepart> getAll() {
		Criteria c = getSession().createCriteria(Retdepart.class);
		c.addOrder(Order.asc("id"));
		return c.list();
	}

}

