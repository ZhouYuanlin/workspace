package cn.uuf.stu.ltx.wages.service;


import java.util.List;

import cn.uuf.domain.Retirewages;
import cn.uuf.domain.Retirement;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.service.IBaseService;

public interface IWagesService extends IBaseService<Retirewages, Long> {
	/**
	 * 查询所有
	 */
	List<Retirewages> getAll();
	
	/**
	 * 分页查询
	 * @param kssj
	 * @param jzsj
	 * @param wages
	 * @param retirement
	 * @param pageable
	 * @return
	 */
	Page<Retirewages> queryList(String kssj,String jzsj,Retirewages wages,Retirement retirement, Pageable pageable);
	
	
	/**
	 * @param retirewages
	 * @return
	 */
	Retirewages getlastMonth(Retirewages retirewages);
	
	/**
	 * @param retirewages
	 * @return
	 */
	Retirewages getnextMonth(Retirewages retirewages);
	
}