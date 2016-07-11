package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeSaveZdytjb;
import cn.uuf.domain.CodeTjb;
import cn.uuf.domain.CodeZdytjb;

/**
 * 快速查询包村自定义条件表Service
 * @author Suntingwen
 *
 */
public interface CodeSaveZdytjbService {

	public void save(CodeSaveZdytjb saveZdytjb);
	public void update(CodeSaveZdytjb saveZdytjb);
	public void delete(Long... id);
	public CodeSaveZdytjb getById(Long id);
	public List<CodeSaveZdytjb> getAll();
	public Long getCount(CodeSaveZdytjb saveZdytjb);
	public List<CodeSaveZdytjb> queryList(CodeSaveZdytjb zdytjb,int s,int size);
	public List<CodeSaveZdytjb> queryList(CodeSaveZdytjb zdytjb);
	
	//查询对应的表的字段名
	public List<CodeSaveZdytjb> queryUniqueTable(CodeTjb tjb);
	
	//查询对应字段实体
	public CodeSaveZdytjb getUniqueEntity(String propertyName,Object propertyValue);
	
}

