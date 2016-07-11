package cn.uuf.ltxxt.system.code.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeSydb;
import cn.uuf.ltxxt.system.code.service.CodeSydService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Service
public class CodeSydServiceImpl extends HibernateDaoSupport<CodeSydb,Long> implements CodeSydService{

	@Override
	public List<CodeSydb> getAll() {
		Criteria c = getSession().createCriteria(CodeSydb.class);
		c.addOrder(Order.asc("code"));
		c.setCacheable(true);
		return c.list();
	}

	@Override
	public Long getCount(CodeSydb s) {
		Criteria c = buildCondition(s);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<CodeSydb> queryList(CodeSydb d, int s, int size) {
		Criteria c = buildCondition(d);
		c.setFirstResult(s).setMaxResults(size);
		return this.queryByPage(c);
	}
	
	private Criteria buildCondition(CodeSydb m){
		Criteria c = getSession().createCriteria(CodeSydb.class);
		if(m != null){
			if(m.getCode() != null && m.getCode().length() > 0)
				c.add(Restrictions.eq("code",m.getCode()));
			if(m.getName() != null && m.getName().length() > 0)
				c.add(Restrictions.like("name",m.getName()));
		}
		c.setCacheable(true);
		c.addOrder(Order.asc("code"));
		return c;
	}
	private Criteria buildCriteriaByEntity(CodeSydb d){
		Criteria c = getSession().createCriteria(this.getEntityClass());
		if(d != null){
			if(d.getName() != null && d.getName().length() > 0)
				c.add(Restrictions.like("name",d.getName()));
			if(d.getCode() != null && d.getCode().length() > 0)
				c.add(Restrictions.eq("code",d.getCode()));
		}
		c.setCacheable(true);
		c.addOrder(Order.asc("code"));
		return c;
	}
	
	@Override
	public List<CodeSydb> queryByVo(CodeSydb d) {
		Criteria c = buildCriteriaByEntity(d);
		return c.list();
	}

}

