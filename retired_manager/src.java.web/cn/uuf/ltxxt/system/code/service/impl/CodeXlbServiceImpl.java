package cn.uuf.ltxxt.system.code.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeXlb;
import cn.uuf.ltxxt.system.code.service.CodeXlbService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 学历服务
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-1
 */
@Service
public class CodeXlbServiceImpl extends HibernateDaoSupport<CodeXlb,Long> implements CodeXlbService{

	@Override
	public List<CodeXlb> getAll() {
		Criteria c = getSession().createCriteria(CodeXlb.class);
		c.setCacheable(true);
		c.addOrder(Order.asc("code"));
		return c.list();
	}

	@Override
	public Long getCount(CodeXlb d) {
		Criteria criteria = buildCriteriaByEntity(d);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<CodeXlb> queryList(CodeXlb d, int s, int size) {
		Criteria c = this.buildCriteriaByEntity(d);
		c.setFirstResult(s).setMaxResults(size);
		return this.queryByPage(c);
	}
	
	private Criteria buildCriteriaByEntity(CodeXlb d){
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

