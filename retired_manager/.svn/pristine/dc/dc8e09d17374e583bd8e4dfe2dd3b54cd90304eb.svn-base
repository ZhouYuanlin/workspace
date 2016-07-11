package cn.uuf.ltxxt.system.permission.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.User;
import cn.uuf.ltxxt.system.permission.service.UserService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
@Service
public class UserServiceImpl extends HibernateDaoSupport<User,String> implements UserService{

	@Override
	public Long getCount(User u) {
		Criteria c = buildCondition(u);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("sfzh"));
		c.setProjection(proList);
		return this.getCount(c);
	}

	@Override
	public List<User> queryList(User u, int start, int size) {
		Criteria c = buildCondition(u);
		c.setFirstResult(start).setMaxResults(size);
		c.addOrder(Order.asc("sfzh")).addOrder(Order.asc("codedwb"));
		return this.queryByPage(c);
	}
	
	private Criteria buildCondition(User u){
		Criteria c = getSession().createCriteria(User.class);
		if(u != null){
			if(u.getSfzh() != null && u.getSfzh().length() > 0)
				c.add(Restrictions.or(Restrictions.eq("sfzh", u.getSfzh()),
						Restrictions.or(Restrictions.eq("lxdh",u.getSfzh()),Restrictions.eq("gzzh",u.getSfzh()))));
			if(u.getLxdh() != null && u.getLxdh().length() > 0)
				c.add(Restrictions.eq("lxdh",u.getLxdh()));
			if(u.getGzzh() != null && u.getGzzh().length() > 0)
				c.add(Restrictions.eq("gzzh",u.getGzzh()));
			if(u.getXm() != null && u.getXm().length() > 0)
				c.add(Restrictions.like("xm",u.getXm(),MatchMode.ANYWHERE));
			if(u.getXb() != null && u.getXb().length() > 0)
				c.add(Restrictions.eq("xb",u.getXb()));
			if(u.getCodedwb()!=null)
				c.add(Restrictions.eq("codedwb",u.getCodedwb()));
		}
		return c;
	}

}

