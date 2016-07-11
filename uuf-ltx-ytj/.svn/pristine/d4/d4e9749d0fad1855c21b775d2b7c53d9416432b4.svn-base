/*
 * 
 * 
 * 
 */
package cn.uuf.stu.framework.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 分页
 * 
 * 
 * 
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = -2053800594583879853L;

	/** 内容 */
	private List<T> content = new ArrayList<T>();

	/** 总记录数 */
	private final long total;

	/** 分页信息 */
	private final Pageable pageable;
	
	/** 总页数*/
	private int totalPages;
	
	/** 当前页码*/
	private int pageNumber;
	
	/** 前一页码*/
	private int previousPageNumber;
	
	/** 下一页码*/
	private int nextPageNumber;
	
	
	/**
	 * 初始化一个新创建的Page对象
	 */
	public Page() {
		this.total = 0L;
		this.pageable = new Pageable();
	}

	/**
	 * @param content
	 *            内容
	 * @param total
	 *            总记录数
	 * @param pageable
	 *            分页信息
	 */
	public Page(List<T> content, long total, Pageable pageable) {
		this.content.addAll(content);
		this.total = total;
		this.pageable = pageable;
	}


	/**
	 * 获取排序
	 * 
	 * @return 排序
	 */
	public List<Order> getOrders() {
		return pageable.getOrders();
	}

	/**
	 * 获取筛选
	 * 
	 * @return 筛选
	 */
	public List<Filter> getFilters() {
		return pageable.getFilters();
	}
	
	/**
	 * 获取内容
	 * 
	 * @return 内容
	 */
	public List<T> getContent() {
		return content;
	}

	/**
	 * 设置内容
	 * @param content
	 */
	public void setContent(List<T> content) {
		this.content = content;
	}

	/**
	 * 获取分页信息
	 * 
	 * @return 分页信息
	 */
	public Pageable getPageable() {
		return pageable;
	}
	
	/**
	* 获取总页数
	* @return    
	* int
	 */
	public int getTotalPages() {
		return totalPages;
	}
	
	/**
	* 设置总页数
	* @param totalPages    
	* void
	*/
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	/**
	* 获取页码
	* @return    
	* int
	*/
	public int getPageNumber() {
		return pageNumber;
	}
	
	/**
	* 设置页码
	* @param pageNumber    
	* void
	*/
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	/**
	* 获取前一页
	* @return    
	* int
	*/
	public int getPreviousPageNumber() {
		return previousPageNumber;
	}
	
	/**
	* 设置前一页
	* @param previousPageNumber    
	* void
	*/
	public void setPreviousPageNumber(int previousPageNumber) {
		this.previousPageNumber = previousPageNumber;
	}
	
	/**
	* 获取下一页
	* @return    
	* int
	 */
	public int getNextPageNumber() {
		return nextPageNumber;
	}
	
	/**
	* 设置下一页
	* @param nextPageNumber    
	* void
	*/
	public void setNextPageNumber(int nextPageNumber) {
		this.nextPageNumber = nextPageNumber;
	}

	
	public long getTotal() {
		return total;
	}

}