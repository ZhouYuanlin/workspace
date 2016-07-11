package cn.uuf.ltxxt.system.code.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeMzb;
import cn.uuf.ltxxt.system.code.service.CodeMzbService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 民族服务
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Service
public class CodeMzbServiceImpl extends HibernateDaoSupport<CodeMzb,Long> implements CodeMzbService{

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeMzb> getAll() {
		Criteria c = getSession().createCriteria(CodeMzb.class);
		c.addOrder(Order.asc("code"));
		c.setCacheable(true);
		return c.list();
	}

	@Override
	public Long getCount(CodeMzb m) {
		Criteria c = buildCondition(m);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<CodeMzb> queryList(CodeMzb m, int s, int size) {
		Criteria c = buildCondition(m);
		c.setFirstResult(s).setMaxResults(size);
		return this.queryByPage(c);
	}
	
	private Criteria buildCondition(CodeMzb m){
		Criteria c = getSession().createCriteria(CodeMzb.class);
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

	@Override
	public List<CodeMzb> queryByVo(CodeMzb m) {
		Criteria c = buildCondition(m);
		return c.list();
	}

}

