package cn.uuf.wechat.personal.service;


import java.util.List;

import cn.uuf.domain.Retirement;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.service.IBaseService;

public interface IPersonalService extends IBaseService<Retirement, String>{
	
	/**
	 * 查询信息方法
	 * @param retirement
	 * @param p
	 * @return
	 */
//	List<Retirement> queryList(Retirement retirement);

	Page<Retirement> queryList(Retirement retirement, Pageable pageable);
	public List queryBySql(String sql) throws Exception;
}
