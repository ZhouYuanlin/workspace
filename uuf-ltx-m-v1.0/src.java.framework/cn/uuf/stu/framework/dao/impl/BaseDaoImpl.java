package cn.uuf.stu.framework.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.Assert;

import cn.uuf.stu.framework.common.Filter;
import cn.uuf.stu.framework.common.HiParameter;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;
import cn.uuf.stu.framework.dao.IBaseDao;

/**
* 基类 
* @ClassName: BaseDaoImpl 
* @author tangpeng
* @date 2015年7月27日 上午10:56:31 
* 
* @param <T>
* @param <ID>
*/
@SuppressWarnings({"unchecked"})
public abstract class BaseDaoImpl<T,ID extends Serializable> implements IBaseDao<T, ID> {

	/** 实体类类型*/
	private Class<T> entityClass;
	
	public BaseDaoImpl() {
		Type type = this.getClass().getGenericSuperclass();
		Type[] parameterizedType = ((ParameterizedType)type).getActualTypeArguments();
		entityClass = (Class<T>) parameterizedType[0];
	}
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	* 得到当前线程session
	* @return    
	* 	Session
	*/
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public T load(ID id) {
		return (T) this.getSession().load(entityClass, id);
	}

	@Override
	public List<T> getAll() {
		return this.getSession().createCriteria(entityClass).list();
	}

	@Override
	public List<T> getAll(String... propertyNames) {
		Criteria criteria = this.getSession().createCriteria(entityClass);
		for (String propertyName : propertyNames) {
			criteria.addOrder(Order.asc(propertyName));
		}
		criteria.setCacheable(true);
		return criteria.list();
	}

	@Override
	public void save(T entity) {
		this.getSession().saveOrUpdate(entity);
	}
	
	@Override
	public T get(ID id) {
		return (T) this.getSession().get(entityClass, id);
	}
	
	@Override
	public T get(ID id, LockOptions lockOptions) {
		return (T) this.getSession().get(entityClass, id, lockOptions);
	}

	@Override
	public void persist(T entity) {
		this.getSession().save(entity);
	}

	@Override
	public void merge(T entity) {
		this.getSession().merge(entity);
	}

	@Override
	public void update(T entity) {
		this.getSession().update(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		this.getSession().saveOrUpdate(entity);
	}
	@Override
	public void executeSQL(String sql){
		this.getSession().createSQLQuery(sql).executeUpdate();
	}
	@Override
	public void executeHQL(String hql){
		this.getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public ID getIdentifier(T entity) {
		Assert.notNull(entity);
		return (ID) this.getSession().getIdentifier(entity);
	}

	@Override
	public void delete(T entity) {
		this.getSession().delete(entity);
	}

	@Override
	public T getUniqueEntity(String propertyName, Object propertyValue) {
		Criteria criteria = this.getSession().createCriteria(entityClass);
		criteria.setCacheable(true);
		List<T> list = criteria.add(Restrictions.eq(propertyName, propertyValue)).list();
		return list.size()>0?(T)list.get(0):null;
	}

	@Override
	public Long count(String propertyName, Object propertyValue) {
		Criteria criteria = this.getSession().createCriteria(entityClass);
		criteria.setProjection(Projections.count(propertyName))
		.add(Restrictions.eq(propertyName, propertyValue));
		List<Object> list = criteria.list();
		return new Long(list.get(0).toString());
	}

	@Override
	public Page<T> getPage(Pageable pageable) {
		Criteria criteria = this.getSession().createCriteria(entityClass);
		addRestrictions(criteria,pageable); 
		addOrders(criteria,pageable);      
		return getPage(pageable, criteria);
	}
	
	/**
	 * 分页
	 * @param pageable
	 * @param criteria
	 * @return
	 */
	protected Page<T> getPage(Pageable pageable, Criteria criteria) {
		long total =  (Long) addRestrictions(this.getSession().createCriteria(entityClass),pageable).setProjection(Projections.rowCount()).uniqueResult();
		if(total>pageable.getPageSize()){
			criteria.setFirstResult((pageable.getPageNumber() - 1) * pageable.getPageSize());
			criteria.setMaxResults(pageable.getPageSize());
		}
		List list = criteria.list();
		return getPage(pageable, total, list);
	}

	/**
	 * 分页
	 * @param pageable
	 * @param total
	 * @param list
	 * @return
	 */
	private Page<T> getPage(Pageable pageable, long total, List list) {
		int totalPages = (int) Math.ceil((double) total / (double) pageable.getPageSize());
		if (totalPages < pageable.getPageNumber()) {
			pageable.setPageNumber(totalPages);
		}
		Page<T> page = new Page<T>(list,total,pageable);
		page.setPageNumber(pageable.getPageNumber());
		page.setPreviousPageNumber(pageable.getPageNumber()-1);
		page.setNextPageNumber(pageable.getPageNumber()+1);
		page.setTotalPages((int) Math.ceil((double) total / (double) pageable.getPageSize()));
		return page;
	}
	

	/**
	* 添加排序条件
	* @param criteria
	* @param pageable    
	* void
	 */
	public void addOrders(Criteria criteria, Pageable pageable) {
		List<cn.uuf.stu.framework.common.Order> orders = pageable.getOrders();
		addOrders(criteria, orders);
	}
	
	/**
	 * 添加排序条件
	 * @param criteria
	 * @param orders
	 */
	private void addOrders(Criteria criteria,
			List<cn.uuf.stu.framework.common.Order> orders) {
		for (cn.uuf.stu.framework.common.Order order : orders) {
			if(order.getDirection()==cn.uuf.stu.framework.common.Order.Direction.asc){
				criteria.addOrder(Order.asc(order.getProperty()));
			}else{
				criteria.addOrder(Order.desc(order.getProperty()));
			}
		}
	}

	/**
	* 添加过滤条件 
	* @param criteria
	* @param pageable    
	* void
	 */
	public Criteria addRestrictions(Criteria criteria, Pageable pageable) {
		List<Filter> filters = pageable.getFilters();
		return addCriteria(criteria, filters);
	}

	private Criteria addCriteria(Criteria criteria, List<Filter> filters) {
		for (Filter filter : filters) {
			if (filter == null || StringUtils.isEmpty(filter.getProperty())) {
				continue;
			}
			if (filter.getOperator()==Filter.Operator.eq&&filter.getOperator()!=null){
				criteria.add(Restrictions.eq(filter.getProperty(), filter.getValue()));
			}
			if(filter.getOperator()==Filter.Operator.le&&filter.getOperator()!=null){
				criteria.add(Restrictions.le(filter.getProperty(), filter.getValue()));
			}
			if(filter.getOperator()==Filter.Operator.ge&&filter.getOperator()!=null){
				criteria.add(Restrictions.ge(filter.getProperty(), filter.getValue()));
			}
			if(filter.getOperator()==Filter.Operator.like&&filter.getOperator()!=null){
				criteria.add(Restrictions.like(filter.getProperty(), filter.getValue()));
			}
			if(filter.getOperator() == Filter.Operator.sqlRestriction && filter.getOperator() != null){
				criteria.add(Restrictions.sqlRestriction(filter.getValue().toString()));
			}
			if(filter.getOperator() == Filter.Operator.in &&filter.getOperator() != null){
				criteria.add(Restrictions.in(filter.getProperty(),(Collection)filter.getValue()));
			}
		}
		return criteria;
	}

	@Override
	public List<T> getList(String propertyName, Object propertyValue) {
		Criteria criteria = this.getSession().createCriteria(entityClass);
		criteria.setCacheable(true);
		criteria.addOrder(Order.asc("id"));
		List<T> list = criteria.add(Restrictions.eq(propertyName, propertyValue)).list();
		return list;
	}
	
	@Override
	public List<T> getList(List<Filter> filters,String orderFieldName) {
		Criteria criteria = this.getSession().createCriteria(entityClass);
		addCriteria(criteria,filters);
		criteria.addOrder(Order.asc(orderFieldName));
		return criteria.list();
	}

	
	@Override
	public List<T> getList(List<Filter> filters,
			List<cn.uuf.stu.framework.common.Order> orders) {
		Criteria criteria = this.getSession().createCriteria(entityClass);
		addCriteria(criteria,filters);
		addOrders(criteria, orders);
		return criteria.list();
	}
	
	/**
	 * hql 分页
	 */
	@Override
	public Page<T> getHqlPage(Pageable pageable) {
		Long total = getHqlTotal(pageable);
		List<T> list = getHqlList(pageable,total);
		return getPage(pageable,total,list);
	}

	public List<T> getHqlList(Pageable pageable,long total) {
		Query query = this.getSession().createQuery(pageable.getQueryListStr());
		setParam(pageable, query);
		if(total>pageable.getPageSize()){
			query.setFirstResult((pageable.getPageNumber() - 1) * pageable.getPageSize());
			query.setMaxResults(pageable.getPageSize());
		}
		List list = query.list();
		return list;
	}

	private Long getHqlTotal(Pageable pageable) {
		Query queryTotal = this.getSession().createQuery(pageable.getQueryCountStr());
		setParam(pageable, queryTotal);
		Long total = Long.parseLong(queryTotal.uniqueResult().toString());
		return total;
	}
	
	private void setParam(Pageable pageable, Query query) {
		List<HiParameter> params = pageable.getParams();
		setParam(query, params);
	}

	public void setParam(Query query, List<HiParameter> params) {
		for (HiParameter parameter : params) {
			query.setParameter(parameter.getFiledName(), 
			parameter.getFiledValue(),parameter.getFiledType());
		}
	}
	
	public List getStringList(String sql){
		SQLQuery query = getSession().createSQLQuery(sql);
		return query.list();
	}
	/**
	 * SQL 分页
	 */
	@Override
	public Page<T> getSqlPage(Pageable pageable) {
		Long total = getSqlTotal(pageable);
		List<T> list = getSqlList(pageable,total);
		return getPage(pageable,total,list);
	}
	
	public List<T> getSqlList(Pageable pageable,long total) {
		SQLQuery query = this.getSession().createSQLQuery(pageable.getQueryListStr());
		setParam(pageable, query);
		if(total>pageable.getPageSize()){
			query.setFirstResult((pageable.getPageNumber() - 1) * pageable.getPageSize());
			query.setMaxResults(pageable.getPageSize());
		}
		query.addEntity(entityClass);
		return query.list();
	}
	
	public Long getSqlTotal(Pageable pageable) {
		SQLQuery query = this.getSession().createSQLQuery(pageable.getQueryCountStr());
		setParam(pageable, query);
		Long total = Long.parseLong(query.uniqueResult().toString());
		return total;
	}
	
	@Override
	public Long count(String sql, List<HiParameter> parameters) {
		Query query = this.getSession().createSQLQuery(sql);
		setParam(query, parameters);
		Long total = Long.parseLong(query.uniqueResult().toString());
		return total;
	}

	@Override
	public List<T> getList(String sql, List<HiParameter> parameters) {
		SQLQuery query = this.getSession().createSQLQuery(sql);
		setParam(query, parameters);
		query.addEntity(entityClass);
		return query.list();
	}

	@Override
	public Object executeSQL(String sql, List<HiParameter> parameters) {
		Query query = this.getSession().createSQLQuery(sql);
		if(CollectionUtils.isNotEmpty(parameters)){
			setParam(query, parameters);
		}
		Object object = query.uniqueResult();
		return object;
	}

	@Override
	public List<T> getHqlList(String hql, List<HiParameter> parameters) {
		Query query = this.getSession().createQuery(hql);
		setParam(query, parameters);
		return query.list();
	}

	@Override
	public List getListByHql(String hql, List<HiParameter> parameters) {
		Query query = this.getSession().createQuery(hql);
		setParam(query, parameters);
		return query.list();
	}
	
	
	
	
}
