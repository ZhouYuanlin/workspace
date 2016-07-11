package cn.uuf.ltxxt.system.code.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeDyb;
import cn.uuf.ltxxt.system.code.service.CodeDybService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-20
 */
@Service
public class CodeDybServiceImpl extends HibernateDaoSupport<CodeDyb,Long> implements CodeDybService{

	@Override
	public List<CodeDyb> getAll() {
		Criteria c = getSession().createCriteria(CodeDyb.class);
		c.setCacheable(true);
		c.addOrder(Order.asc("code"));
		return c.list();
	}

	@Override
	public Long getCount(CodeDyb d) {
		Criteria criteria = buildCriteriaByEntity(d);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<CodeDyb> queryList(CodeDyb d, int s, int size) {
		Criteria c = this.buildCriteriaByEntity(d);
		c.setFirstResult(s).setMaxResults(size);
		return this.queryByPage(c);
	}
	
	private Criteria buildCriteriaByEntity(CodeDyb d){
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
	public List<CodeDyb> queryByVo(CodeDyb d) {
		Criteria c = buildCriteriaByEntity(d);
		return c.list();
	}

}

