package cn.uuf.ltxxt.mess.service;

import java.util.List;

import cn.uuf.domain.message.Notice;

/**
 * 通知公告
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date 2015-11-21
 */
public interface NoticeService {

	public void save(Notice n);
	public void update(Notice n);
	public void delete(Long... id);
	public Notice getById(Long id);
	public Long getCount(Notice n);
	public List<Notice> queryList(Notice n,int s,int size);
}

