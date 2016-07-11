package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeDwb;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-20
 */
public interface CodeDwbService {

	public void save(CodeDwb d);
	
	public void update(CodeDwb d);
	
	public void delete(Long... id);
	
	public List<CodeDwb> getAll();
	
	public CodeDwb getById(Long id);
	
	public Long getCount(CodeDwb d);
	
	public List<CodeDwb> queryList(CodeDwb d,int s,int size);
	public List<CodeDwb> queryByVo(CodeDwb d);
}

