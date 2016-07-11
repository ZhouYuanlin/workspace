package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeAssetSource;

public interface CodeAssetSourceService {
	public void save(CodeAssetSource c);
	public void update(CodeAssetSource c);
	public void delete(Long... id);
	public CodeAssetSource getById(Long id);
	public List<CodeAssetSource> getAll();
	public Long getCount(CodeAssetSource c);
	public List<CodeAssetSource> queryList(CodeAssetSource c,int s,int size);

}
