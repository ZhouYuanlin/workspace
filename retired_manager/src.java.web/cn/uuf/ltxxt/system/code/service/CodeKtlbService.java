package cn.uuf.ltxxt.system.code.service;

import java.util.List;

import cn.uuf.domain.CodeKtlb;

/**
 * 课堂类别
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-10-21
 */
public interface CodeKtlbService {

	public void save(CodeKtlb l);
	public void update(CodeKtlb l);
	public void delete(Long... id);
	public CodeKtlb getById(Long id);
	public List<CodeKtlb> getAll();
	public Long getCount(CodeKtlb l);
	public List<CodeKtlb> queryList(CodeKtlb l,int s,int size);
}

