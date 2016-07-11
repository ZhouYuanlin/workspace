package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeMzb;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
public interface CodeMzbService {

	public void save(CodeMzb c);
	public void update(CodeMzb c);
	public void delete(Long... id);
	public CodeMzb getById(Long id);
	public List<CodeMzb> getAll();
	public Long getCount(CodeMzb c);
	public List<CodeMzb> queryList(CodeMzb c,int s,int size);
	public List<CodeMzb> queryByVo(CodeMzb m);
	
}

