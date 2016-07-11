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
import cn.uuf.domain.life.DocGrp;
import cn.uuf.domain.life.Photo;
import cn.uuf.ltxxt.life.service.GroupService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 类说明	：
 */
@Service
public class GroupServiceImpl extends HibernateDaoSupport<DocGrp, Long> implements GroupService{
	@SuppressWarnings("unchecked")
	
	public List<DocGrp> getAll() throws Exception {
		Criteria  c = this.getSession().createCriteria(this.getEntityClass()).addOrder(Order.desc("id"))
		.add(Restrictions.eq("type", Constants.PICTURES));
		List<DocGrp> list = c.list();
		for(int i = 0 ; i< list.size(); i++){
			Hibernate.initialize(list.get(i).getPh());
		}
		return c.list();
	}
	

	@Override
	public DocGrp getById(Long id){
		DocGrp a = (DocGrp) this.getSession().get(this.getEntityClass(), id);
		if(a.getPhoto()!=null){
			Hibernate.initialize(a.getPhoto());
		}
		if(a.getArticle() !=null){
			Hibernate.initialize(a.getArticle());
		}
		if(a.getVideo() !=null){
			Hibernate.initialize(a.getVideo());
		}
		return a;
	}

	
	public Long getCount(DocGrp a) {
		Criteria c = buildCriteriaByEntity(a);
		ProjectionList project = Projections.projectionList();
		project.add(Projections.property("id"));
		c.setProjection(project);
		return getCount(c);
	}

	
	public List<DocGrp> queryByPage(DocGrp a, int start, int size) {
		Criteria c = buildCriteriaByEntity(a);
		c.setFirstResult(start).setMaxResults(size);
		List<DocGrp> list = this.queryByPage(c);
		for(int i = 0 ; i< list.size(); i++){
			Photo p = list.get(i).getPh();
			Hibernate.initialize(p);
		}
		return list;
	}
	private Criteria buildCriteriaByEntity(DocGrp p){
		Criteria criteria = getSession().createCriteria(p.getClass());
		if(p!=null){
			if(p.getName()!=null && p.getName().trim().length()>0){
				criteria.add(Restrictions.like("title", p.getName(),MatchMode.ANYWHERE));
			}
			if(p.getType()!=null && p.getType().trim().length()>0){
				criteria.add(Restrictions.eq("type", p.getType()));
			}
		}
		criteria.addOrder(Order.desc("id"));
		return criteria;
	}

	@Override
	public List<DocGrp> queryList(DocGrp a, int s, int size) {
		Criteria c = getSession().createCriteria(a.getClass());
		if(a!=null){
			if(a.getParent()!=null){
				c.add(Restrictions.eq("id", a.getParent().getId()));
			}else{
				c.add(Restrictions.eq("id", null));
			}
		}
		c.setFirstResult(s).setMaxResults(size);
		return c.list();
	}

}
