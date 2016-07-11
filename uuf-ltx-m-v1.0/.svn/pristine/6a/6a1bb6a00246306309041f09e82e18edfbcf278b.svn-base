package cn.uuf.wechat.activity.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.uuf.domain.activity.Retireactivother;
import cn.uuf.stu.framework.common.HiParameter;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.service.impl.BaseServiceImpl;
import cn.uuf.wechat.activity.dao.IActivityDao;
import cn.uuf.wechat.activity.service.IActivityService;

@Service(value="activityService")
public class ActivityServiceImpl extends BaseServiceImpl<Retireactivother, Long> implements IActivityService {

	@Resource(name="activityDao")
	private IActivityDao activityDao;
	
	@Resource(name="activityDao")
	public void setBaseDao(IActivityDao baseDao) {
		super.setBaseDao(activityDao);
	}

	@Override
	public Page<Retireactivother> queryList(Retireactivother activother, Pageable pageable) {
		StringBuffer sb = new StringBuffer();
		sb.append(" from Retireactivother a order by hdsj desc");
		List<HiParameter> parameters = new ArrayList<HiParameter>();
		pageable.setParams(parameters);
		pageable.setQueryListStr("select a"+sb.toString());
		pageable.setQueryCountStr("select count(*) "+sb.toString());
		Page<Retireactivother> page = activityDao.getHqlPage(pageable);
		return page;
	}
}