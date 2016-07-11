package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeZbb;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
public interface CodeZbbService {

	public void save(CodeZbb c);
	public void update(CodeZbb c);
	public void delete(Long... id);
	public CodeZbb getById(Long id);
	public List<CodeZbb> getAll();
	public Long getCount(CodeZbb c);
	public List<CodeZbb> queryList(CodeZbb c,int s,int size);
	
}

