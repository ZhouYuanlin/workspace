package cn.uuf.ltxxt.car.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Service;

import cn.uuf.domain.User;
import cn.uuf.ltxxt.car.service.UseService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 车辆管理
 * @author fc
 * @version 1.0
 * @date 2016-5-12 11:34:22
 */
@Service
public class UseServiceImpl extends HibernateDaoSupport<User,Long> implements UseService{
	//获取车辆信息总数量
	public Long getCount(User c) {
		Criteria criteria = buildCondition(c);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}
	
	//查询Carinfo
	public List<User> queryList(User d, int s, int size) {
		Criteria c = buildCondition(d);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
	
	private Criteria buildCondition(User d){
		Criteria c = getSession().createCriteria(d.getClass());
		//查询条件添加
		
		
		return c;
	}

	

}

