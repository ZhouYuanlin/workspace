package cn.uuf.ltxxt.retire.service;

import java.util.List;

import cn.uuf.domain.Retirement;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-28
 */
public interface RetbirthdayService {

	public Long getCount(Retirement r,String ks,String js,String eq,String type);
	public List<Retirement> queryList(Retirement r,int s,int size,String ks,String js,String eq,String type);
}

