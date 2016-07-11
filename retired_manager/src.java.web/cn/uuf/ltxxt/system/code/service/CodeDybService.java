package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeDyb;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-20
 */
public interface CodeDybService {

	public void save(CodeDyb d);
	
	public void update(CodeDyb d);
	
	public void delete(Long... id);
	
	public List<CodeDyb> getAll();
	
	public CodeDyb getById(Long id);
	
	public Long getCount(CodeDyb d);
	public List<CodeDyb> queryByVo(CodeDyb d);
	public List<CodeDyb> queryList(CodeDyb d,int s,int size);
}

