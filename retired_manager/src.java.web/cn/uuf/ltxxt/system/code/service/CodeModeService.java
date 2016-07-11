package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeMode;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
public interface CodeModeService {

	public void save(CodeMode c);
	public void update(CodeMode c);
	public void delete(Long... id);
	public CodeMode getById(Long id);
	public List<CodeMode> getAll();
	public Long getCount(CodeMode c);
	public List<CodeMode> queryList(CodeMode c,int s,int size);
	
}

