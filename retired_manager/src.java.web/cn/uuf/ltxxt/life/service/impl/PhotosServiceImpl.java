package cn.uuf.ltxxt.life.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.contants.Constants;
import cn.uuf.domain.life.Photo;
import cn.uuf.ltxxt.life.service.PhotosService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 类说明	：
 */
@Service
public class PhotosServiceImpl  extends HibernateDaoSupport<Photo, Long> implements PhotosService{

	@SuppressWarnings("unchecked")
	public List<Photo> getAll() throws Exception {
		Criteria  c = this.getSession().createCriteria(this.getEntityClass())
		.addOrder(Order.desc("id"));
		List<Photo> list = c.list();
		for(int i = 0; i< list.size();i++){
			Hibernate.initialize(list.get(i).getGrp());
		}
		return list;
	}
	
	public Long getCount(Photo p) {
		Criteria c = buildCriteriaByEntity(p);
		ProjectionList project = Projections.projectionList();
		project.add(Projections.property("id"));
		c.setProjection(project);
		return getCount(c);
	}

	
	public List<Photo> queryByPage(Photo p, int start, int size) {
		Criteria c = buildCriteriaByEntity(p);
		c.setFirstResult(start).setMaxResults(size);
		List<Photo> list = this.queryByPage(c);
		for(int i = 0 ;i < list.size(); i++){
			list.get(i).getGrp().getZjh();
		}
		return list;
	}

	private Criteria buildCriteriaByEntity(Photo p){
		Criteria criteria = getSession().createCriteria(p.getClass());
		if(p!=null){
			if(p.getTitle()!=null && p.getTitle().trim().length()>0){
				criteria.add(Restrictions.like("title", p.getTitle(),MatchMode.ANYWHERE));
			}
			if(p.getGrp()!=null){
				criteria.add(Restrictions.eq("grp", p.getGrp()));
			}
			if(p.getStatus()!=null && p.getStatus().trim().length()>0){
				criteria.add(Restrictions.eq("status", p.getStatus()));
			}
		}
		criteria.addOrder(Order.desc("cdate"));
		
		return criteria;
	}
	
	public Photo queryBySql(String sql) {
		Photo p = (Photo) this.getSession().createSQLQuery(sql).addEntity(Photo.class).uniqueResult();
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Photo> getNoAppr() {
		Criteria  c = this.getSession().createCriteria(this.getEntityClass())
		.add(Restrictions.not(Restrictions.eq("status", Constants.DEFAULTCOLOR)))
		.addOrder(Order.asc("id"));
		List<Photo> list = c.list();
		for(int i = 0; i< list.size();i++){
			Hibernate.initialize(list.get(i).getGrp());
		}
		return list;
	}

}
