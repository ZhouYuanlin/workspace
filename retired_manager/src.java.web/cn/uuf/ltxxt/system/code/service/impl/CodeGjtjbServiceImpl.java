package cn.uuf.ltxxt.system.code.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeTjb;
import cn.uuf.ltxxt.system.code.service.CodeGjtjbService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 高级查询表服务
 * @author Suntingwen
 *
 */
@Service
public class CodeGjtjbServiceImpl extends HibernateDaoSupport<CodeTjb,Long> implements CodeGjtjbService{

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeTjb> getAll() {
		Criteria c = getSession().createCriteria(CodeTjb.class);
		c.addOrder(Order.asc("code"));
		c.setCacheable(true);
		return c.list();
	}

	@Override
	public Long getCount(CodeTjb m) {
		Criteria c = buildCondition(m);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<CodeTjb> queryList(CodeTjb m, int s, int size) {
		Criteria c = buildCondition(m);
		c.setFirstResult(s).setMaxResults(size);
		return this.queryByPage(c);
	}
	
	private Criteria buildCondition(CodeTjb m){
		Criteria c = getSession().createCriteria(CodeTjb.class);
		if(m != null){
			if(m.getTjbywm() != null && m.getTjbzwm().length() > 0)
				c.add(Restrictions.eq("tjbywm",m.getTjbywm()));
			if(m.getTjbzwm() != null && m.getTjbzwm().length() > 0)
				c.add(Restrictions.like("tjbzwm",m.getTjbzwm()));
		}
		c.addOrder(Order.asc("code"));
		c.setCacheable(true);
		return c;
	}

	//返回属性和值对应的唯一对象
	@Override
	public CodeTjb getUniqueEntity(String propertyName, Object propertyValue) {
		Criteria criteria = getSession().createCriteria(CodeTjb.class);
		criteria.setCacheable(true);
		criteria.add(Restrictions.eq(propertyName, propertyValue));
		criteria.addOrder(Order.asc("code"));
		List<CodeTjb> list = criteria.list();
		return list.size()>0?(CodeTjb)list.get(0):null;
	}

}

