package cn.uuf.ltxxt.system.code.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeMode;
import cn.uuf.ltxxt.system.code.service.CodeModeService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 民族服务
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Service
public class CodeModeServiceImpl extends HibernateDaoSupport<CodeMode,Long> implements CodeModeService{

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeMode> getAll() {
		Criteria c = getSession().createCriteria(CodeMode.class);
		c.addOrder(Order.asc("code"));
		c.setCacheable(true);
		return c.list();
	}

	@Override
	public Long getCount(CodeMode m) {
		Criteria c = buildCondition(m);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<CodeMode> queryList(CodeMode m, int s, int size) {
		Criteria c = buildCondition(m);
		c.setFirstResult(s).setMaxResults(size);
		return this.queryByPage(c);
	}
	
	private Criteria buildCondition(CodeMode m){
		Criteria c = getSession().createCriteria(CodeMode.class);
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

