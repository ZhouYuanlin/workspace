package cn.uuf.ltxxt.activity.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.activity.Retireworthiness;
import cn.uuf.ltxxt.activity.service.RetireworthinessService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 老年大学
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
@Service
public class RetireworthinessServiceImpl extends HibernateDaoSupport<Retireworthiness, Long> implements RetireworthinessService{

	@Override
	public Long getCount(Retireworthiness t,String rxq,String rxz) {
		Criteria c = buildCondition(t,rxq,rxz);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<Retireworthiness> queryList(Retireworthiness t, int s, int size,String rxq,String rxz) {
		Criteria c = buildCondition(t,rxq,rxz);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Retireworthiness w,String rxq,String rxz){
		Criteria c = getSession().createCriteria(Retireworthiness.class);
		if(w != null){
			if(w.getTitle() != null && w.getTitle().length() > 0)
				c.add(Restrictions.like("title",w.getTitle(),MatchMode.ANYWHERE));
			if(w.getSfxjxz() != null && w.getSfxjxz().length() > 0)
				c.add(Restrictions.eq("sfxjxz",w.getSfxjxz()));
			if((rxq != null && rxq.length() > 0) && (rxz == null || rxz.equals("")))
				c.add(Restrictions.ge("xjsj",rxq));
			if((rxq == null || rxq.equals("")) && (rxz != null && rxz.length() > 0))
				c.add(Restrictions.ge("xjsj",rxz));
			if((rxq != null && rxq.length() > 0) && (rxz != null && rxz.length() > 0))
				c.add(Restrictions.between("xjsj",rxq,rxz));
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
	public List<Retireworthiness> queryByVo(Retireworthiness t) {
		Criteria c = buildCondition(t,null,null);
		return c.list();
	}

}

