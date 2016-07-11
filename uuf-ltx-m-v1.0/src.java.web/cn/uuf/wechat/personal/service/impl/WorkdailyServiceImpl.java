package cn.uuf.wechat.personal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.type.DateType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Service;

import cn.uuf.domain.daily.Workdaily;
import cn.uuf.stu.framework.common.HiParameter;
import cn.uuf.stu.framework.service.impl.BaseServiceImpl;
import cn.uuf.wechat.personal.dao.WorkdailyDao;
import cn.uuf.wechat.personal.service.WorkdailyService;

@Service(value="workdailyService")
public class WorkdailyServiceImpl extends BaseServiceImpl<Workdaily, Long> implements WorkdailyService{
	
	@Resource(name="workdailyDao")
	private WorkdailyDao workdailyDao;
	
	@Resource(name="workdailyDao")
	public void setBaseDao(WorkdailyDao baseDao) {
		super.setBaseDao(workdailyDao);
	}


	@Override
	public List<Workdaily> queryList(Workdaily wetirement) {
		StringBuffer sb = new StringBuffer();
		sb.append("select a from Workdaily a where a.xm =:xm ");
		List<HiParameter> list = new ArrayList<HiParameter>();
		list.add(new HiParameter("xm", wetirement.getXm(), StringType.INSTANCE));
		if(wetirement.getCreateDate()!=null ){
			sb.append(" and a.createDate>=:createDate and a.createDate<=:endDate ");
			list.add(new HiParameter("createDate", wetirement.getCreateDate(),  DateType.INSTANCE));
			list.add(new HiParameter("endDate", wetirement.getCreateDate(),  DateType.INSTANCE));
		}
		List<Workdaily> hqlList = workdailyDao.getHqlList(sb.toString(), list);
		return hqlList;
	}
}
