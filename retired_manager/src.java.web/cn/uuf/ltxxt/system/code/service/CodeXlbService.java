package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeXlb;

/**
 * 学历表
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-1
 */
public interface CodeXlbService {

	public void save(CodeXlb c);
	public void update(CodeXlb c);
	public void delete(Long... id);
	public CodeXlb getById(Long id);
	public List<CodeXlb> getAll();
	public Long getCount(CodeXlb c);
	public List<CodeXlb> queryList(CodeXlb c,int s,int size);
}

