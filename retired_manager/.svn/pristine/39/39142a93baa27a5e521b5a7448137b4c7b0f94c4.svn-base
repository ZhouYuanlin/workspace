package cn.uuf.ltxxt.life.service;

import java.util.List;

import cn.uuf.domain.life.Article;

/**
 * 类说明	：
 */
public interface ArticlesService {
	public List<Article> getAll()throws Exception;
	
	public Article getById(Long id)throws Exception;
	
	public void save(Article a)throws Exception;
	
	public void update(Article a)throws Exception;
	
	public void delete(Article a)throws Exception;
	
	public void delete(Long... ids)throws Exception;
	
	public List<Article> queryByPage(Article a,int start,int size);
	
	public Long getCount(Article a);
	
	public void delete(String hql);
}
