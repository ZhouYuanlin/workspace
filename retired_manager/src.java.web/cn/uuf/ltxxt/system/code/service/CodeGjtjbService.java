package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeTjb;

/**
 * 高级查询表Service
 * @author Suntingwen
 *
 */
public interface CodeGjtjbService{

	public void save(CodeTjb codeTjb);
	public void update(CodeTjb codeTjb);
	public void delete(Long... id);
	public CodeTjb getById(Long id);
	public List<CodeTjb> getAll();
	public Long getCount(CodeTjb c);
	public List<CodeTjb> queryList(CodeTjb codeTjb,int s,int size);
	public CodeTjb getUniqueEntity(String propertyName,Object propertyValue);
	
}

