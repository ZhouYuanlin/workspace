package cn.uuf.stu.ltx.health.service;


import cn.uuf.domain.Retirement;
import cn.uuf.domain.health.Rethealth;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.service.IBaseService;

public interface IHealthService extends IBaseService<Rethealth, Long> {

	
	/**
	 * 查询体检信息
	 * @param rethealth
	 * @return
	 */
	Page<Rethealth> queryList(String kssj,String jzsj,Rethealth rethealth,Retirement retirement,Pageable pageable);
}
