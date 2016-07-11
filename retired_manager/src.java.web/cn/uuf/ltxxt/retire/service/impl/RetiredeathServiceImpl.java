package cn.uuf.ltxxt.retire.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retiredeath;
import cn.uuf.ltxxt.retire.service.RetiredeathService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 离世管理
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-31
 */
@Service
public class RetiredeathServiceImpl extends HibernateDaoSupport<Retiredeath,String> implements RetiredeathService{

	@Override
	public Long getCount(Retiredeath r,String ksj,String jsj) {
		Criteria criteria = buildCondition(r,ksj,jsj);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("sfzh"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retiredeath> queryList(Retiredeath r, int s, int size,String ksj,String jsj) {
		Criteria c = buildCondition(r,ksj,jsj);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	@Override
	public List queryByHql(String hql) throws Exception {
		List list = this.getSession().createQuery(hql).list();
		return list;
	}
	
	private Criteria buildCondition(Retiredeath r,String ksj,String jsj){
		Criteria c = getSession().createCriteria(Retiredeath.class);
		if(r != null){
			if(ksj != null && ksj.length() > 0 && jsj == null )
				c.add(Restrictions.ge("lssj",ksj));
			if(ksj== null && jsj != null && jsj.length() > 0)
				c.add(Restrictions.ge("lssj",jsj));
			if(ksj != null && ksj.length() > 0 && jsj != null && jsj.length() > 0)
				c.add(Restrictions.between("lssj",ksj,jsj));
			if(r.getSfzh() != null && r.getSfzh().length() > 0)
				c.add(Restrictions.eq("sfzh",r.getSfzh()));
			if(r.getXm() != null && r.getXm().length() > 0)
				c.add(Restrictions.like("xm",r.getXm(),MatchMode.ANYWHERE));
			if(r.getXb() != null && r.getXb().length() > 0)
				c.add(Restrictions.eq("xb",r.getXb()));
			if(r.getDwb() != null && r.getDwb().getId() != null)
				c.add(Restrictions.eq("dwb",r.getDwb()));
			if(r.getLxb() != null && r.getLxb().getId() != null)
				c.add(Restrictions.eq("lxb",r.getLxb()));
			if(r.getMzb() != null && r.getMzb().getId() != null)
				c.add(Restrictions.eq("mzb",r.getMzb()));
			if(r.getCsrq() != null && r.getCsrq().length() > 0)
				c.add(Restrictions.eq("csrq",r.getCsrq()));
		}
		c.addOrder(Order.asc("sfzh"));
		return c;
	}

}

