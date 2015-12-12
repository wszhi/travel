package com.three.db;

import java.util.List;

public class PageBean {

	private int pageSize;//ÿҳ��С   
    private int totalrows;//�ܼ�¼��   
	private int pageNum;//��ҳ��   
	private int curPage;//��ǰҳ��   
	     
	private List items;//�������   
 
//Ĭ�Ϲ���������ʼ����Ա����   
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
