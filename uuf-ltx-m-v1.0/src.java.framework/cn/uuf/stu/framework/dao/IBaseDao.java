package cn.uuf.stu.framework.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.LockOptions;

import cn.uuf.stu.framework.common.Filter;
import cn.uuf.stu.framework.common.HiParameter;
import cn.uuf.stu.framework.common.Order;
import cn.uuf.stu.framework.common.Page;
import cn.uuf.stu.framework.common.Pageable;



/**
* 基类
* @ClassName: BaseDao 
* @author tangpeng
* @date 2015年7月27日 上午10:57:01 
* 
* @param <T>
* @param <ID>
*/
public interface IBaseDao<T,ID extends Serializable> {
	
	/**
	* 查找实体对象 支持延迟加载策略
	* @param @param id 
	* @param @return    
	* @return 返回实体对象，若不存在返回异常     
	*/
	T load(ID id);
	
	/**
	* 查找所有
	* @return    
	* List<T>
	*/
	List<T> getAll();
	
	/**
	* 查找所有按属性名排序
	* @param propertyNames
	* @return    
	* List<T>
	 */
	List<T> getAll(String ... propertyNames);
	
	/**
	* 查找实体对象 立即加载
	* @param id
	* @return 返回实体对象，若不存在返回null   
	* T
	*/
	T get(ID id);
	
	/**
	* 查询加锁
	* @param id
	* @param lockOptions
	* @return    
	* T
	 */
	T get(ID id,LockOptions lockOptions);
	
	/**
	* 持久化实体对象
	* @param entity  
	* 			实体对象  
	* @return void     
	*/
	void save(T entity);
	
	/**
	* 持久化实体支持ejb规范
	* @param entity    
	* void
	*/
	void persist(T entity);
	
	/**
	 * 合并实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象
	 */
	void merge(T entity);
	
	/**
	 * 更新实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象
	 */
	void update(T entity);
	
	/**
	 * 保存更新实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象
	 */
	void saveOrUpdate(T entity);
	
	/**
	 * 获取实体对象ID
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象ID
	 */
	ID getIdentifier(T entity);
	
	/**
	* 删除实体
	* @param entity    
	* void
	*/
	void delete(T entity);
	/**
	 * 根据sql执行
	 * @param sql
	 */
	void executeSQL(String sql);
	/**
	 * 根据HQL执行
	 * @param sql
	 */
	void executeHQL(String sql);
	
	/**
	* 获得唯一实体对象
	* @return    
	* T 实体对象
	 */
	T getUniqueEntity(String propertyName,Object propertyValue);
	
	/**
	* 获得条数
	* @param propertyName 属性名
	* @param propertyValue 属性值
	* @return    
	* 条数
	 */
	Long count(String propertyName,Object propertyValue);
	
	/**
	 * 获得条数
	 * @param sql
	 * @param parameters
	 * @return
	 */
	Long count(String sql,List<HiParameter> parameters);
	
	/**
	* 获得分页对象集
	* @param pageable
	* @return    
	* List<Page<T>>
	 */
	Page<T> getPage(Pageable pageable);
	
	/**
	 * 
	 * @param pageable
	 * @return
	 */
	Page<T> getHqlPage(Pageable pageable);
	
	
	/**
	 * 获得list集
	 * @param pageable
	 * @return
	 */
	Page<T> getSqlPage(Pageable pageable);

	/**
	 * 获得list集
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	List<T> getList(String propertyName, Object propertyValue);
	
	/**
	 * 获得list集
	 * @param filters
	 * @return
	 */
	List<T> getList(List<Filter> filters,String orderFieldName);
	
	/**
	 * 获得list集
	 * @param filters
	 * @param orders
	 * @return
	 */
	List<T> getList(List<Filter> filters,List<Order> orders);
	
	/**
	 * 获得list集
	 * @param sql
	 * @param parameters
	 * @return
	 */
	List<T> getList(String sql,List<HiParameter> parameters);
	
	/**
	 * 获得list集
	 * @param hql
	 * @param parameters
	 * @return
	 */
	List<T> getHqlList(String hql,List<HiParameter> parameters);
	
	List getListByHql(String hql,List<HiParameter> parameters);
	
	List getStringList(String sql);
	
	Object executeSQL(String sql,List<HiParameter> parameters);
	
	
}
