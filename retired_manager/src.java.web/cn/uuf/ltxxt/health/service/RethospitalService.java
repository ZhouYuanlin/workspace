package cn.uuf.ltxxt.health.service;

import java.util.List;

import cn.uuf.domain.Retirement;
import cn.uuf.domain.health.Rethospital;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-29
 */
public interface RethospitalService {
	public void save(Rethospital t);
	public void update(Rethospital t);
	public void delete(Long... id);
	public Rethospital getById(Long id);
	public List<Rethospital> queryByVo(Rethospital rethospital);
	public Long getCount(Rethospital t,String gksj,String gjsj);
	public List<Rethospital> queryList(Rethospital t,int s,int size,String gksj,String gjsj);
}

