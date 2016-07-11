package cn.uuf.ltxxt.system.code.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeAsset;
import cn.uuf.domain.CodeZjb;
import cn.uuf.ltxxt.system.code.service.CodeAssetService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

@Service
public class CodeAssetServiceImpl extends HibernateDaoSupport<CodeAsset, Long> implements CodeAssetService {

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeAsset> getAll() {
		Criteria c = getSession().createCriteria(CodeAsset.class);
		c.addOrder(Order.asc("code"));
		c.setCacheable(true);
		return c.list();
	}

	@Override
	public Long getCount(CodeAsset m) {
		Criteria c = buildCondition(m);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<CodeAsset> queryList(CodeAsset m, int s, int size) {
		Criteria c = buildCondition(m);
		c.setFirstResult(s).setMaxResults(size);
		return this.queryByPage(c);
	}
	
	private Criteria buildCondition(CodeAsset m){
		Criteria c = getSession().createCriteria(CodeAsset.class);
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
