package cn.uuf.ltxxt.party.service;

import java.util.List;

import cn.uuf.domain.ret.Retirepartywork;

/**
 * 党建工作
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-14
 */
public interface RetirepartyworkService {

	public void save(Retirepartywork w);
	public void update(Retirepartywork w);
	public void delete(Long... id);
	public Retirepartywork getById(Long id);
	public Long getCount(Retirepartywork w,String kssj,String jssj);
	public List<Retirepartywork> queryByVo(Retirepartywork p);
	public List<Retirepartywork> queryList(Retirepartywork w,int s,int size,String kssj,String jssj);
	public List<Retirepartywork> queryBySql(String pwsql);
}

