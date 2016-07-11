package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeAssetType;

public interface CodeAssetTypeService {
	public void save(CodeAssetType c);
	public void update(CodeAssetType c);
	public void delete(Long... id);
	public CodeAssetType getById(Long id);
	public List<CodeAssetType> getAll();
	public Long getCount(CodeAssetType c);
	public List<CodeAssetType> queryList(CodeAssetType c,int s,int size);
}
