package cn.uuf.wechat.personal.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import cn.uuf.domain.Retirement;
import cn.uuf.stu.framework.dao.impl.BaseDaoImpl;
import cn.uuf.wechat.personal.dao.IPersonalDao;

@Repository(value="personalDao")
public class PersonalDaoImpl extends BaseDaoImpl<Retirement, String> implements IPersonalDao {

	/**
	 * 返回查询对象的Criteria
	 */
	@Override
	public Criteria queryList(Retirement retirement) {
		Criteria criteria = getSession().createCriteria(retirement.getClass());
		return criteria;
	} 
	/**
	 * 返回list
	 */
	@Override
	public List queryBySql(String sql) throws Exception {
		List list = getSession().createSQLQuery(sql).list();
		return list;
	}
}
