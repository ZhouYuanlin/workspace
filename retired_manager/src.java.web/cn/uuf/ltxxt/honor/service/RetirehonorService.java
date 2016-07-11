package cn.uuf.ltxxt.honor.service;

import java.util.List;

import cn.uuf.domain.honor.Retirehonor;

/**
 * 表彰
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-15
 */
public interface RetirehonorService {

	public void save(Retirehonor h);
	public void update(Retirehonor h);
	public void delete(Long... id);
	public Retirehonor getById(Long id);
	public Long getCount(Retirehonor h,String kssj,String jssj);
	public List<Retirehonor> queryList(Retirehonor h,int s,int size,String kssj,String jssj);
	public List<Retirehonor> queryByVo(Retirehonor h);
	
}

