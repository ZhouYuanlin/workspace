package cn.uuf.ltxxt.health.service;

import java.util.List;

import cn.uuf.domain.Retirement;
import cn.uuf.domain.health.Rethoscard;

/**
 * 医保卡
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-12-3
 */
public interface RethoscardService {

	public void save(Rethoscard c);
	public void update(Rethoscard c);
	public List<Rethoscard> getBySfzh(Rethoscard card);
	public void delete(Long... id);
	public Rethoscard getById(Long id);
	public Long getCount(Rethoscard c);
	public List<Rethoscard> queryList(Rethoscard c,int s,int size);
	public List<Rethoscard> queryByVo(Rethoscard c);
}

