package cn.uuf.ltxxt.life.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.contants.Constants;
import cn.uuf.domain.life.Video;
import cn.uuf.ltxxt.life.service.VideosService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 类说明	：
 */
@Service
public class VideosServiceImpl extends HibernateDaoSupport<Video, Long> implements VideosService{

	@SuppressWarnings("unchecked")
	public List<Video> getAll() throws Exception {
		Criteria  c = this.getSession().createCriteria(this.getEntityClass());
		return c.list();
	}
	
	public Long getCount(Video a) {
		Criteria c = buildCriteriaByEntity(a);
		ProjectionList project = Projections.projectionList();
		project.add(Projections.property("id"));
		c.setProjection(project);
		return getCount(c);
	}

	
	public List<Video> queryByPage(Video a, int start, int size) {
		Criteria c = buildCriteriaByEntity(a);
		c.setFirstResult(start).setMaxResults(size);
		return c.list();
	}
	private Criteria buildCriteriaByEntity(Video p){
		Criteria criteria = getSession().createCriteria(p.getClass());
		if(p!=null){
			if(p.getTitle()!=null && p.getTitle().trim().length()>0){
				criteria.add(Restrictions.like("title", p.getTitle(),MatchMode.ANYWHERE));
			}
			if(p.getStatus()!=null && p.getStatus().trim().length()>0){
				criteria.add(Restrictions.eq("status", p.getStatus()));
			}
		}
		criteria.addOrder(Order.desc("id"));
		return criteria;
	}

	@SuppressWarnings("unchecked")
	public List<Video> getNoAppr() {
		Criteria  c = this.getSession().createCriteria(this.getEntityClass())
		//.add(Restrictions.not(Restrictions.eq("status", Constants.APP_PASS)))
		.addOrder(Order.desc("id"));
		return c.list();
	}

}
