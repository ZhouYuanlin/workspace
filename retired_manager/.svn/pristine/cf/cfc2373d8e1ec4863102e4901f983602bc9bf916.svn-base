package cn.uuf.ltxxt.party.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.ret.Retorganize;
import cn.uuf.ltxxt.party.service.RetorganizeService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;
/**
 * 组织关系调整(党支部)
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-28
 */
@Service
public class RetorganizeServiceImpl extends HibernateDaoSupport<Retorganize,Long> implements RetorganizeService{

	@Override
	public Long getCount(Retorganize g,String kssj,String jssj) {
		Criteria criteria = buildCondition(g,kssj,jssj);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retorganize> queryList(Retorganize g, int s, int size,String kssj,String jssj) {
		Criteria c = buildCondition(g,kssj,jssj);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Retorganize g,String kssj,String jssj){
		Criteria c = getSession().createCriteria(Retorganize.class);
		if(g != null){
			if(g.getRet() != null)
				c.add(Restrictions.eq("ret",g.getRet()));
			if((kssj != null && kssj.length() > 0) && (jssj == null || jssj.equals("")))
				c.add(Restrictions.ge("tzsj",kssj));
			if((kssj == null || kssj.equals("")) && (jssj != null && jssj.length() > 0))
				c.add(Restrictions.le("tzsj",jssj));
			if((kssj != null && kssj.length() > 0) && (jssj != null && jssj.length() > 0))
				c.add(Restrictions.between("tzsj",kssj,jssj));
		}
		c.addOrder(Order.desc("tzsj"));
		return c;
	}

	@Override
	public List<Retorganize> getAll() {
		Criteria c = this.getSession().createCriteria(this.getEntityClass());
		return c.list();
	}

}

