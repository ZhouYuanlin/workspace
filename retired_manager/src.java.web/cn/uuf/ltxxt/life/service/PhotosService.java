package cn.uuf.ltxxt.life.service;

import java.util.List;

import cn.uuf.domain.life.Photo;

/**
 * 类说明	：照片分享服务类
 */
public interface PhotosService {
	public List<Photo> getAll()throws Exception;
	
	public Photo getById(Long id)throws Exception;
	
	public void save(Photo p)throws Exception;
	
	public void update(Photo p)throws Exception;
	
	public void delete(Photo p)throws Exception;
	
	public void delete(Long... ids)throws Exception;
	
	public List<Photo> queryByPage(Photo p,int start,int size);
	
	public Long getCount(Photo p);
	
	public void delete(String hql);
	
	public Photo queryBySql(String sql);
	
	public List<Photo> getNoAppr() ;
	
}
