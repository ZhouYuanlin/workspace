package cn.uuf.ltxxt.system.code.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeKtzw;
import cn.uuf.ltxxt.system.code.service.CodeKtzwService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 类型
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Service
public class CodeKtzwServiceImpl extends HibernateDaoSupport<CodeKtzw,Long> implements CodeKtzwService{

	@Override
	public List<CodeKtzw> getAll() {
		Criteria c = getSession().createCriteria(CodeKtzw.class);
		c.setCacheable(true);
		c.addOrder(Order.asc("code"));
		return c.list();
	}

	@Override
	public Long getCount(CodeKtzw l) {
		Criteria c = buildCondition(l);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<CodeKtzw> queryList(CodeKtzw l, int s, int size) {
		Criteria c = buildCondition(l);
		c.setFirstResult(s).setMaxResults(size);
		return this.queryByPage(c);
	}
	
	private Criteria buildCondition(CodeKtzw m){
		Criteria c = getSession().createCriteria(CodeKtzw.class);
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

}

