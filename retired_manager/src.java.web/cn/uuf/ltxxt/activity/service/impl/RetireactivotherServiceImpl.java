package cn.uuf.ltxxt.activity.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.sun.star.mail.MailAttachment;

import cn.uuf.domain.activity.Retireactivother;
import cn.uuf.domain.health.Retphone;
import cn.uuf.ltxxt.activity.service.RetireactivotherService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 其它活动
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
@Service
public class RetireactivotherServiceImpl extends HibernateDaoSupport<Retireactivother, Long> implements RetireactivotherService{

	@Override
	public Long getCount(Retireactivother t,String hdsjq,String hdsjz) {
		Criteria c = buildCondition(t,hdsjq,hdsjz);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<Retireactivother> queryList(Retireactivother t, int s, int size,String hdsjq,String hdsjz) {
		Criteria c = buildCondition(t,hdsjq,hdsjz);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	@Override
	public List<Retireactivother> queryBySql(String sql) {
		Query query = getSession().createQuery(sql);
		return query.list();
	}
	private Criteria buildCondition(Retireactivother w,String hdsjq,String hdsjz){
		Criteria c = getSession().createCriteria(Retireactivother.class);
		if(w != null){
			if(w.getName() != null && w.getName().length() > 0)
				c.add(Restrictions.like("name",w.getName(),MatchMode.ANYWHERE));
			if(hdsjq != null && hdsjq.length() > 0)
				c.add(Restrictions.ge("hdsj",hdsjq));
			if(hdsjz != null && hdsjz.length() > 0)
				c.add(Restrictions.le("hdsj",hdsjz));
		}
		c.addOrder(Order.desc("hdsj"));
		return c;
	}

	@Override
	public List<Retireactivother> queryByVo(Retireactivother t) {
		Criteria c = buildCondition(t,null,null);
		return c.list();
	}

}

