package cn.uuf.ltxxt.system.code.service.impl;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import cn.uuf.ltxxt.system.code.service.CommonService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-27
 */
public class CommonServiceImpl extends HibernateDaoSupport<T,Long> implements CommonService<T>{

	@Override
	public T queryString(String s) {
		Criteria c = getSession().createCriteria(T.class);
		c.add(Restrictions.or(Restrictions.eq("code",s),Restrictions.eq("name",s)));
		c.setCacheable(true);
		return (T) c.uniqueResult();
	}
}


