package cn.uuf.ltxxt.retire.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Retiresalute;
import cn.uuf.ltxxt.retire.service.RetiresaluteService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 慰问服务
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-3
 */
@Service
public class RetiresaluteServiceImpl extends HibernateDaoSupport<Retiresalute,Long> implements RetiresaluteService{

	@Override
	public Long getCount(Retiresalute s,String ksj,String jsj) {
		Criteria criteria = buildCondition(s,ksj,jsj);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public List<Retiresalute> queryList(Retiresalute s, int s2, int size,String ksj,String jsj) {
		Criteria c = buildCondition(s,ksj,jsj);
		c.setFirstResult(s2).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Retiresalute w,String ksj,String jsj){
		Criteria c = getSession().createCriteria(Retiresalute.class);
		if(w != null){
			if((ksj != null && ksj.length() > 0) && (jsj == null || jsj.equals("")))
				c.add(Restrictions.ge("wwsj",ksj));
			if((ksj== null || ksj.equals("")) && (jsj != null && jsj.length() > 0))
				c.add(Restrictions.le("wwsj",jsj));
			if(ksj != null && ksj.length() > 0 && jsj != null && jsj.length() > 0)
				c.add(Restrictions.between("wwsj",ksj,jsj));
			if(w.getWwdd() != null && w.getWwdd().length() > 0)
				c.add(Restrictions.eq("wwdd",w.getWwdd()));
			if(w.getWwlx() != null && w.getWwlx().length() > 0)
				c.add(Restrictions.eq("wwlx",w.getWwlx()));
			if(w.getKwry() != null && w.getKwry().length() > 0)
				c.add(Restrictions.like("kwry","%"+w.getKwry()+"%"));
			if(w.getRets() != null && w.getRets().length() > 0)
				c.add(Restrictions.like("rets",w.getRets(),MatchMode.ANYWHERE));
		}
		c.addOrder(Order.desc("wwsj"));
		return c;
	}

	@Override
	public void updateHQL(String sql) {
		getSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public List<Retiresalute> queryBySql(String sql) {
		Query query = getSession().createQuery(sql);
		return query.list();
	}

}

