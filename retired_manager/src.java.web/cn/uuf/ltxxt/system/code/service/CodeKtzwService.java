package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeKtzw;

/**
 * 类型
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
public interface CodeKtzwService {

	public void save(CodeKtzw l);
	public void update(CodeKtzw l);
	public void delete(Long... id);
	public CodeKtzw getById(Long id);
	public List<CodeKtzw> getAll();
	public Long getCount(CodeKtzw l);
	public List<CodeKtzw> queryList(CodeKtzw l,int s,int size);
}

