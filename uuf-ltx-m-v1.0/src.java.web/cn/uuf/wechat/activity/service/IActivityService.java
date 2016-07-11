package cn.uuf.wechat.activity.service;


import cn.uuf.domain.activity.Retireactivother;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.service.IBaseService;

public interface IActivityService extends IBaseService<Retireactivother, Long> {
	/**
	 * 分页查询
	 * @param activother
	 * @param pageable
	 * @return
	 */
	Page<Retireactivother> queryList(Retireactivother activother, Pageable pageable);
	
}
