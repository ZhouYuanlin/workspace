package cn.uuf.ltxxt.folder.service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import cn.uuf.domain.Folder;
import cn.uuf.ltxxt.folder.service.FolderService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-08
 */
@Service
public class FolderServiceImpl extends HibernateDaoSupport<Folder, Long> implements FolderService{

	@SuppressWarnings("unchecked")
	
	public List<Folder> getAll() throws Exception {
		Criteria c = this.getSession().createCriteria(this.getEntityClass());
		return c.list();
	}
	
	public Long getCount(Folder r) {
		Criteria criteria = buildCriteriaByEntity(r);
		ProjectionList project = Projections.projectionList();
		project.add(Projections.property("id"));
		criteria.setProjection(project);
		return getCount(criteria);
	}

	
	public List<Folder> queryByPage(Folder r, int start,int size) {
		Criteria c = buildCriteriaByEntity(r);
		c.setFirstResult(start).setMaxResults(size);
		List<Folder> list = this.queryByPage(c);
		for(int i = 0;i<list.size();i++){
			Hibernate.initialize(list.get(i).getChildren());
			Hibernate.initialize(list.get(i).getUser());
		}
		return list;
	}
	private Criteria buildCriteriaByEntity(Folder r){
		Criteria criteria = getSession().createCriteria(r.getClass());
		if(r.getParent() != null){
			criteria.add(Restrictions.eq("parent", r.getParent()));
		}else{
			criteria.add(Restrictions.isNull("parent"));
		}
		
		if(r.getType() != null){
			criteria.add(Restrictions.eq("type", r.getType()));
		}
		if(r.getStatus() !=null){
			criteria.add(Restrictions.eq("status", r.getStatus()));
		}
		if(r.getFileType() !=null){
			criteria.add(Restrictions.eq("fileType", r.getFileType()));
		}
		if(r.getUser() !=null){
			criteria.add(Restrictions.eq("user", r.getUser()));
		}
		if(r.getShares() !=null){
			criteria.add(Restrictions.eq("shares", r.getShares()));
		}
		criteria.addOrder(Order.desc("createDate"));
		return criteria;
	}

	public void deleteByParentId(String parentId) {
		String sql = "delete from re_folder t where t.parent_id = ?";
		SQLQuery query = (SQLQuery) this.getSession().createSQLQuery(sql);
		query.setParameter(0, parentId);
		query.executeUpdate();
	}

	public List<Folder> getUserList(Folder folder, int start, int size) {
		String sql = "select *\n" +
					"  from re_folder t\n" + 
					" where t.user_id != ?\n" + 
					"   and t.status = '公开'\n" + 
					"   and t.filetype = ?\n" + 
					"   and t.parent_id is null\n" + 
					" order by t.user_id desc";
		SQLQuery query = (SQLQuery) this.getSession().createSQLQuery(sql).addEntity(Folder.class);
		query.setParameter(0, folder.getUser().getSfzh());
		query.setParameter(1, folder.getFileType());
		query.setFirstResult(start);
		query.setMaxResults(size);
		List<Folder> list = query.list();
		for(int i = 0;i<list.size();i++){
		Hibernate.initialize(list.get(i).getChildren());
		Hibernate.initialize(list.get(i).getUser());
		}
		return list;
	}

	@Override
	public void updateSql(String sql) {
		SQLQuery query = (SQLQuery) this.getSession().createSQLQuery(sql);
		query.executeUpdate();
	}
	/**
	 * 首页提取文档用，固化好的几个提取出来。
	 * "19103,19104,19105,19106";//这些文不允许删除
	 */
	@Override
	public List<Folder> queryByHql() {
		String hql = "from Folder where id in (19103,19104,19105,19106) order by createDate desc";
		Query q = getSession().createQuery(hql);
		List<Folder> list = q.list();
		for(int i = 0;i<list.size();i++){
			Hibernate.initialize(list.get(i).getChildren());
			Hibernate.initialize(list.get(i).getUser());
		}
		return list;
	}

}
