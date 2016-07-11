package cn.uuf.ltxxt.activity.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.activity.Retireoldun;
import cn.uuf.ltxxt.activity.service.RetireoldunService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 老年大学
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
@Service
public class RetireoldunServiceImpl extends HibernateDaoSupport<Retireoldun, Long> implements RetireoldunService{

	@Override
	public Long getCount(Retireoldun t,String rxq,String rxz,String byq,String byz) {
		Criteria c = buildCondition(t,rxq,rxz,byq,byz);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<Retireoldun> queryList(Retireoldun t, int s, int size,String rxq,String rxz,String byq,String byz) {
		Criteria c = buildCondition(t,rxq,rxz,byq,byz);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Retireoldun w,String rxq,String rxz,String byq,String byz){
		Criteria c = getSession().createCriteria(Retireoldun.class);
		if(w != null){
			if(w.getKtlx() != null && w.getKtlx().length() > 0)
				c.add(Restrictions.eq("ktlx",w.getKtlx()));
			if(w.getKtzw() != null && w.getKtzw().length() > 0)
				c.add(Restrictions.eq("ktzw",w.getKtzw()));
			if((rxq != null && rxq.length() > 0) && (rxz == null || rxz.equals("")))
				c.add(Restrictions.ge("rxrq",rxq));
			if((rxq == null || rxq.equals("")) && (rxz != null && rxz.length() > 0))
				c.add(Restrictions.ge("rxrq",rxz));
			if((rxq != null && rxq.length() > 0) && (rxz != null && rxz.length() > 0))
				c.add(Restrictions.between("rxrq",rxq,rxz));
			if((byq != null && byq.length() > 0) && (byz == null || byz.equals("")))
				c.add(Restrictions.ge("byrq",byq));
			if((byq == null || byq.equals("")) && (byz != null && byz.length() > 0))
				c.add(Restrictions.ge("byrq",byz));
			if((byq != null && byq.length() > 0) && (byz != null && byz.length() > 0))
				c.add(Restrictions.between("byrq",byq,byz));
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
			}
		}
		c.addOrder(Order.desc("createDate"));
		return c;
	}

	@Override
	public List<Retireoldun> queryByVo(Retireoldun o) {
		Criteria c = buildCondition(o, null,null,null,null);
		return c.list();
	}

}

