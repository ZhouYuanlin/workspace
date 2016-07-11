package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeTjb;
import cn.uuf.domain.CodeZdytjb;

/**
 * 自定义查询条件表Service
 * @author Suntingwen
 *
 */
public interface CodeZdytjbService {

	public void save(CodeZdytjb zdytjb);
	public void update(CodeZdytjb zdytjb);
	public void delete(Long... id);
	public CodeZdytjb getById(Long id);
	public List<CodeZdytjb> getAll();
	public Long getCount(CodeZdytjb zdytjb);
	public List<CodeZdytjb> queryList(CodeZdytjb zdytjb,int s,int size);
	
	//查询对应的表的字段名
	public List<CodeZdytjb> queryUniqueTable(CodeTjb tjb);
	
	//查询对应字段实体
	public CodeZdytjb getUniqueEntity(String propertyName,Object propertyValue);
	
}

