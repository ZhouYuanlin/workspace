package cn.uuf.ltxxt.system.code.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeAssetSource;
import cn.uuf.ltxxt.system.code.service.CodeAssetSourceService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

@Service
public class CodeAssetSourceServiceImpl extends HibernateDaoSupport<CodeAssetSource, Long> implements CodeAssetSourceService{

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeAssetSource> getAll() {
		Criteria c = getSession().createCriteria(CodeAssetSource.class);
		c.addOrder(Order.asc("code"));
		c.setCacheable(true);
		return c.list();
	}

	@Override
	public Long getCount(CodeAssetSource m) {
		Criteria c = buildCondition(m);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<CodeAssetSource> queryList(CodeAssetSource m, int s, int size) {
		Criteria c = buildCondition(m);
		c.setFirstResult(s).setMaxResults(size);
		return this.queryByPage(c);
	}
	
	private Criteria buildCondition(CodeAssetSource m){
		Criteria c = getSession().createCriteria(CodeAssetSource.class);
		if(m != null){
			if(m.getCode() != null && m.getCode().length() > 0)
				c.add(Restrictions.eq("code",m.getCode()));
			if(m.getName() != null && m.getName().length() > 0)
				c.add(Restrictions.like("name",m.getName()));
		}
		c.addOrder(Order.asc("code"));
		c.setCacheable(true);
		return c;
	}
}
