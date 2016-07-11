package cn.uuf.ltxxt.system.code.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeSaveZdytjb;
import cn.uuf.domain.CodeTjb;
import cn.uuf.domain.CodeZjb;
import cn.uuf.ltxxt.system.code.service.CodeSaveZdytjbService;
import cn.uuf.ltxxt.system.code.service.CodeZdytjbService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 快速查询保存自定义条件表服务
 * @author Suntingwen
 *
 */
@Service
public class CodeSaveZdytjbServiceImpl extends HibernateDaoSupport<CodeSaveZdytjb,Long> implements CodeSaveZdytjbService{

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeSaveZdytjb> getAll() {
		Criteria c = getSession().createCriteria(CodeSaveZdytjb.class);
		c.addOrder(Order.asc("id"));
		c.setCacheable(true);
		return c.list();
	}

	@Override
	public Long getCount(CodeSaveZdytjb saveZdytjb) {
		Criteria c = buildCondition(saveZdytjb);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<CodeSaveZdytjb> queryList(CodeSaveZdytjb saveZdytjb, int s, int size) {
		Criteria c = buildCondition(saveZdytjb);
		c.setFirstResult(s).setMaxResults(size);
		return this.queryByPage(c);
	}
	
	@Override
	public List<CodeSaveZdytjb> queryList(CodeSaveZdytjb saveZdytjb) {
		Criteria c = buildCondition(saveZdytjb);
		return c.list();
	}
	
	private Criteria buildCondition(CodeSaveZdytjb saveZdytjb){
		Criteria c = getSession().createCriteria(CodeSaveZdytjb.class);
		if(saveZdytjb != null){
			if(saveZdytjb.getFattiesName() != null && saveZdytjb.getFattiesName().length() > 0)
				c.add(Restrictions.eq("fattiesName",saveZdytjb.getFattiesName()));
			if(saveZdytjb.getFattiesValue() != null && saveZdytjb.getFattiesValue().length() > 0)
				c.add(Restrictions.like("fattiesValue",saveZdytjb.getFattiesValue()));
			if(saveZdytjb.getUsername() != null && saveZdytjb.getUsername().length() > 0)
				c.add(Restrictions.like("username",saveZdytjb.getUsername()));
		}
		c.addOrder(Order.asc("id"));
		c.setCacheable(true);
		return c;
	}

	//查询对应的表的字段名
	@Override
	public List<CodeSaveZdytjb> queryUniqueTable(CodeTjb tjb) {
		Criteria criteria = getSession().createCriteria(CodeSaveZdytjb.class);
		if(tjb!=null){
			criteria.add(Restrictions.eq("tjb", tjb));
		}
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}

	@Override
	public CodeSaveZdytjb getUniqueEntity(String propertyName, Object propertyValue) {
		Criteria criteria = getSession().createCriteria(CodeSaveZdytjb.class);
		criteria.setCacheable(true);
		criteria.add(Restrictions.eq(propertyName, propertyValue));
		criteria.addOrder(Order.asc("id"));
		List<CodeSaveZdytjb> list = criteria.list();
		return list.size()>0?(CodeSaveZdytjb)list.get(0):null;
	}

}

