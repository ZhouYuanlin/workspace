package cn.uuf.wechat.activity.service.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Service;

import cn.uuf.domain.activity.ActivityApply;
import cn.uuf.stu.framework.common.HiParameter;
import cn.uuf.stu.framework.service.impl.BaseServiceImpl;
import cn.uuf.wechat.activity.dao.ActivityApplyDao;
import cn.uuf.wechat.activity.service.ActivityApplyService;

@Service(value="activityApplyService")
public class ActivityApplyServiceImpl extends BaseServiceImpl<ActivityApply, Long> implements ActivityApplyService {

	@Resource(name="activityApplyDao")
	private ActivityApplyDao activityApplyDao;
	
	@Resource(name="activityApplyDao")
	public void setBaseDao(ActivityApplyDao baseDao) {
		super.setBaseDao(activityApplyDao);
	}

	@Override
	public List<ActivityApply> queryList(ActivityApply activother) {
		StringBuffer sb = new StringBuffer();
		sb.append("select a from ActivityApply a where a.activity.id =:activityId ");
		List<HiParameter> list = new ArrayList<HiParameter>();
		list.add(new HiParameter("activityId", activother.getActivity().getId(),  LongType.INSTANCE));
		
		/*if(wetirement.getCreateDate()!=null ){
			sb.append(" and a.createDate>=:createDate and a.createDate<=:endDate ");
			list.add(new HiParameter("createDate", wetirement.getCreateDate(),  DateType.INSTANCE));
			list.add(new HiParameter("endDate", wetirement.getCreateDate(),  DateType.INSTANCE));
		}*/
		if(activother.getState()!=null){
			sb.append(" and a.state =:state ");
			list.add(new HiParameter("state", activother.getState(),StringType.INSTANCE));
		}
		if(activother.getIdCard()!=null){
			sb.append(" and a.idCard=:idCard ");
			list.add(new HiParameter("idCard", activother.getIdCard(),  StringType.INSTANCE));
		}
		List<ActivityApply> hqlList = activityApplyDao.getHqlList(sb.toString(), list);
		return hqlList;
	}
	
	@Override
	public List<String> getTimes(String start , String end) throws ParseException{
		List<String> list = new ArrayList<String>();
		Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = df.parse(start);
        startCalendar.setTime(startDate);
        Date endDate = df.parse(end);
        endCalendar.setTime(endDate);
        list.add(start);
        while(true){
            startCalendar.add(Calendar.DAY_OF_MONTH, 1);
            if(startCalendar.getTimeInMillis() < endCalendar.getTimeInMillis()){//TODO 转数组或是集合，楼主看着写吧
	           list.add(df.format(startCalendar.getTime()));
		        }else{
		            break;
		        }
        }
        list.add(end);
		return list;
	}
}