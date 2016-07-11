package cn.uuf.ltxxt.health.service;

import java.util.List;

import cn.uuf.domain.Retirement;
import cn.uuf.domain.health.Rethospital;
import cn.uuf.domain.health.Retphone;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-29
 */
public interface RetphoneService {
	public Retphone getById(Long id);
	public Long getCount(Retphone retphone);
	public List<Retphone> queryList(Retphone retphone,int s,int size);
	public void save(Retphone retphone);
	public void update(Retphone retp);
	public void delete(Long[] id);
	public List<Retphone> queryByVo(Retphone pho);
	public List<Retphone> queryBySql(String phsql);
}

