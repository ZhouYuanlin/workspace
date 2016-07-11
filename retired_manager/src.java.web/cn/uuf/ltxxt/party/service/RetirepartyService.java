package cn.uuf.ltxxt.party.service;

import java.util.List;

import cn.uuf.domain.ret.Retireparty;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-11
 */
public interface RetirepartyService {

	public List<Retireparty> getAll();
	public void save(Retireparty p);
	public void update(Retireparty p);
	public void delete(Long... id);
	public Retireparty getById(Long id);
	public Retireparty queryByName(String mc);
	public Long getCount(Retireparty p);
	public List<Retireparty> queryByVo(Retireparty p);
	public List<Retireparty> queryList(Retireparty p,int s,int start);
}

