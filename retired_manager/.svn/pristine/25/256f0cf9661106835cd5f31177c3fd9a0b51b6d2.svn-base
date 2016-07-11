package cn.uuf.ltxxt.retire.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retiremember;
import cn.uuf.ltxxt.retire.service.RetirememberService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 家庭成员
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Service
public class RetirememberServiceImpl extends HibernateDaoSupport<Retiremember,Long> implements RetirememberService{

	@Override
	public Long getCount(Retiremember m) {
		Criteria criteria = buildCondition(m);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retiremember> queryList(Retiremember m, int s, int size) {
		Criteria c = buildCondition(m);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Retiremember m){
		Criteria c = getSession().createCriteria(Retiremember.class);
		if(m != null){
			if(m.getRet() != null)
				c.add(Restrictions.eq("ret",m.getRet()));
			if(m.getMxm() != null && m.getMxm().length() > 0)
				c.add(Restrictions.like("mxm",m.getMxm(),MatchMode.ANYWHERE));
		}
		return c;
	}

}

