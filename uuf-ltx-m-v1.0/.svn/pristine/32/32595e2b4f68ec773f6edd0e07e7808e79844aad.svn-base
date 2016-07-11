package cn.uuf.stu.framework.service;

import java.io.Serializable;
import java.util.List;

import cn.uuf.stu.framework.common.HiParameter;

/**
* 基类
* @ClassName: BaseService 
* @author tangpeng
* @date 2015年7月27日 上午11:26:38 
* 
* @param <T>
* @param <ID>
 */
public interface IBaseService<T,ID extends Serializable> {
	
	/**
	* 查找实体对象 支持延迟加载策略
	* @param @param id 
	* @param @return    
	* @return 返回实体对象，若不存在返回报异常
	*/
	T load(ID id);
	
	/**
	* 查找实体对象 支持延迟加载策略
	* @param @param id 
	* @param @return    
	* @return 返回实体对象，若不存在返回null
	*/
	T get(ID id);
	
	/**
	* 查找实体集
	* @param ids
	* @return    
	* 实体集
	*/
	List<T> getList(ID ...ids);
	
	/**
	 * 查找实体集
	 * @param propertyName
	 * @param propertyValue
	 * @return
	 */
	List<T> getList(String propertyName,Object propertyValue);
	
	/**
	* 获得唯一实体对象
	* @return    
	* T 实体对象
	 */
	T getUniqueEntity(String propertyName,Object propertyValue);
	
	/**
	* 获得条数
	* @param propertyName
	* @param propertyValue
	* @return    
	* 条数
	*/
	Long count(String propertyName,Object propertyValue);
	
	/**
	* 持久化实体对象
	* @param entity  
	* 			实体对象  
	* @return void     
	*/
	void save(T entity);
	
	/**
	 * 更新实体对象
	 * 
	 * @param entity
	 *            实体对象
	 * @return 实体对象
	 */
	void update(T entity);
	
	/**
	* 更新实体
	* @param entity 实体对象
	* @param ignoreProperties 忽略属性
	* @return    
	* T
	 */
	void update(T entity,ID id,String... ignoreProperties);
	
	/**
	 * 删除实体对象
	 * 
	 * @param id
	 *            ID
	 */
	void delete(ID id);

	/**
	 * 删除实体对象
	 * 
	 * @param ids
	 *            ID
	 */
	void delete(ID... ids);

	/**
	 * 删除实体对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	void delete(T entity);
	
	/**
	* 获得所有实体集
	* @return    
	* 实体集
	 */
	List<T> getAll();
	
	/**
	* 获得实体集按属性名排序
	* @param propertyNames
	* @return    
	* List<T>
	 */
	List<T> getAll(String ... propertyNames);
	/**
	 * 根据sql语句返回数据集
	 * @param sql
	 * @return
	 */
	List getStringList(String sql);
	
	/**
	 * 执行SQL
	 * @param sql
	 * @param parameters
	 * @return
	 */
	Object executeSQL(String sql,List<HiParameter> parameters);
}
