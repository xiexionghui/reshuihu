package org.framework.business.util;

import java.io.Serializable;
import java.util.List;

public class PageList<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3814718333811639745L;
	private int rowCount;
	private int pages;
	private int currentPage;
	private int pageSize=10;
	private List<T> result;
	private String pageUrl;

	
	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public PageList() {
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

}
