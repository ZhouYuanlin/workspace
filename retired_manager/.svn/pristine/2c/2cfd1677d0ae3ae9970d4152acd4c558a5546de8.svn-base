package cn.uuf.ltxxt.party.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirement;
import cn.uuf.domain.ret.Retireparty;
import cn.uuf.ltxxt.party.service.RetirepartyService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 党员信息
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-11
 */
@Service
public class RetirepartyServiceImpl extends HibernateDaoSupport<Retireparty,Long> implements RetirepartyService{

	@Override
	public Long getCount(Retireparty p) {
		Criteria c = buildCondition(p);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<Retireparty> queryList(Retireparty p, int s, int size) {
		Criteria c = buildCondition(p);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Retireparty p){
		Criteria c = getSession().createCriteria(Retireparty.class);
		if(p != null){
			if(p.getDzbmc() != null && p.getDzbmc().length() > 0)
				c.add(Restrictions.like("dzbmc",p.getDzbmc(),MatchMode.ANYWHERE));
			if(p.getDzbsj() != null && p.getDzbsj().length() > 0)
				c.add(Restrictions.eq("dzbsj",p.getDzbsj()));
			if(p.getSfsc() != null && p.getSfsc().length() > 0)
				c.add(Restrictions.eq("sfsc",p.getSfsc()));
		}
		c.addOrder(Order.asc("id"));
		return c;
	}

	@Override
	public List<Retireparty> getAll() {
		Retireparty p = new Retireparty();
		p.setSfsc(Constants.HASNO);
		Criteria c = buildCondition(p);
		List<Retireparty> list = c.list();
		for(Retireparty t : list){
			Hibernate.initialize(t.getMents());
			for(Retirement r : t.getMents()){
				Hibernate.initialize(r);
			}
		}
		return list;
	}

	@Override
	public Retireparty queryByName(String mc) {
		Retireparty r = new Retireparty();
		r.setDzbmc(mc);
		r.setSfsc(Constants.HASNO);
		List<Retireparty> list = this.queryByVo(r);
		if(list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public List<Retireparty> queryByVo(Retireparty p) {
		Criteria c = buildCondition(p);
		return c.list();
	}

}

