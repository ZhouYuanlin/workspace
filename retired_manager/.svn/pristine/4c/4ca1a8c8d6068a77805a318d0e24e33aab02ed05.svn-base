package cn.uuf.ltxxt.system.permission.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Resource;
import cn.uuf.domain.Role;
import cn.uuf.ltxxt.system.permission.service.ResourceService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-19
 */
@SuppressWarnings("unchecked")
@Service("resourceService")
public class ResourceServiceImpl extends HibernateDaoSupport<Resource,Long> implements ResourceService{
	
	protected Log logger = LogFactory.getLog(this.getClass());

	@Override
	public List<Resource> getAll() throws Exception {
		Criteria c = getSession().createCriteria(this.getEntityClass());
		c.addOrder(Order.asc("code"));
		return c.list();
	}

	@Override
	public Resource getById(Long id) {
		Resource r = (Resource) getSession().get(this.getEntityClass(),id);
		if(r != null){
			Hibernate.initialize(r.getParent());
			Hibernate.initialize(r.getChildren());
			for(Resource re : r.getChildren()){
				Hibernate.initialize(re.getParent());
				Hibernate.initialize(re.getChildren());
				if(re.getChildren()!=null && re.getChildren().size() > 0){
					for(Resource s : re.getChildren()){
						Hibernate.initialize(s.getParent());
						Hibernate.initialize(s.getChildren());
					}
				}
			}
		}
		return r;
	}

	@Override
	public List<Resource> queryList(Resource resource, int start, int size) {
		return this.queryByPage(buildCriteria(resource,start,size));
	}

	@Override
	public Long getCount(Resource rs) {
		Criteria criteria = getSession().createCriteria(rs.getClass());
		//可加查询条件
		if(rs != null){
			if(rs.getName()!=null && rs.getName().length()>0)
				criteria.add(Restrictions.like("name", rs.getName(),MatchMode.ANYWHERE));
			if(rs.getCode()!=null && rs.getCode().length()>0)
				criteria.add(Restrictions.like("code", rs.getCode(),MatchMode.ANYWHERE));
			
			//加上查询的条件
		}
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}

	@Override
	public Resource querybyVo(Resource vo) {
		Criteria c = getSession().createCriteria(this.getEntityClass());
		if (vo!=null) {
			if (vo.getAction()!=null && vo.getAction().length()>0) {
				c.add(Restrictions.eq("action", vo.getAction()));
			}else if (vo.getCode()!=null && vo.getCode().length()>0) {
				c.add(Restrictions.eq("code", vo.getCode()));
			}
		}
		List<Resource> ls=c.list();
		if (ls!=null && ls.size()>0) {
			return ls.get(0);
		}
		return null;
	}
	
	private Criteria buildCriteria(Resource rs,int start,int size){
		Criteria criteria = getSession().createCriteria(rs.getClass());
		if(rs != null){
			if(rs.getName()!=null && rs.getName().length()>0)
				criteria.add(Restrictions.like("name", rs.getName(),MatchMode.ANYWHERE));
			if(rs.getCode()!=null && rs.getCode().length()>0)
				criteria.add(Restrictions.like("code", rs.getCode(),MatchMode.ANYWHERE));
			
			//加上查询的条件
		}
		criteria.setFirstResult(start).setMaxResults(size);
		criteria.addOrder(Order.asc("sort"));
		return criteria;
	}

	@Override
	public List<Resource> queryByParent() {
		Criteria c = getSession().createCriteria(Resource.class);
		c.add(Restrictions.isNull("parent"));
		c.addOrder(Order.asc("sort"));
		return this.queryByPage(c);
	}

	@Override
	public void excuteSql(String sql) throws Exception {
		SQLQuery query = getSession().createSQLQuery(sql);
		query.executeUpdate();
	}
}



