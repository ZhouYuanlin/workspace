package cn.uuf.ltxxt.party.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.activity.Retireactivother;
import cn.uuf.domain.ret.Retirepartywork;
import cn.uuf.ltxxt.party.service.RetirepartyworkService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;
/**
 * 党建工作
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-14
 */
@Service
public class RetirepartyworkServiceImpl extends HibernateDaoSupport<Retirepartywork,Long> implements RetirepartyworkService{

	@Override
	public Long getCount(Retirepartywork w,String kssj,String jssj) {
		Criteria criteria = buildCondition(w,kssj,jssj);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retirepartywork> queryList(Retirepartywork w, int s, int size,String kssj,String jssj) {
		Criteria c = buildCondition(w, kssj, jssj);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	@Override
	public List<Retirepartywork> queryBySql(String sql) {
		Query query = getSession().createQuery(sql);
		return query.list();
	}
	private Criteria buildCondition(Retirepartywork f,String kssj,String jssj){
		Criteria c = getSession().createCriteria(Retirepartywork.class);
		if(f != null){
			if(f.getTitle() != null && f.getTitle().length() > 0)
				c.add(Restrictions.like("title",f.getTitle(),MatchMode.ANYWHERE));
			if((kssj != null && kssj.length() > 0) && (jssj == null || jssj.length() == 0))
				c.add(Restrictions.ge("kfrq",kssj));
			if((jssj != null && jssj.length() > 0) && (kssj == null || kssj.length() == 0))
				c.add(Restrictions.ge("kfrq",jssj));
			if((jssj != null && jssj.length() > 0) && (kssj != null && kssj.length() > 0))
				c.add(Restrictions.between("kfrq",kssj,jssj));
			if(f.getRetireparty()!=null){
				if(f.getRetireparty().getDzbmc()!=null && f.getRetireparty().getDzbmc().length()>0){
					c.add(Restrictions.like("kfdzb", "%"+f.getRetireparty().getDzbmc()+"%"));
				}
			}
		}
		c.addOrder(Order.desc("kfrq"));
		return c;
	}

	@Override
	public List<Retirepartywork> queryByVo(Retirepartywork p) {
		Criteria c = buildCondition(p,null,null);
		return c.list();
	}

}

