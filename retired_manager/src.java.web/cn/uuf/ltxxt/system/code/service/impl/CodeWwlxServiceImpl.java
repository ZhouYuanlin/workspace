package cn.uuf.ltxxt.system.code.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeWwlx;
import cn.uuf.ltxxt.system.code.service.CodeWwlxService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-20
 */
@Service
public class CodeWwlxServiceImpl extends HibernateDaoSupport<CodeWwlx,Long> implements CodeWwlxService{

	@Override
	public List<CodeWwlx> getAll() {
		Criteria c = getSession().createCriteria(CodeWwlx.class);
		c.setCacheable(true);
		c.addOrder(Order.asc("code"));
		return c.list();
	}

	@Override
	public Long getCount(CodeWwlx d) {
		Criteria criteria = buildCriteriaByEntity(d);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<CodeWwlx> queryList(CodeWwlx d, int s, int size) {
		Criteria c = this.buildCriteriaByEntity(d);
		c.setFirstResult(s).setMaxResults(size);
		return this.queryByPage(c);
	}
	
	private Criteria buildCriteriaByEntity(CodeWwlx d){
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

}

