package cn.uuf.ltxxt.car.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.car.Carapply;
import cn.uuf.domain.meetingroom.MeetingApply;
import cn.uuf.ltxxt.car.service.CarApplyService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 车辆管理
 * @author fc
 * @version 1.0
 * @date 2016-5-12 11:34:22
 * 
 */
@Service
public class CarApplyServiceImpl extends HibernateDaoSupport<Carapply,Long> implements CarApplyService{
	//获取车辆信息总数量
	public Long getCount(Carapply c) {
		Criteria criteria = buildCondition(c);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}
	
	public List<Carapply> queryList(Carapply d, int s, int size) {
		Criteria c = buildCondition(d);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Carapply d){
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
			if(d.getUseTime()!=null&&!"".equals(d.getUseTime())){
				c.add(Restrictions.eq("useTime", d.getUseTime()));
			}
			if(d.getCarinfo()!=null&&!"".equals(d.getCarinfo())){
				c.createAlias("carinfo","c");
				if(d.getCarinfo().getCarName()!=null&&!"".equals(d.getCarinfo().getCarName())){
					c.add(Restrictions.like("c.carName",d.getCarinfo().getCarName(),MatchMode.ANYWHERE));
				}
				if(d.getCarinfo().getCarDriver()!=null&&!"".equals(d.getCarinfo().getCarDriver())){
					c.add(Restrictions.like("c.carDriver",d.getCarinfo().getCarDriver(),MatchMode.ANYWHERE));
				}
				if(d.getCarinfo().getCarNumber()!=null&&!"".equals(d.getCarinfo().getCarNumber())){
					c.add(Restrictions.like("c.carNumber",d.getCarinfo().getCarNumber(),MatchMode.ANYWHERE));
				}
			}
		}
		c.addOrder(Order.desc("useTime"));
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


	@Override
	public List<Carapply> queryByCid(Carapply capply) {
		Criteria c = getSession().createCriteria(Carapply.class);
		if(capply!=null){
			if(capply.getCarinfo()!=null){
				c.createAlias("carinfo","c");
				if(capply.getCarinfo().getId()!=null){
					c.add(Restrictions.eq("c.id", capply.getCarinfo().getId()));
				}
			}
		}
		return c.list();
		
	}

}
