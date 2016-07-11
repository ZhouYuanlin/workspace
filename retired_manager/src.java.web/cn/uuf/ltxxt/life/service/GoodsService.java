package cn.uuf.ltxxt.life.service;

import java.util.List;

import cn.uuf.domain.life.Goods;

/**
 * 类说明	：赞的服务类
 */
public interface GoodsService {
	public List<Goods> getAll()throws Exception;
	
	public Goods getById(Long id)throws Exception;
	
	public void save(Goods a)throws Exception;
	
	public void update(Goods a)throws Exception;
	
	public void delete(Goods a)throws Exception;
	
	public void delete(Long... ids)throws Exception;
	
	public List<Goods> queryByPage(Goods a,int start,int size);
	
	public Long getCount(Goods a);
	
	public void delete(String hql);
	
	public Goods queryBySql(String sql);
}
