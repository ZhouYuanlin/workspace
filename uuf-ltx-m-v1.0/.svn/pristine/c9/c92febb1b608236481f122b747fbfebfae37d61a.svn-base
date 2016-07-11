package cn.uuf.wechat.personal.dao;

import java.util.List;

import org.hibernate.Criteria;

import cn.uuf.domain.Retirement;
import cn.uuf.stu.framework.dao.IBaseDao;

public interface IPersonalDao extends IBaseDao<Retirement, String> {
	
	/**
	 * 返回Criteria查询方式
	 * @param retirement
	 * @return
	 */
	Criteria queryList(Retirement retirement);

	List queryBySql(String sql) throws Exception;
}
