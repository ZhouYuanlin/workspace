package cn.uuf.ltxxt.party.service;

import java.util.List;

import cn.uuf.domain.ret.Retiredonations;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-14
 */
public interface RetiredonationsService {

	public void save(Retiredonations d);
	public void update(Retiredonations d);
	public void delete(Long... id);
	public Retiredonations getById(Long id);
	public Long getCount(Retiredonations d,String kssj,String jssj);
	public List<Retiredonations> queryByVo(Retiredonations d);
	public List<Retiredonations> queryList(Retiredonations d,int s,int size,String kssj,String jssj);
}

