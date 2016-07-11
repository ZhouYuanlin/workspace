package cn.uuf.stu.framework.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 分页消息    page
* @ClassName: Pageable 
* @author tangpeng 
* @date 2015年8月17日 下午9:59:08 
*
*/
public class Pageable implements Serializable  {
	
	private static final long serialVersionUID = 6493407840709894153L;
	/** 默认页码 */
	private static final int DEFAULT_PAGE_NUMBER = 1;
	/** 默认每页记录数 */
	private static final int DEFAULT_PAGE_SIZE =10;
	/** 最大每页记录数 */
	public static final int MAX_PAGE_SIZE = 100000;
	/** 显示的页码数 只能是奇数*/
	private static final int DEFAULT_SHOW_PAGE_NUMBER = 11;
	/**页码*/
	private int pageNumber = DEFAULT_PAGE_NUMBER;
	/** 每页记录数 */
	private int pageSize = DEFAULT_PAGE_SIZE;
	/** 显示的页码数*/
	private int showPageNumber = DEFAULT_SHOW_PAGE_NUMBER;  
	
	/** 筛选*/
	private List<Filter> filters = new ArrayList<Filter>();
	
	/** 排序*/
	private List<Order> orders = new ArrayList<Order>();
	
	/** 查询str*/
	private String queryCountStr;
	
	/** 查询str*/
	private String queryListStr;
	
	private List<HiParameter> params = new ArrayList<HiParameter>();
	
	/**
	 * 初始化一个新创建的Pageable对象
	 */
	public Pageable() {
	}

	/**
	 * 初始化一个新创建的Pageable对象
	 * 
	 * @param pageNumber
	 *            页码
	 * @param pageSize
	 *            每页记录数
	 */
	public Pageable(Integer pageNumber, Integer pageSize) {
		if (pageNumber != null && pageNumber >= 1) {
			this.pageNumber = pageNumber;
		}
		if (pageSize != null && pageSize >= 1 && pageSize <= MAX_PAGE_SIZE) {
			this.pageSize = pageSize;
		}
	}
	

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		if (pageNumber < 1) {
			pageNumber = DEFAULT_PAGE_NUMBER;
		}
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 1 || pageSize > MAX_PAGE_SIZE) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
		this.pageSize = pageSize;
	}

	public List<Filter> getFilters() {
		return filters;
	}

	public void setFilters(List<Filter> filters) {
		this.filters = filters;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public int getShowPageNumber() {
		return showPageNumber;
	}

	public void setShowPageNumber(int showPageNumber) {
		this.showPageNumber = showPageNumber;
	}

	public List<HiParameter> getParams() {
		return params;
	}

	public void setParams(List<HiParameter> params) {
		this.params = params;
	}

	public String getQueryCountStr() {
		return queryCountStr;
	}

	public void setQueryCountStr(String queryCountStr) {
		this.queryCountStr = queryCountStr;
	}

	public String getQueryListStr() {
		return queryListStr;
	}

	public void setQueryListStr(String queryListStr) {
		this.queryListStr = queryListStr;
	}
	
	
	
}
