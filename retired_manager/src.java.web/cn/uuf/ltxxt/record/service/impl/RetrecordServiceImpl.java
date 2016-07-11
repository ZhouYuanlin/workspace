package cn.uuf.ltxxt.record.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.record.Retrecord;
import cn.uuf.ltxxt.record.service.RetrecordService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 通信录
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-28
 */
@Service
public class RetrecordServiceImpl extends HibernateDaoSupport<Retrecord,Long> implements RetrecordService{

	@Override
	public Long getCount(Retrecord r) {
		Criteria criteria = buildCondition(r);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retrecord> queryList(Retrecord t, int s, int size) {
		Criteria c = buildCondition(t);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}

	private Criteria buildCondition(Retrecord d){
		Criteria c = getSession().createCriteria(Retrecord.class);
		if(d != null){
			if(d.getName() != null && d.getName().length() > 0)
				c.add(Restrictions.eq("name",d.getName()));
			if(d.getDeparts() != null && d.getDeparts().getId() != null){
				c.createAlias("departs","r");
				c.add(Restrictions.or(Restrictions.eq("departs",d.getDeparts()),Restrictions.eq("r.parent",d.getDeparts())));
			}
		}
		c.addOrder(Order.asc("id"));
		return c;
	}
}

