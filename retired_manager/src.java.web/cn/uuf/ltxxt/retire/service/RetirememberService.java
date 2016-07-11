package cn.uuf.ltxxt.retire.service;

import java.util.List;

import cn.uuf.domain.Retiremember;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
public interface RetirememberService {

	public void save(Retiremember m);
	public void update(Retiremember m);
	public void delete(Long... id);
	public Retiremember getById(Long id);
	public Long getCount(Retiremember m);
	public List<Retiremember> queryList(Retiremember m,int s,int size);
}

