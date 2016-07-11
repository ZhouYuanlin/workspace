package cn.uuf.ltxxt.health.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.health.Rethoscosts;
import cn.uuf.ltxxt.health.service.RethoscostsService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;
/**
 * 医疗费用
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-29
 */
@Service
public class RethoscostsServiceImpl extends HibernateDaoSupport<Rethoscosts,Long> implements RethoscostsService{

	@Override
	public Long getCount(Rethoscosts t,String ksj,String jsj) {
		Criteria criteria = buildCondition(t,ksj,jsj);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Rethoscosts> queryList(Rethoscosts t, int s, int size,String ksj,String jsj) {
		Criteria c  = buildCondition(t,ksj,jsj);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Rethoscosts w,String gksj,String gjsj){
		Criteria c = getSession().createCriteria(Rethoscosts.class);
		if(w != null){
			if((gksj != null && gksj.length() > 0) && (gjsj == null || gjsj.equals("")))
				c.add(Restrictions.ge("lqrq",gksj));
			if((gksj == null || gksj.equals("")) && (gjsj != null && gjsj.length() > 0))
				c.add(Restrictions.le("lqrq",gjsj));
			if((gksj != null && gksj.length() > 0) && (gjsj != null && gjsj.length() > 0))
				c.add(Restrictions.between("lqrq",gksj,gjsj));
			if(w.getRet() != null){
				c.createAlias("ret","r");
				if(w.getRet() != null && w.getRet().getXm() != null && w.getRet().getXm().length() > 0)
					c.add(Restrictions.like("r.xm",w.getRet().getXm(),MatchMode.ANYWHERE));
				if(w.getRet() != null && w.getRet().getSfzh() != null && w.getRet().getSfzh().length() > 0)
					c.add(Restrictions.eq("r.sfzh",w.getRet().getSfzh()));
				if(w.getRet() != null && w.getRet().getXb() != null && w.getRet().getXb().length() > 0)
					c.add(Restrictions.eq("r.xb",w.getRet().getXb()));
				if(w.getRet() != null && w.getRet().getDwb() != null && w.getRet().getDwb().getId() != null)
					c.add(Restrictions.eq("r.dwb",w.getRet().getDwb()));
				if(w.getRet() != null && w.getRet().getZwb() != null && w.getRet().getZwb().getId() != null)
					c.add(Restrictions.eq("r.zwb",w.getRet().getZwb()));
				if(w.getRet() != null && w.getRet().getLxb() != null && w.getRet().getLxb().getId() != null)
					c.add(Restrictions.eq("r.lxb",w.getRet().getLxb()));
			}
		}
		c.addOrder(Order.desc("lqrq"));
		return c;
	}

	@Override
	public List<Rethoscosts> queryByVo(Rethoscosts t) {
		Criteria c = buildCondition(t,null,null);
		return c.list();
	}

}

