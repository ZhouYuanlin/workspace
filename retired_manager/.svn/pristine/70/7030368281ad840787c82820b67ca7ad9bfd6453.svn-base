package cn.uuf.ltxxt.car.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.car.Carinfo;
import cn.uuf.ltxxt.car.service.CarInfoService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 车辆管理
 * @author fc
 * @version 1.0
 * @date 2016-5-12 11:34:22
 */
@Service
public class CarInfoServiceImpl extends HibernateDaoSupport<Carinfo,Long> implements CarInfoService{
	//获取车辆信息总数量
	public Long getCount(Carinfo c) {
		Criteria criteria = buildCondition(c);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}
	
	//查询Carinfo
	public List<Carinfo> queryList(Carinfo d, int s, int size) {
		Criteria c = buildCondition(d);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(Carinfo d){
		Criteria c = getSession().createCriteria(d.getClass());
		//查询条件添加
		if(d!=null){
			if(d.getCarName()!=null&&!"".equals(d.getCarName())){
				c.add(Restrictions.like("carName",d.getCarName(),MatchMode.ANYWHERE));
			}
			if(d.getCarNumber()!=null&&!"".equals(d.getCarNumber())){
				c.add(Restrictions.like("carNumber",d.getCarNumber(),MatchMode.ANYWHERE));
			}
			if(d.getPeopleNumber()!=null&&!"".equals(d.getPeopleNumber())){
				c.add(Restrictions.eq("peopleNumber",d.getPeopleNumber()));
			}
			if(d.getCarType()!=null&&!"".equals(d.getCarType())){
				c.add(Restrictions.eq("carType",d.getCarType()));
			}
			if(d.getCarDriver()!=null&&!"".equals(d.getCarDriver())){
				c.add(Restrictions.like("carDriver",d.getCarDriver(),MatchMode.ANYWHERE));
			}
			if(d.getTel()!=null&&!"".equals(d.getTel())){
				c.add(Restrictions.like("tel",d.getTel(),MatchMode.ANYWHERE));
			}
			if(d.getAccount()!=null){
				c.createAlias("account","a");
				if(d.getAccount() != null && d.getAccount().getRealname() != null && d.getAccount().getRealname().length() > 0)
					c.add(Restrictions.like("a.realname",d.getAccount().getRealname(),MatchMode.ANYWHERE));
			}
		}
		c.addOrder(Order.desc("updateDate"));
		return c;
	}

	

}

