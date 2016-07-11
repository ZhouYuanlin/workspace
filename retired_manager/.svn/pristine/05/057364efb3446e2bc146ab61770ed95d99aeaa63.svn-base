package cn.uuf.ltxxt.daily.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.daily.Workdaily;
import cn.uuf.ltxxt.daily.service.WorkdailyService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;
import cn.uuf.util.DateUtil;

/**
 * 工作日志
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-17
 */
@Service
public class WorkdailyServiceImpl extends HibernateDaoSupport<Workdaily,Long> implements WorkdailyService{

	@Override
	public Long getCount(Workdaily w,String st,String en,String xrsjst,
			String xrsjend) {
		Criteria c = buildCondition(w,st,en,xrsjst,xrsjend);
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		c.setProjection(proList);
		return this.getCount(c);
	}
	@Override
	public List queryByHql(String hql) throws Exception {
		List list = this.getSession().createQuery(hql).list();
		return list;
	}


	@Override
	public List<Workdaily> queryByVo(Workdaily w,String st,String en) {
		Criteria c = buildCondition(w,st,en,null,null);
		return c.list();
	}

	private Criteria buildCondition(Workdaily w,String startDate,String endDate,String xrsjst,
			String xrsjend){
		Criteria c = getSession().createCriteria(Workdaily.class);
		if(w != null){
			if(w.getSfzh() != null && w.getSfzh().length() > 0)
				c.add(Restrictions.eq("sfzh",w.getSfzh()));
			if(w.getXm() != null && w.getXm().length() > 0)
				c.add(Restrictions.like("xm",w.getXm(),MatchMode.ANYWHERE));
			if(w.getPid() != null)
				c.add(Restrictions.eq("pid",w.getPid()));
			if(w.getSfwc() != null && w.getSfwc().length() > 0)
				c.add(Restrictions.eq("sfwc",w.getSfwc()));
			if(w.getContent() != null && w.getContent().length() > 0)
				c.add(Restrictions.like("content",w.getContent(),MatchMode.ANYWHERE));
			if(w.getStatus() != null && w.getStatus().length() > 0)
				c.add(Restrictions.eq("status",w.getStatus()));
			if(w.getSfzy()!=null && w.getSfzy().length()>0){
				c.add(Restrictions.like("sfzy", w.getSfzy()));
			}
			if(w.getType() != null && w.getType().length() > 0)
				c.add(Restrictions.eq("type",w.getType()));
			else
				c.add(Restrictions.in("type","计划,日志".split(",")));
			if(StringUtils.isNotEmpty(startDate)){
				c.add(Restrictions.ge("createDate", DateUtil.parse(startDate, DateUtil.DEFAULT_DATE_FORMAT)));
			}
			if(StringUtils.isNotEmpty(endDate)){
				c.add(Restrictions.le("createDate", DateUtil.parse(endDate, DateUtil.DEFAULT_DATE_FORMAT)));
			}
			if(StringUtils.isNotEmpty(xrsjst)){
				c.add(Restrictions.ge("xrsj",DateUtil.parse(xrsjst, DateUtil.DEFAULT_DATE_FORMAT) ));
			}
			if(StringUtils.isNotEmpty(xrsjend)){
				c.add(Restrictions.le("xrsj", DateUtil.parse(xrsjend, DateUtil.DEFAULT_DATE_FORMAT)));
			}
		}
//		c.addOrder(Order.desc("createDate"));
//		c.addOrder(Order.desc("xrsj"));
		return c;
	}
	
	private Criteria decoratorObj(Workdaily w,Date startDate,Date endDate){
		Criteria c = getSession().createCriteria(w.getClass());
		if(w != null){
			if(w.getSfzh() != null && w.getSfzh().length() > 0)
				c.add(Restrictions.eq("sfzh",w.getSfzh()));
			if(w.getSfwc() != null && w.getSfwc().length() > 0)
				c.add(Restrictions.eq("sfwc",w.getSfwc()));
			if(w.getContent() != null && w.getContent().length() > 0)
				c.add(Restrictions.like("content",w.getContent(),MatchMode.ANYWHERE));
			if(w.getStatus() != null && w.getStatus().length() > 0)
				c.add(Restrictions.eq("status",w.getStatus()));
			if(w.getType() != null && w.getType().length() > 0)
				c.add(Restrictions.eq("type",w.getType()));
			c.add(Restrictions.between("createDate",startDate,endDate));
		}
		return c;
	}	

	@Override
	public List<Workdaily> queryCalendarEvents(Workdaily daily, Date startDate,
			Date endDate) {
		Criteria c =decoratorObj(daily,startDate,endDate);
		return c.list();
	}

	@Override
	public Long queryEventCount(Workdaily re, Date startDate, Date endDate) {
		Criteria criteria =decoratorObj(re,startDate,endDate);
		ProjectionList project = Projections.projectionList();
		project.add(Projections.property("id"));
		criteria.setProjection(project);
		return this.getCount(criteria);
	}

	@Override
	public List<Workdaily> queryList(Workdaily w, int s, Integer size,
			String st, String ed, String xrsjst, String xrsjend) {
		Criteria c = buildCondition(w,st,ed,xrsjst,xrsjend);
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}
}

