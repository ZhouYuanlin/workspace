package cn.uuf.ltxxt.life.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.life.Article;
import cn.uuf.ltxxt.life.service.ArticlesService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 类说明	：
 */
@Service
public class ArticlesServiceImpl extends HibernateDaoSupport<Article, Long> implements ArticlesService{

	@SuppressWarnings("unchecked")
	public List<Article> getAll() throws Exception {
		Criteria  c = this.getSession().createCriteria(this.getEntityClass());
		return c.list();
	}

	public Long getCount(Article a) {
		Criteria c = buildCriteriaByEntity(a);
		ProjectionList project = Projections.projectionList();
		project.add(Projections.property("id"));
		c.setProjection(project);
		return getCount(c);
	}

	
	@SuppressWarnings("unchecked")
	public List<Article> queryByPage(Article a, int start, int size) {
		Criteria c = buildCriteriaByEntity(a);
		c.setFirstResult(start).setMaxResults(size);
		return c.list();
	}

	private Criteria buildCriteriaByEntity(Article p){
		Criteria criteria = getSession().createCriteria(p.getClass());
		if(p!=null){
			if(p.getTitle()!=null && p.getTitle().trim().length()>0){
				criteria.add(Restrictions.like("title", p.getTitle(),MatchMode.ANYWHERE));
			}
			if(p.getStatus()!=null && p.getStatus().trim().length()>0){
				criteria.add(Restrictions.eq("status", p.getStatus()));
			}
		}
		criteria.addOrder(Order.desc("cdate")).addOrder(Order.asc("title"));
		return criteria;
	}

}
