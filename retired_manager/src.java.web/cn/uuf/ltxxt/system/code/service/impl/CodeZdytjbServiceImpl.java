package cn.uuf.ltxxt.system.code.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.CodeTjb;
import cn.uuf.domain.CodeZdytjb;
import cn.uuf.domain.CodeZjb;
import cn.uuf.ltxxt.system.code.service.CodeZdytjbService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 自定义条件表服务
 * @author Suntingwen
 *
 */
@Service
public class CodeZdytjbServiceImpl extends HibernateDaoSupport<CodeZdytjb,Long> implements CodeZdytjbService{

	@SuppressWarnings("unchecked")
	@Override
	public List<CodeZdytjb> getAll() {
		Criteria c = getSession().createCriteria(CodeZdytjb.class);
		c.addOrder(Order.asc("code"));
		c.setCacheable(true);
		return c.list();
	}

	@Override
	public Long getCount(CodeZdytjb m) {
		Criteria c = buildCondition(m);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<CodeZdytjb> queryList(CodeZdytjb m, int s, int size) {
		Criteria c = buildCondition(m);
		c.setFirstResult(s).setMaxResults(size);
		return this.queryByPage(c);
	}
	
	private Criteria buildCondition(CodeZdytjb m){
		Criteria c = getSession().createCriteria(CodeZdytjb.class);
		if(m != null){
			if(m.getZdywm() != null && m.getZdywm().length() > 0)
				c.add(Restrictions.eq("zdywm",m.getZdywm()));
			if(m.getZdzwm() != null && m.getZdzwm().length() > 0)
				c.add(Restrictions.like("zdzwm",m.getZdzwm()));
		}
		c.addOrder(Order.asc("code"));
		c.setCacheable(true);
		return c;
	}

	//查询对应的表的字段名
	@Override
	public List<CodeZdytjb> queryUniqueTable(CodeTjb tjb) {
		Criteria criteria = getSession().createCriteria(CodeZdytjb.class);
		if(tjb!=null){
			criteria.add(Restrictions.eq("tjb", tjb));
		}
		criteria.addOrder(Order.asc("code"));
		return criteria.list();
	}

	@Override
	public CodeZdytjb getUniqueEntity(String propertyName, Object propertyValue) {
		Criteria criteria = getSession().createCriteria(CodeZdytjb.class);
		criteria.setCacheable(true);
		criteria.add(Restrictions.eq(propertyName, propertyValue));
		criteria.addOrder(Order.asc("code"));
		List<CodeZdytjb> list = criteria.list();
		return list.size()>0?(CodeZdytjb)list.get(0):null;
	}

}

