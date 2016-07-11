package cn.uuf.ltxxt.health.service;

import java.util.List;

import cn.uuf.domain.health.Rethoscosts;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-29
 */
public interface RethoscostsService {
	public void save(Rethoscosts t);
	public void update(Rethoscosts t);
	public void delete(Long... id);
	public Rethoscosts getById(Long id);
	public Long getCount(Rethoscosts t,String ksj,String jsj);
	public List<Rethoscosts> queryByVo(Rethoscosts t);
	public List<Rethoscosts> queryList(Rethoscosts t,int s,int size,String ksj,String jsj);
}

