package com.zqxx.dao;

import java.util.List;

public class Page {
	private Integer pageNo ;
	private Integer pageSize;
	private Long total;
	private Long totalpage ;
	private List list;   //结果
	
	public Page(){}
	public Page(Integer pageNo ,Integer pageSize){
		this.pageNo=pageNo;
		this.pageSize=pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public Long getTotal() {
		return total;
	}
	public Long getTotalpage() {
		return totalpage;
	}
	public List getList() {
		return list;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public void setTotalpage(Long totalpage) {
		this.totalpage = totalpage;
	}
	public void setList(List list) {
		this.list = list;
	}
}
