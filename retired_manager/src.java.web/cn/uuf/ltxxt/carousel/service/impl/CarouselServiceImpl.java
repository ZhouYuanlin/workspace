package cn.uuf.ltxxt.carousel.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Service;

import cn.uuf.domain.data.Carousel;
import cn.uuf.ltxxt.carousel.service.CarouselService;
import cn.uuf.support.dao.hibernate.impl.HibernateDaoSupport;
/**
 * @author lth
 *
 */
@SuppressWarnings("unchecked")
@Service("carouseService")
public class CarouselServiceImpl extends HibernateDaoSupport<Carousel,Long> implements CarouselService{
	protected Log logger = LogFactory.getLog(this.getClass());

	@Override
	public List<Carousel> getAll() throws Exception {
		return this.find();
	}
	
	@Override
	public Long getCount(Carousel carousel) {
		
		Criteria criteria = getSession().createCriteria(carousel.getClass());
		ProjectionList proList = Projections.projectionList();//设置投影集合
		proList.add(Projections.property("id"));
		criteria.setProjection(proList);
		return this.getCount(criteria);
	}


	@Override
	public List<Carousel> queryList(Carousel carousel, int start, int size) {
		
		return this.queryByPage(buildCriteriaByEntity(carousel,start,size));
	}
	
	private Criteria buildCriteriaByEntity(Carousel carousel,int start,int size){
		Criteria criteria = getSession().createCriteria(carousel.getClass());
		if(size != 0)
			criteria.setFirstResult(start).setMaxResults(size);
		criteria.addOrder(Order.desc("sort"));//排序
		return criteria;
	}

	@Override
	public Carousel queryBySort(int sort) throws Exception {
		Carousel carousel = (Carousel) this.findUniqueBy(Carousel.class,"sort",sort);
		return carousel;
	}


	
}

