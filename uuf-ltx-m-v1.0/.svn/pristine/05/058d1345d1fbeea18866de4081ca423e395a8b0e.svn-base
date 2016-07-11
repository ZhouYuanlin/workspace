package cn.uuf.wechat.wages.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import cn.uuf.domain.Retirewages;
import cn.uuf.stu.framework.dao.impl.BaseDaoImpl;
import cn.uuf.wechat.wages.dao.IWagesDao;

@Repository(value="wagesDao")
public class WagesDaoImpl extends BaseDaoImpl<Retirewages, Long> implements IWagesDao {
	/**
	 * 查询所有
	 */
	@Override
	public List<Retirewages> getAll() {
		Criteria criteria = getSession().createCriteria(Retirewages.class);
		criteria.addOrder(Order.desc("yf"));
		return criteria.list();
	}
}
