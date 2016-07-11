package cn.uuf.ltxxt.system.code.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeAssetType;
import cn.uuf.ltxxt.system.code.service.CodeAssetTypeService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 资产类型的类别
 * @author ll
 *
 */
@Service
public class CodeAssetTypeServiceImpl extends HibernateDaoSupport<CodeAssetType, Long> implements CodeAssetTypeService{
	@SuppressWarnings("unchecked")
	@Override
	public List<CodeAssetType> getAll() {
		Criteria c = getSession().createCriteria(CodeAssetType.class);
		c.addOrder(Order.asc("code"));
		c.setCacheable(true);
		return c.list();
	}

	@Override
	public Long getCount(CodeAssetType m) {
		Criteria c = buildCondition(m);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<CodeAssetType> queryList(CodeAssetType m, int s, int size) {
		Criteria c = buildCondition(m);
		c.setFirstResult(s).setMaxResults(size);
		return this.queryByPage(c);
	}
	
	private Criteria buildCondition(CodeAssetType m){
		Criteria c = getSession().createCriteria(CodeAssetType.class);
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
