package com.komia.common;

import java.util.List;

import com.komia.util.KomiaConstant;

public class PageInfo<T> {
	private Integer currentPage = 1; //当前页
	private Integer pageSize = KomiaConstant.DEFAULT_PAGE_SIZE; //每页条数
	private int totalCount; //总条数
	private int totalPage; //总页数
	private int offset; //起始编号
	
	private List<T> pdata; //每页的数据
	
	public PageInfo(Integer currentPage, Integer pageSize, Integer totalCount) {
		super();
		if(currentPage == null ||currentPage<=0 || currentPage>Integer.MAX_VALUE) {
			currentPage = 1;
		}
		if(pageSize == null || pageSize>100 || pageSize<=0) {
			pageSize = KomiaConstant.DEFAULT_PAGE_SIZE;
		}
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = (int) Math.ceil(this.totalCount/(this.pageSize*1.0));
		this.offset = (this.currentPage - 1)*this.pageSize;
	}

	public List<T> getPdata() {
		return pdata;
	}

	public void setPdata(List<T> pdata) {
		this.pdata = pdata;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
}
