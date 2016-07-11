package cn.uuf.util;

import java.io.Serializable;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date Apr 1, 2013
 */
public class Paginate implements Serializable{
	
	private static final long serialVersionUID = -4575477536270128285L;
	
	public enum  SIZE  {
		SMALL,MIDDLE,BIG
	}

	public Paginate() {
	}

	public Paginate(Object date, Long count, Integer perPage,
			Integer currentPage) {
		data = date;
		page = new Page(count, perPage, currentPage);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	private Object data;
	private Page page;

}

