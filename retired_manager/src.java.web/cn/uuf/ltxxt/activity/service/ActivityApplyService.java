package cn.uuf.ltxxt.activity.service;

import java.util.List;

import cn.uuf.domain.activity.ActivityApply;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
public interface ActivityApplyService {

	public void save(ActivityApply t);
	public void update(ActivityApply t);
	public void delete(Long... id);
	public ActivityApply getById(Long id);
	public Long getCount(ActivityApply t);
	public List<ActivityApply> queryList(ActivityApply t,int s,int size);
	public List<ActivityApply> queryByAid(ActivityApply a);
}

