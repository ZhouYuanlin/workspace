package cn.uuf.ltxxt.retire.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retirelive;
import cn.uuf.ltxxt.retire.service.RetireliveService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 养老模式
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Service
public class RetireliveServiceImpl extends HibernateDaoSupport<Retirelive,Long> implements RetireliveService{

	@Override
	public Long getCount(Retirelive l) {
		Criteria criteria = buildCondition(l);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retirelive> queryList(Retirelive l, int s, int size) {
		Criteria c = buildCondition(l);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}

	private Criteria buildCondition(Retirelive l){
		Criteria c = getSession().createCriteria(Retirelive.class);
		if(l != null){
			if(l.getYlms() != null && l.getYlms().length() > 0)
				c.add(Restrictions.eq("ylms",l.getYlms()));
			if(l.getYldz() != null && l.getYldz().length() > 0)
				c.add(Restrictions.like("yldz",l.getYldz(),MatchMode.ANYWHERE));
			if(l.getRet() != null){
				c.createAlias("ret","r");
				if(l.getRet() != null && l.getRet().getXm() != null && l.getRet().getXm().length() > 0)
					c.add(Restrictions.like("r.xm",l.getRet().getXm(),MatchMode.ANYWHERE));
				if(l.getRet() != null && l.getRet().getSfzh() != null && l.getRet().getSfzh().length() > 0)
					c.add(Restrictions.eq("r.sfzh",l.getRet().getSfzh()));
				if(l.getRet() != null && l.getRet().getXb() != null && l.getRet().getXb().length() > 0)
					c.add(Restrictions.eq("r.xb",l.getRet().getXb()));
				if(l.getRet() != null && l.getRet().getDwb() != null && l.getRet().getDwb().getId() != null)
					c.add(Restrictions.eq("r.dwb",l.getRet().getDwb()));
				if(l.getRet() != null && l.getRet().getZwb() != null && l.getRet().getZwb().getId() != null)
					c.add(Restrictions.eq("r.zwb",l.getRet().getZwb()));
			}
		}
		return c;
	}

	@Override
	public List<Retirelive> queryByVo(Retirelive l) {
		Criteria c = buildCondition(l);
		return c.list();
	}
}

