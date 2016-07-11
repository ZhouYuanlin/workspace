package cn.uuf.wechat.activity.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.uuf.domain.activity.Activity;
import cn.uuf.stu.framework.common.HiParameter;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.service.impl.BaseServiceImpl;
import cn.uuf.wechat.activity.dao.ActivityDao;
import cn.uuf.wechat.activity.service.ActivityService;

@Service(value="activitysService")
public class ActivitysServiceImpl extends BaseServiceImpl<Activity, Long> implements ActivityService {

	@Resource(name="activitysDao")
	private ActivityDao activitysDao;
	
	@Resource(name="activitysDao")
	public void setBaseDao(ActivityDao baseDao) {
		super.setBaseDao(activitysDao);
	}

	@Override
	public Page<Activity> queryList(Activity activother, Pageable pageable) {
		StringBuffer sb = new StringBuffer();
		sb.append(" from Retireactivother a");
		List<HiParameter> parameters = new ArrayList<HiParameter>();
		pageable.setParams(parameters);
		pageable.setQueryListStr("select a"+sb.toString());
		pageable.setQueryCountStr("select count(*) "+sb.toString());
		Page<Activity> page = activitysDao.getHqlPage(pageable);
		return page;
	}
}