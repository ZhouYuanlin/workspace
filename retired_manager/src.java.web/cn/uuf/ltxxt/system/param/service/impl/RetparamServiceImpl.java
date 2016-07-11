package cn.uuf.ltxxt.system.param.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retparam;
import cn.uuf.ltxxt.system.param.service.RetparamService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 参数表
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-19
 */
@Service
public class RetparamServiceImpl extends HibernateDaoSupport<Retparam,Long> implements RetparamService{

	@Override
	public Retparam qeryByName(String name) {
		return (Retparam) this.findUniqueBy(Retparam.class,"name",name);
	}

	@Override
	public Long getCount(Retparam p) {
		Criteria c = buildContion(p);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<Retparam> queryList(Retparam p,int s,int size) {
		Criteria c = buildContion(p);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}

	private Criteria buildContion(Retparam p){
		Criteria c = getSession().createCriteria(Retparam.class);
		if(p != null){
			if(p.getName() != null && p.getName().length() > 0)
				c.add(Restrictions.eq("name",p.getName()));
			if(p.getPvalue() != null && p.getPvalue().length() > 0)
				c.add(Restrictions.eq("pvalue",p.getPvalue()));
		}
		c.addOrder(Order.desc("id"));
		c.setCacheable(true);
		return c;
	}
}

