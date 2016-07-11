package cn.uuf.ltxxt.car.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.car.Carapply;
import cn.uuf.ltxxt.car.service.CarApplyShowService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 车辆管理
 * @author fc
 * @version 1.0
 * @date 2016-5-12 11:34:22
 */
@Service
public class CarApplyShowServiceImpl extends HibernateDaoSupport<Carapply,Long> implements CarApplyShowService{
	//获取车辆信息总数量
	public Long getCount(Carapply c,String workTime,String onclickState) {
		Criteria criteria = buildCondition(c,workTime,onclickState);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}
	
	public List<Carapply> queryList(Carapply d, int s, int size,String workTime,String onclickState) {
		Criteria c = buildCondition(d,workTime,onclickState);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Carapply d,String workTime,String onclickState){
		Criteria c = getSession().createCriteria(d.getClass());
		if(d!=null){
			if(d.getApplyName()!=null&&!"".equals(d.getApplyName())){
				c.add(Restrictions.like("applyName",d.getApplyName(),MatchMode.ANYWHERE));
			}
			if(d.getPeopleNumber()!=null&&!"".equals(d.getPeopleNumber())){
				c.add(Restrictions.eq("peopleNumber",d.getPeopleNumber()));
			}
			if(d.getTel()!=null&&!"".equals(d.getTel())){
				c.add(Restrictions.like("tel",d.getTel(),MatchMode.ANYWHERE));
			}
			if(d.getState()!=null&&!"".equals(d.getState())){
				c.add(Restrictions.eq("state",d.getState()));
			}
			if(d.getStartTime()!=null&&!"".equals(d.getStartTime())){
				c.add(Restrictions.ge("startTime", d.getStartTime()));
			}
			if(d.getEndTime()!=null&&!"".equals(d.getEndTime())){
				c.add(Restrictions.le("endTime", d.getEndTime()));
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
			/*if((startTime != null &&!"".equals(startTime)) && (endTime != null &&!"".equals(endTime))){
				c.add(Restrictions.between("useTime",startTime,endTime));
			}
			*/
			if(d.getCarinfo()!=null&&!"".equals(d.getCarinfo())){
				c.createAlias("carinfo","c");
				if(d.getCarinfo().getId()!=null&&!"".equals(d.getCarinfo().getId())){
					c.add(Restrictions.eq("c.id",d.getCarinfo().getId()));
				}
				if(d.getCarinfo().getCarDriver()!=null&&!"".equals(d.getCarinfo().getCarDriver())){
					c.add(Restrictions.eq("c.carDriver",d.getCarinfo().getCarDriver()));
				}
				if(d.getCarinfo().getCarNumber()!=null&&!"".equals(d.getCarinfo().getCarNumber())){
					c.add(Restrictions.eq("c.carNumber",d.getCarinfo().getCarNumber()));
				}
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

