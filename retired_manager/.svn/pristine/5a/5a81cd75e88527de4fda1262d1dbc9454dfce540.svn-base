package cn.uuf.ltxxt.life.service;

import java.util.List;

import cn.uuf.domain.life.Video;

/**
 * 类说明	：视频资源
 */
public interface VideosService {
	public List<Video> getAll()throws Exception;
	
	public Video getById(Long id)throws Exception;
	
	public void save(Video a)throws Exception;
	
	public void update(Video a)throws Exception;
	
	public void delete(Video a)throws Exception;
	
	public void delete(Long... ids)throws Exception;
	
	public List<Video> queryByPage(Video a,int start,int size);
	
	public Long getCount(Video a);
	
	public void delete(String hql);
	
	public List<Video> getNoAppr(); 
}
