package cn.uuf.ltxxt.life.service;

import java.util.List;

import cn.uuf.domain.life.DocGrp;
import cn.uuf.domain.ret.Retireparty;

/**
 * 类说明	：资源分组
 */
public interface GroupService {
	public List<DocGrp> getAll()throws Exception;
	
	public DocGrp getById(Long id)throws Exception;
	
	public void save(DocGrp a)throws Exception;
	
	public void update(DocGrp a)throws Exception;
	
	public void delete(DocGrp a)throws Exception;
	
	public void delete(Long... ids)throws Exception;
	
	public List<DocGrp> queryByPage(DocGrp a,int start,int size);
	
	public Long getCount(DocGrp a);
	
	public void delete(String hql);
	
	public List<DocGrp> queryList(DocGrp a,int s,int start);
}
