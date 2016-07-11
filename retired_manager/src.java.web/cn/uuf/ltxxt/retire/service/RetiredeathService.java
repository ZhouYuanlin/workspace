package cn.uuf.ltxxt.retire.service;

import java.util.List;

import cn.uuf.domain.Retiredeath;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-31
 */
public interface RetiredeathService {

	public void save(Retiredeath r);
	public void update(Retiredeath r);
	public void delete(String... s);
	public List queryByHql(String hql)throws Exception;
	public Retiredeath getById(String s);
	public Long getCount(Retiredeath r,String ksj,String jsj);
	public List<Retiredeath> queryList(Retiredeath r,int s,int size,String ksj,String jsj);
}

