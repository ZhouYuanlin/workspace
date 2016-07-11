package cn.uuf.support.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;

import cn.uuf.domain.Account;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date May 10, 2013
 */
public interface HibernateDao<T,ID> {

	public List<T> find();
	
	/**
	 * 保存实体类
	 * @param entity
	 */
	public void save(T entity);
	
	/**
	 * 修改实体
	 * @param entity
	 */
	public void update(T entity);
	
	/**
	 * 根据实体类删除
	 * @param entity
	 */
	public void delete(T entity);
	
	/**
	 * 根据主键删除实体
	 * @param id
	 */
	public void delete(ID... id);
	
	/**
	 * 根据sql语句删除
	 * @param sql
	 */
	public void delete(String sql);
	
	/**
	 * 根据主键查找实体
	 * @param id
	 * @return
	 */
	public T getById(ID id);
	
	public Object findUniqueBy(Class<?> entityClass,String propertyName,Object value);
	
	public List<T> findByHQL(String hql);
	
	public List findBySQL(String sql);
	
	/**
	 * 多条件查询，可以把查询条件和排序写在Dao中
	 */
	public List<T> queryByPage(Criteria criteria);
	
	/**
	 * 取得总体数，可传查询条件
	 * @param sql
	 * @param obj
	 * @return
	 */
	public Long getCount(Criteria criteria);
	
	public List<T> findWithWhere(String where);
	
	public Account getCurrentUser();
	
	public boolean hasRole(String name);
}

