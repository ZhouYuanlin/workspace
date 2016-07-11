package cn.uuf.ltxxt.party.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.ret.Retiredonations;
import cn.uuf.ltxxt.party.service.RetiredonationsService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 捐款记录
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-14
 */
@Service
public class RetiredonationsServiceImpl extends HibernateDaoSupport<Retiredonations,Long> implements RetiredonationsService{

	@Override
	public Long getCount(Retiredonations d,String kssj,String jssj) {
		Criteria criteria = buildCondition(d,kssj,jssj);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retiredonations> queryList(Retiredonations d, int s, int size,String kssj,String jssj) {
		Criteria c = buildCondition(d, kssj, jssj);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Retiredonations f,String kssj,String jssj){
		Criteria c = getSession().createCriteria(Retiredonations.class);
		if(f != null){
			if(f.getJkrq() != null && f.getJkrq().length() > 0)
				c.add(Restrictions.ge("jkrq",f.getJkrq()));
			if((kssj != null && kssj.length() > 0) && (jssj == null || jssj.equals("")))
				c.add(Restrictions.ge("jkrq",kssj));
			if((jssj != null && jssj.length() > 0) && (kssj == null || kssj.equals("")))
				c.add(Restrictions.ge("jkrq",jssj));
			if((jssj != null && jssj.length() > 0) && (kssj != null && kssj.length() > 0))
				c.add(Restrictions.between("jkrq",kssj,jssj));
			if(f.getRet() != null){
				c.createAlias("ret","r");
				if(f.getRet() != null && f.getRet().getXm() != null && f.getRet().getXm().length() > 0)
					c.add(Restrictions.like("r.xm",f.getRet().getXm(),MatchMode.ANYWHERE));
				if(f.getRet() != null && f.getRet().getSfzh() != null && f.getRet().getSfzh().length() > 0)
					c.add(Restrictions.eq("r.sfzh",f.getRet().getSfzh()));
				if(f.getRet() != null && f.getRet().getXb() != null && f.getRet().getXb().length() > 0)
					c.add(Restrictions.eq("r.xb",f.getRet().getXb()));
				if(f.getRet() != null && f.getRet().getDwb() != null && f.getRet().getDwb().getId() != null)
					c.add(Restrictions.eq("r.dwb",f.getRet().getDwb()));
				if(f.getRet() != null && f.getRet().getZwb() != null && f.getRet().getZwb().getId() != null)
					c.add(Restrictions.eq("r.zwb",f.getRet().getZwb()));
				if(f.getRet() != null && f.getRet().getLxb() != null && f.getRet().getLxb().getId() != null)
					c.add(Restrictions.eq("r.lxb",f.getRet().getLxb()));
				if(f.getRet().getParty() != null && f.getRet().getParty().getId() != null)
					c.add(Restrictions.eq("r.party",f.getRet().getParty()));
			}
		}
		c.addOrder(Order.desc("jkrq"));
		return c;
	}

	@Override
	public List<Retiredonations> queryByVo(Retiredonations d) {
		Criteria c = buildCondition(d,null,null);
		return c.list();
	}

}

