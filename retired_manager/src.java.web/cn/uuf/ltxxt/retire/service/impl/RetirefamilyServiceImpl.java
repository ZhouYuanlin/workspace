package cn.uuf.ltxxt.retire.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.contants.Constants;
import cn.uuf.domain.Retirefamily;
import cn.uuf.ltxxt.retire.service.RetirefamilyService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 家庭成员
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
@Service
public class RetirefamilyServiceImpl extends HibernateDaoSupport<Retirefamily,Long> implements RetirefamilyService{

	@Override
	public Long getCount(Retirefamily f) {
		Criteria criteria = buildCondition(f);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retirefamily> queryList(Retirefamily f, int s, int size) {
		Criteria c = buildCondition(f);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	private Criteria buildCondition(Retirefamily f){
		Criteria c = getSession().createCriteria(Retirefamily.class);
		if(f != null){
			if(f.getSfmr() != null && f.getSfmr().length() > 0)
				c.add(Restrictions.eq("sfmr",f.getSfmr()));
			if(f.getRet() != null)
				c.add(Restrictions.eq("ret",f.getRet()));
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
			}
			if(f.getJtdz()!=null){
				c.add(Restrictions.like("jtdz", "%"+f.getJtdz()+"%"));
			}
		}
		return c;
	}

	@Override
	public void updateSql(String sql) {
		getSession().createSQLQuery(sql).executeUpdate();
	}

}

