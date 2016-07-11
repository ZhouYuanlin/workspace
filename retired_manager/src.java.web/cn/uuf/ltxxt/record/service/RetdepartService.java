package cn.uuf.ltxxt.record.service;

import java.util.List;

import cn.uuf.domain.record.Retdepart;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-28
 */
public interface RetdepartService {

	public void save(Retdepart d);
	public void update(Retdepart d);
	public void delete(Long... id);
	public Retdepart getById(Long id);
	public Long getCount(Retdepart d);
	public List<Retdepart> queryList(Retdepart d,int s,int size);
	public List<Retdepart> getAll();
}

