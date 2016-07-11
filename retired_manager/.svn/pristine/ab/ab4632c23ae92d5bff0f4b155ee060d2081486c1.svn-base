package cn.uuf.support.dao.hibernate.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.uuf.domain.Account;
import cn.uuf.domain.Role;
import cn.uuf.support.dao.hibernate.HibernateDao;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date May 10, 2013
 */
public class HibernateDaoSupport<T,ID extends Serializable> implements HibernateDao<T,ID> {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public Account getCurrentUser(){
		Subject subject = SecurityUtils.getSubject();
		return (Account)subject.getPrincipal();
	}
	
	public boolean hasRole(String name){
		boolean roles = false;
		Subject subject = SecurityUtils.getSubject();
		if(subject.hasRole(name))
			roles = true;
		return roles;
	}
	
	/**
	 * 取得当前用户拥有的角色可访问的学生信息
	 * @return
	 */
	public String hasRoleScope(){
		Account account = getCurrentUser();
		try{
			if(account != null){
				List<Role> r = account.getRoles();
				return r.get(0).getScope();
			}
		}catch(Exception e){
			return null;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	protected Class<T> getEntityClass(){
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	protected String getEntityName(){
		return getEntityClass().getSimpleName();
	}
	
	@Override
	public void delete(T entity) {
		this.getSession().delete(entity);
	}
	
	@Override
	public void delete(ID... ids) {
		for(ID id : ids)
			getSession().delete(this.getById(id));
	}
	
	@Override
	public void delete(String sql) {
		getSession().createQuery(sql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find() {
		Criteria c = getSession().createCriteria(this.getEntityClass());
		c.setCacheable(true);
		return c.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHQL(String hql) {
		Query query = getSession().createQuery(hql);
		query.setCacheable(true);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List findBySQL(String sql) {
		Query query = getSession().createSQLQuery(sql);
		return query.list();
	}
	
	/**
	 * 多条件查询，可以把查询条件和排序写在Dao中
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryByPage(Criteria criteria){
		return criteria.list();
	}
	
	@Override
	public Long getCount(Criteria criteria){
		return criteria.list().size() + 0l;
	}

	@Override
	public Object findUniqueBy(Class<?> entityClass, String propertyName,
			Object value) {
		Criteria criteria = getSession().createCriteria(entityClass);
		criteria.add(Restrictions.eq(propertyName, value));
		criteria.setCacheable(true);
		return criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findWithWhere(String where) {
		return getSession().createCriteria(buildHQLByClass(this.getEntityClass())+ " where" + where).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(ID id) {
		return (T)getSession().get(this.getEntityClass(),id);
	}

	@Override
	public void save(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void update(T entity) {
		getSession().clear();
		getSession().update(entity);
	}
	
	public void saveOrUpdate(T entity){
		getSession().saveOrUpdate(entity);
	}
	
	public static String buildHQLByClass(Class<?> clazz){
		return "from " + clazz.getSimpleName() + " t";
	}
	
	public static String removeSelect(String str){
		int ps = str.toLowerCase().indexOf("from");
		if(ps != -1)
			str = str.substring(ps);
		return str;
	}
}

