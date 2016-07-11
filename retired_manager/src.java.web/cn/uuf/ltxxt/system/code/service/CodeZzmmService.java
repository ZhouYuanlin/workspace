package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeZzmmb;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
public interface CodeZzmmService {

	public void save(CodeZzmmb c);
	public void update(CodeZzmmb c);
	public void delete(Long... id);
	public CodeZzmmb getById(Long id);
	public List<CodeZzmmb> getAll();
	public Long getCount(CodeZzmmb c);
	public List<CodeZzmmb> queryList(CodeZzmmb c,int s,int size);
	
}

