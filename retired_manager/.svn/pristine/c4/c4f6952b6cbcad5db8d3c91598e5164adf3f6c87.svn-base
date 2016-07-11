package cn.uuf.ltxxt.retire.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retirehelp;
import cn.uuf.ltxxt.retire.service.RetirehelpService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 困难帮扶
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-3
 */
@Service
public class RetirehelpServiceImpl extends HibernateDaoSupport<Retirehelp,Long> implements RetirehelpService{

	@Override
	public Long getCount(Retirehelp h) {
		Criteria criteria = buildCondition(h);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retirehelp> queryList(Retirehelp h, int s, int size) {
		Criteria c = buildCondition(h);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Retirehelp w){
		Criteria c = getSession().createCriteria(Retirehelp.class);
		if(w != null){
			if(w.getBfyy() != null && w.getBfyy().length() > 0)
				c.add(Restrictions.like("bfyy",w.getBfyy(),MatchMode.ANYWHERE));
			if(w.getBfed() != null && w.getBfed().length() > 0)
				c.add(Restrictions.like("bfed",w.getBfed(),MatchMode.ANYWHERE));
			if(w.getBfxm() != null && w.getBfxm().length() > 0)
				c.add(Restrictions.eq("bfxm",w.getBfxm()));
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
//		c.addOrder(Order.asc("ret"));
		return c;
	}

	@Override
	public List<Retirehelp> queryByVo(Retirehelp h) {
		Criteria c = buildCondition(h);
		return c.list();
	}

}

