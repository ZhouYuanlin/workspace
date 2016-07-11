package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeXwb;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-1
 */
public interface CodeXwbService {

	public void save(CodeXwb c);
	public void update(CodeXwb c);
	public void delete(Long... id);
	public CodeXwb getById(Long id);
	public List<CodeXwb> getAll();
	public Long getCount(CodeXwb c);
	public List<CodeXwb> queryList(CodeXwb c,int s,int size);
}

