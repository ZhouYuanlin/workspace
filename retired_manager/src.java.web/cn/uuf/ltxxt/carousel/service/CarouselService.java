package cn.uuf.ltxxt.carousel.service;

import java.util.List;

import cn.uuf.domain.data.Carousel;
/**
 * @author lth
 *
 */
public interface CarouselService {

	public List<Carousel> getAll()throws Exception;
	
	public Long getCount(Carousel carousel);
	
	public Carousel queryBySort(int sort)throws Exception;
	
	public Carousel getById(Long id)throws Exception;
	
	public void save(Carousel carousel)throws Exception;
	
	public void update(Carousel carousel)throws Exception;
	
	public void delete(Long... id)throws Exception;
	
	public void delete(Carousel carousel)throws Exception;
	
	public List<Carousel> queryList(Carousel carousel,int start,int size);
	
	

	
}

