package cn.uuf.ltxxt.health.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retirement;
import cn.uuf.domain.health.Rethoscard;
import cn.uuf.ltxxt.health.service.RethoscardService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 医保卡
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-3
 */
@Service
public class RethoscardServiceImpl extends HibernateDaoSupport<Rethoscard,Long> implements RethoscardService{

	@Override
	public void save(Rethoscard c){
		getSession().save(c);
	}
	@Override
	public Long getCount(Rethoscard c) {
		Criteria criteria = buildCondition(c);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Rethoscard> queryList(Rethoscard c, int s, int size) {
		Criteria cc = buildCondition(c);
		cc.setFirstResult(s).setMaxResults(size);
		return cc.list();
	}

	@Override
	public List<Rethoscard> queryByVo(Rethoscard c) {
		Criteria cc = buildCondition(c);
		return cc.list();
	}

	private Criteria buildCondition(Rethoscard w){
		Criteria c = getSession().createCriteria(Rethoscard.class);
		if(w != null){
			if(w.getSfff() != null && w.getSfff().length() > 0)
				c.add(Restrictions.eq("sfff",w.getSfff()));
			if(w.getFyrq() != null && w.getFyrq().length() > 0)
				c.add(Restrictions.ge("fyrq",w.getFyrq()));
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
		c.addOrder(Order.desc("fyrq"));
		return c;
	}
	@Override
	public List<Rethoscard> getBySfzh(Rethoscard card) {
		Criteria c = getSession().createCriteria(Rethoscard.class);
		if(card!=null){
			if(card.getRet()!=null){
				c.createAlias("ret","r");
				if(card.getRet().getSfzh()!=null && card.getRet().getSfzh().length()>0){
					c.add(Restrictions.eq("r.sfzh", card.getRet().getSfzh()));
				}
			}
		}
		return c.list();
		
	}
}

