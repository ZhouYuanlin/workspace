package cn.uuf.ltxxt.life.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Service;

import cn.uuf.domain.life.Goods;
import cn.uuf.ltxxt.life.service.GoodsService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * 类说明	：
 */
@Service("goodsService")
public class GoodsServiceImpl extends HibernateDaoSupport<Goods, Long> implements GoodsService{

	@SuppressWarnings("unchecked")
	
	public List<Goods> getAll() throws Exception {
		Criteria  c = this.getSession().createCriteria(this.getEntityClass());
		return c.list();
	}

	public Long getCount(Goods a) {
		Criteria c = buildCriteriaByEntity(a);
		ProjectionList project = Projections.projectionList();
		project.add(Projections.property("id"));
		c.setProjection(project);
		return getCount(c);
	}

	
	public List<Goods> queryByPage(Goods a, int start, int size) {
		Criteria c = buildCriteriaByEntity(a);
		List<Goods> list = this.queryByPage(c);
		return list;
	}
	private Criteria buildCriteriaByEntity(Goods p){
		Criteria criteria = getSession().createCriteria(p.getClass());
		criteria.addOrder(Order.desc("id"));
		return criteria;
	}

	
	public Goods queryBySql(String sql) {
		Goods g = (Goods) this.getSession().createSQLQuery(sql).addEntity(Goods.class).uniqueResult();
		return g;
	}
	
}
