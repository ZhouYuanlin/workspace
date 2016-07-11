package cn.uuf.ltxxt.meetingRoom.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.meetingroom.MeetingApply;
import cn.uuf.ltxxt.meetingRoom.service.MeetingApplyShow;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;


@Service
public class MeetingApplyShowImpl extends HibernateDaoSupport<MeetingApply, Long> implements MeetingApplyShow{
	
	
	public Long getCount(MeetingApply m,String workTime,String onclickState) {
		Criteria criteria = buildCondition(m, workTime, onclickState);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	public List<MeetingApply> queryList(MeetingApply m, int s, int size,String workTime,String onclickState) {
		Criteria c = buildCondition(m, workTime, onclickState);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	private Criteria buildCondition(MeetingApply m,String workTime,String onclickState){
		Criteria c = getSession().createCriteria(MeetingApply.class);
		if(m != null){
			if(m.getTitle() != null)
				c.add(Restrictions.eq("title",m.getTitle()));
			if(m.getTitle() != null && m.getTitle().length() > 0)
				c.add(Restrictions.like("title",m.getTitle(),MatchMode.ANYWHERE));
			if(m.getApplicantName() !=null)
				c.add(Restrictions.eq("applicantName",m.getApplicantName()));
			if(m.getApplicantName()!=null && m.getApplicantName().length()>0)
				c.add(Restrictions.like("applicantName",m.getApplicantName(),MatchMode.ANYWHERE));
		}
		String startTime="";
		String endTime="";
		if(workTime!=null){
			if(!workTime.equals("0")&&workTime!=null&&!"".equals(workTime)){
				Calendar cal = Calendar.getInstance();
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");   
				try {
					cal.setTime(sd.parse(onclickState));
				} catch (ParseException e) {
					e.printStackTrace();
				}  
				Calendar cal2 = Calendar.getInstance();
				SimpleDateFormat sd2 = new SimpleDateFormat("yyyy-MM-dd");   
				try {
					cal2.setTime(sd2.parse(onclickState));
				} catch (ParseException e) {
					e.printStackTrace();
				}  
				//n为推迟的周数，0本周，-1向前推迟一周，1下周，依次类推
				int n = Integer.parseInt(workTime);
				cal.add(Calendar.DATE, n*7);
				cal2.add(Calendar.DATE, (n+1)*7);
				//想周几，这里就传几Calendar.MONDAY（TUESDAY...）
				cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY); 
				cal2.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY); 
				startTime = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
				endTime = new SimpleDateFormat("yyyy-MM-dd").format(cal2.getTime());
			}else{
				if(onclickState!=null){
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					try {
						startTime=getMondayOfThisWeek(sdf.parse(onclickState));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					try {
						endTime=getMondayOfThisEndWeek(sdf.parse(onclickState));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}else{
					startTime=getMondayOfThisWeek(new Date());
					endTime=getMondayOfThisEndWeek(new Date());
				}
			}
		}else{
			if(onclickState!=null){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				try {
					startTime=getMondayOfThisWeek(sdf.parse(onclickState));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				try {
					endTime=getMondayOfThisEndWeek(sdf.parse(onclickState));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else{
				startTime=getMondayOfThisWeek(new Date());
				endTime=getMondayOfThisEndWeek(new Date());
			}
		}
		if((startTime != null &&!"".equals(startTime)) && (endTime != null &&!"".equals(endTime))){
			c.add(Restrictions.between("useTime",startTime,endTime));
		}
		
		if(m.getMeetingRoom()!=null&&!"".equals(m.getMeetingRoom())){
			c.createAlias("meetingRoom","c");
			if(m.getMeetingRoom().getName()!=null&&!"".equals(m.getMeetingRoom().getName())){
				c.add(Restrictions.like("c.name",m.getMeetingRoom().getName(),MatchMode.ANYWHERE));
			}
		}
		return c;
	}
	
	@Override
	public int dayforwork(String time) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(format.parse(time));
		int dayForWeek = 0;
		if(c.get(Calendar.DAY_OF_WEEK) == 1){
		   dayForWeek = 7;
		}else{
		   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		}
		return dayForWeek;
	}
	
	/**
	  * 得到本周周一
	  * 
	  * @return yyyy-MM-dd
	  */
	 public  String getMondayOfThisWeek(Date time) {
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式  
		 Calendar cal = Calendar.getInstance(); 
		 cal.setTime(time);
		 //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		 int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
		 if(1 == dayWeek) {  
			 cal.add(Calendar.DAY_OF_MONTH, -1);  
		 }
		 cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
		 int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
		 cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//根据日历的规则，给当前日期减去星期几 与一个星期第一天的差值 
		 String imptimeBegin = sdf.format(cal.getTime());
		 cal.add(Calendar.DATE, 6);  
		 return imptimeBegin;
	 }
	 
	 /**
	  * 得到本周周日
	  * 
	  * @return yyyy-MM-dd
	  */
	 public  String getMondayOfThisEndWeek(Date time) {
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式  
		 Calendar cal = Calendar.getInstance(); 
		 cal.setTime(time);
		 //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		 int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
		 if(1 == dayWeek) {  
			 cal.add(Calendar.DAY_OF_MONTH, -1);  
		 }
		 cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
		 int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天  
		 cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//根据日历的规则，给当前日期减去星期几 与一个星期第一天的差值 
		 cal.add(Calendar.DATE, 6);  
		 String imptimeEnd = sdf.format(cal.getTime());  
		 return imptimeEnd;
	 }

	 
}
