package cn.uuf.stu.ltx.wages.dao.impl;


import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import cn.uuf.domain.Retirewages;
import cn.uuf.stu.framework.dao.impl.BaseDaoImpl;
import cn.uuf.stu.ltx.wages.dao.IWagesDao;

@Repository(value="wagesDao")
public class WagesDaoImpl extends BaseDaoImpl<Retirewages, Long> implements IWagesDao {
	/**
	 * 查询所有
	 */
	@Override
	public Retirewages getRetirewages(String sql) {
		Criteria c = this.getSession().createCriteria(Retirewages.class);
		c.setMaxResults(1);
		return (Retirewages) c.uniqueResult();
	}
}
