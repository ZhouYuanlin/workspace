package cn.uuf.stu.framework.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.uuf.stu.entity.framework.WResource;
import cn.uuf.stu.framework.dao.IResourceDao;



/**
* 资源 dao
* @ClassName: ResourceDaoImpl 
* @author tangpeng
* @date 2015年8月11日 下午6:15:07 
*
*/
@Repository(value="resourceDao")
public class ResourceDaoImpl extends BaseDaoImpl<WResource,Long> implements IResourceDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<WResource> getRootMenu() {
		Criteria criteria = super.getSession().createCriteria(WResource.class);
		criteria.setCacheable(true);
		return criteria.add(Restrictions.isNull("parent.id")).addOrder(Order.asc("sort"))
				.list();
	}

	@Override
	public void delete(WResource entity) {
		super.getSessionFactory().evictCollection("cn.uuf.stu.entity.framework.Resource.childrens");
		super.delete(entity);
	}

	@Override
	public void save(WResource entity) {
		super.getSessionFactory().evictCollection("cn.uuf.stu.entity.framework.Resource.childrens");
		super.save(entity);
	}
	
	
	
	
	

}
