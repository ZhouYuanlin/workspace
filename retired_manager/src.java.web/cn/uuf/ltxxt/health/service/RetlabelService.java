package cn.uuf.ltxxt.health.service;

import java.util.List;

import cn.uuf.domain.health.Retlabel;

/**
 * 保健标记
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-2
 */
public interface RetlabelService {

	public void save(Retlabel l);
	public void update(Retlabel l);
	public void delete(Long... id);
	public Retlabel getById(Long id);
	public Long getCount(Retlabel l);
	public List<Retlabel> queryList(Retlabel l,int s,int size);
}

