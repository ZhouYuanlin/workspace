package cn.uuf.util;

import java.io.Serializable;

/**
 * @author <a href="waxwing819230@sina.com">lth</a>
 * @version 2.0
 * @date Apr 1, 2013
 */
public class Page implements Serializable{

	public Page(Long count, Integer perPage, Integer currentPageNumber) {
		hasPervious = Boolean.FALSE;
		hasNext = Boolean.FALSE;
		this.count = count;
		this.perPage = perPage;
		perPage = perPage != null ? perPage : DEFAULT_PER_PATER;
		Long tempCount = Long.valueOf(count.longValue()
				% (long) perPage.intValue() != 0L ? count.longValue()
				/ (long) perPage.intValue() + 1L : count.longValue()
				/ (long) perPage.intValue());
		pageCount = Integer.valueOf(tempCount.intValue());
		currentPage = Integer
				.valueOf(hasPageNumber(currentPageNumber) ? currentPageNumber
						.intValue() : 1);
		firstPage = Integer.valueOf(1);
		lastPage = pageCount;
		setPrevious();
		setNext();
	}

	protected void setPrevious() {
		if (currentPage == null)
			throw new NullPointerException("必须先计算pageCount,currentPage");
		if (currentPage.intValue() > 1)
			hasPervious = Boolean.TRUE;
		if (hasPervious.booleanValue())
			previous = Integer.valueOf(currentPage.intValue() - 1);
	}

	protected void setNext() {
		if (currentPage == null)
			throw new NullPointerException("必须先计算pageCount,currentPage");
		if (currentPage.intValue() < pageCount.intValue())
			hasNext = Boolean.TRUE;
		if (hasNext.booleanValue())
			next = Integer.valueOf(currentPage.intValue() + 1);
	}

	public boolean hasPageNumber(Integer number) {
		return number.intValue() >= 1
				&& number.intValue() <= pageCount.intValue();
	}

	public Integer getPerPage() {
		return perPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getFirstPage() {
		return firstPage;
	}

	public Integer getLastPage() {
		return lastPage;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public Integer getPrevious() {
		return previous;
	}

	public Integer getNext() {
		return next;
	}

	public Boolean getHasPervious() {
		return hasPervious;
	}

	public Boolean getHasNext() {
		return hasNext;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	private static final long serialVersionUID = 6317513221672950184L;
	private static final Integer DEFAULT_PER_PATER = Integer.valueOf(20);
	private Long count;
	private Integer perPage;
	private Integer currentPage;
	private Integer firstPage;
	private Integer lastPage;
	private Integer pageCount;
	private Integer previous;
	private Integer next;
	private Boolean hasPervious;
	private Boolean hasNext;
}

