package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeSydb;

/**
 * 生源地或籍惯
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
public interface CodeSydService {

	public void save(CodeSydb s);
	public void update(CodeSydb s);
	public void delete(Long... id);
	public CodeSydb getById(Long id);
	public List<CodeSydb> getAll();
	public Long getCount(CodeSydb s);
	public List<CodeSydb> queryList(CodeSydb d,int s,int size);
	public List<CodeSydb> queryByVo(CodeSydb d);
}

