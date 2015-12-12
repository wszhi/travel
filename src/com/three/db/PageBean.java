package com.three.db;

import java.util.List;

public class PageBean {

	private int pageSize;//每页大小   
    private int totalrows;//总记录数   
	private int pageNum;//总页数   
	private int curPage;//当前页码   
	     
	private List items;//存放数据   
 
//默认构造器，初始化成员变量   
 public PageBean(int totalRows, int curPage,List items){  
 this.pageSize = 10;  
 this.totalrows = totalRows;  
 this.curPage = curPage;  
 this.pageNum = (int) Math.ceil((double)totalRows / pageSize);  
 this.items = items;  
 }

public int getPageSize() {
	return pageSize;
}

public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}

public int getTotalrows() {
	return totalrows;
}

public void setTotalrows(int totalrows) {
	this.totalrows = totalrows;
}

public int getPageNum() {
	return pageNum;
}

public void setPageNum(int pageNum) {
	this.pageNum = pageNum;
}

public int getCurPage() {
	return curPage;
}

public void setCurPage(int curPage) {
	this.curPage = curPage;
}

public List getItems() {
	return items;
}

public void setItems(List items) {
	this.items = items;
}  

}
