package cn.uuf.ltxxt.cue.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.cue.Retmarke;
import cn.uuf.ltxxt.cue.service.RetmarkeService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 提示语
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-24
 */
@Service
public class RetmarkeServiceImpl extends HibernateDaoSupport<Retmarke,Long> implements RetmarkeService{

	@Override
	public Long getCount(Retmarke m) {
		Criteria c = buildCondition(m);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<Retmarke> queryList(Retmarke m, int s, int size) {
		Criteria c = buildCondition(m);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}

	private Criteria buildCondition(Retmarke m){
		Criteria c = getSession().createCriteria(Retmarke.class);
		if(m != null){
			if(m.getKssj() != null && m.getKssj().length() > 0)
				c.add(Restrictions.ge("kssj",m.getKssj()));
			if(m.getJssj() != null && m.getJssj().length() > 0)
				c.add(Restrictions.le("jssj",m.getJssj()));
			if(m.getContent() != null && m.getContent().length() > 0)
				c.add(Restrictions.like("content",m.getContent(),MatchMode.ANYWHERE));
		}
		c.addOrder(Order.asc("kssj"));
		return c;
	}

	@Override
	public List<Retmarke> queryByVo(Retmarke m) {
		Criteria c = buildCondition(m);
		return c.list();
	}

	@Override
	public List<Retmarke> getAll() {
		Criteria c = getSession().createCriteria(Retmarke.class);
		return c.list();
	}
}

