package cn.uuf.wechat.activity.service;


import java.text.ParseException;
import java.util.List;

import cn.uuf.domain.activity.ActivityApply;
import cn.uuf.stu.framework.service.IBaseService;

public interface ActivityApplyService extends IBaseService<ActivityApply, Long> {
	/**
	 * 分页查询
	 * @param activother
	 * @param pageable
	 * @return
	 */
	List<ActivityApply> queryList(ActivityApply activother);
	
	public List<String> getTimes(String start , String end) throws ParseException;
	
}
