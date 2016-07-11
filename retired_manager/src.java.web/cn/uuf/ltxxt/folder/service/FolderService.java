package cn.uuf.ltxxt.folder.service;

import java.util.List;

import cn.uuf.domain.Folder;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-08
 */
public interface FolderService {
	public List<Folder> getAll()throws Exception;
	
	public Folder getById(Long id)throws Exception;
	
	public void save(Folder folder)throws Exception;
	
	public void update(Folder folder)throws Exception;
	
	public void delete(Folder folder)throws Exception;
	
	public void delete(Long... ids)throws Exception;
	
	public List<Folder> queryByPage(Folder folder,int start,int size);
	
	public List<Folder> queryByHql();
	
	public Long getCount(Folder folder);
	
	public void updateSql(String hql);
	
	public void deleteByParentId(String parentId);
	
	public List<Folder> getUserList(Folder folder,int start,int size);
	
}
