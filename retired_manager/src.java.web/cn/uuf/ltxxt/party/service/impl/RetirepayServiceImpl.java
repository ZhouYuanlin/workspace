package cn.uuf.ltxxt.party.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.ret.Retirepay;
import cn.uuf.ltxxt.party.service.RetirepayService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 党费信息
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-14
 */
@Service
public class RetirepayServiceImpl extends HibernateDaoSupport<Retirepay,Long> implements RetirepayService{

	@Override
	public Long getCount(Retirepay p,String kssj,String jssj) {
		Criteria criteria = buildCondition(p,kssj,jssj);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retirepay> queryList(Retirepay p, int s, int size,String kssj,String jssj) {
		Criteria c = buildCondition(p, kssj, jssj);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}

	private Criteria buildCondition(Retirepay w,String kssj,String jssj){
		Criteria c = getSession().createCriteria(Retirepay.class);
		if(w != null){
			if(w.getJfsj() != null && w.getJfsj().length() > 0)
				c.add(Restrictions.ge("jfsj",w.getJfsj()));
			if(kssj != null && kssj.length() > 0 && (jssj == null || jssj.equals("")))
				c.add(Restrictions.ge("jfsj",kssj));
			if((kssj == null || kssj.equals("")) && jssj != null && jssj.length() > 0)
				c.add(Restrictions.le("jfsj",jssj));
			if(kssj != null && kssj.length() > 0 && jssj != null && jssj.length() > 0)
				c.add(Restrictions.between("jfsj",kssj,jssj));
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
				if(w.getRet().getParty() != null && w.getRet().getParty().getId() != null)
					c.add(Restrictions.eq("r.party",w.getRet().getParty()));
			}
		}
		return c;
	}

	@Override
	public List<Retirepay> queryByVo(Retirepay p) {
		Criteria c = buildCondition(p,null,null);
		return c.list();
	}
}

