package cn.uuf.stu.framework.service.impl;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;

import cn.uuf.stu.entity.framework.BaseEntity;
import cn.uuf.stu.framework.common.HiParameter;
import cn.uuf.stu.framework.dao.IBaseDao;
import cn.uuf.stu.framework.service.IBaseService;




/**
* 基类
* @ClassName: BaseServiceImpl 
* @author tangpeng
* @date 2015年7月27日 上午11:26:12 
* 
* @param <T>
* @param <ID>
 */
public class BaseServiceImpl<T,ID extends Serializable> implements IBaseService<T, ID> {
	
	/** 更新忽略属性 */
	private static final String[] UPDATE_IGNORE_PROPERTIES = new String[] { BaseEntity.ID_PROPERTY_NAME, BaseEntity.CREATE_DATE_PROPERTY_NAME, BaseEntity.MODIFY_DATE_PROPERTY_NAME };
	
	private IBaseDao<T,ID> baseDao;
	
	public void setBaseDao(IBaseDao<T, ID> baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public T load(ID id) {
		return baseDao.load(id);
	}

	@Override
	public void save(T entity) {
		baseDao.save(entity);
	}

	@Override
	public T getUniqueEntity(String propertyName, Object propertyValue) {
		return baseDao.getUniqueEntity(propertyName, propertyValue);
	}

	@Override
	public void update(T entity) {
		baseDao.update(entity);
	}

	@Override
	public void delete(ID id) {
		delete(baseDao.load(id));
	}

	@Override
	public void delete(ID... ids) {
		if(ids != null){
			for (ID id : ids) {
				delete(baseDao.load(id));
			}
		}
	}

	@Override
	public void delete(T entity) {
		baseDao.delete(entity);
	}

	@Override
	public Long count(String propertyName, Object propertyValue) {
		return baseDao.count(propertyName, propertyValue);
	}

	@Override
	public List<T> getAll() {
		return baseDao.getAll();
	}

	@Override
	public List<T> getList(ID... ids) {
		List<T> list = new ArrayList<T>();
		if(ids!=null){
			for (ID id : ids) {
				list.add(load(id));
			}
		}
		return list;
	}
	
	@Override
	public void update(T entity,ID id, String... ignoreProperties) {
		Assert.notNull(entity);
		Assert.notNull(id);
		T persistant = baseDao.load(id);
		Assert.notNull(persistant);
		copyProperties(entity,persistant, (String[]) ArrayUtils.addAll(ignoreProperties, UPDATE_IGNORE_PROPERTIES));
		baseDao.update(persistant);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void copyProperties(Object source, Object target, String[] ignoreProperties) throws BeansException {
		Assert.notNull(source, "Source must not be null");
		Assert.notNull(target, "Target must not be null");

		PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(target.getClass());
		List<String> ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties) : null;
		for (PropertyDescriptor targetPd : targetPds) {
			if (targetPd.getWriteMethod() != null && (ignoreProperties == null || (!ignoreList.contains(targetPd.getName())))) {
				PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
				if (sourcePd != null && sourcePd.getReadMethod() != null) {
					try {
						Method readMethod = sourcePd.getReadMethod();
						if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
							readMethod.setAccessible(true);
						}
						Object sourceValue = readMethod.invoke(source);
						Object targetValue = readMethod.invoke(target);
						if (sourceValue != null && targetValue != null && targetValue instanceof Collection) {
							Collection collection = (Collection) targetValue;
							collection.clear();
							collection.addAll((Collection) sourceValue);
						} else {
							Method writeMethod = targetPd.getWriteMethod();
							if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
								writeMethod.setAccessible(true);
							}
							writeMethod.invoke(target, sourceValue);
						}
					} catch (Throwable ex) {
						throw new FatalBeanException("Could not copy properties from source to target", ex);
					}
				}
			}
		}
	}

	@Override
	public List<T> getAll(String... propertyNames) {
		return baseDao.getAll(propertyNames);
	}

	@Override
	public List<T> getList(String propertyName, Object propertyValue) {
		return baseDao.getList(propertyName,propertyValue);
	}

	@Override
	public List getStringList(String sql) {
		return baseDao.getStringList(sql);
	}

	@Override
	public T get(ID id) {
		
		return baseDao.get(id);
	}

	@Override
	public Object executeSQL(String sql, List<HiParameter> parameters) {
		return baseDao.executeSQL(sql, parameters);
	}
}
