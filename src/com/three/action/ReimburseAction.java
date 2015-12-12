package com.three.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.Request;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.three.db.Other_expense;
import com.three.db.Reimburse;
import com.three.db.Trans;
import com.three.domain.Apply_Reimburse;

public class ReimburseAction extends ActionSupport implements Preparable{
	
	 private Apply_Reimburse apply_Reimburse;
	 private Reimburse reimburse;
	 private Trans trans;
	 private Other_expense other_expense;
	 private List<Reimburse> reimburses;
	 private List<Trans> transs;
	 private List<Other_expense> other_expenses;
	 private int pageNow=0;
	 private int pageSize=5;

	public String insertReimburse() {
		System.out.print("ok");
		apply_Reimburse.insertReimburse(reimburse,transs,other_expenses);
		return SUCCESS;

	}

	public String UpdateReimburse() {
		apply_Reimburse.UpdateReimburse(reimburse,transs,other_expenses,reimburse.getReimburse_id());
		
		return SUCCESS;

	}

	public String queryReimburse() {
		// TODO Auto-generated method stub
		HttpServletRequest req = ServletActionContext.getRequest();
		String s=req.getParameter("flag").toString();
		int flag= Integer.parseInt(s);
		HttpSession session = req.getSession();
		if(flag==1)
		{
			session.setAttribute("Reimburse_time","");
			session.setAttribute("Reimburse_state","");
		if(!(StringUtils.isBlank(reimburse.getReimburse_time())))
		{
		session.setAttribute("Reimburse_time",reimburse.getReimburse_time() );
		}
		if(!(StringUtils.isBlank(reimburse.getReimburse_state())))
		{
		session.setAttribute("Reimburse_state",reimburse.getReimburse_state());
		}
		}
		if(pageNow<0)
		{
			JOptionPane.showMessageDialog(null,"ÒÑÊÇÊ×Ò³!");
		}
		else
		{
		if(null!=apply_Reimburse.queryReimburse(reimburse.getReimburse_time(),reimburse.getReimburse_state(),reimburse.getEmployee_id(),pageNow,pageSize))
		{
		reimburses= apply_Reimburse.queryReimburse(reimburse.getReimburse_time(),reimburse.getReimburse_state(),reimburse.getEmployee_id(),pageNow,pageSize);
		}
		}
		return SUCCESS;

		
			
	}
	
	public String queryReimburseInfor() {
		// TODO Auto-generated method stub
		reimburses= apply_Reimburse.queryReimburseInfor(reimburse.getReimburse_id());
		return queryTransInfor();
	}
	public String queryTransInfor() {
		// TODO Auto-generated method stub
		transs= apply_Reimburse.queryTransInfor(reimburse.getReimburse_id());
		return queryOther_expenseInfor();
	}
	public String queryOther_expenseInfor() {
		// TODO Auto-generated method stub
		other_expenses= apply_Reimburse.queryOther_expenseInfor(reimburse.getReimburse_id());
		HttpServletRequest request = ServletActionContext.getRequest();
		String s=request.getParameter("flag").toString();
		int flag= Integer.parseInt(s);
		if(flag==1){
			return "success1";
		}
		else if(flag==2){
			return "success2";
		}
		return s;
	}
	@Override
	public void prepare() throws Exception {
		reimburse = null;
		trans = null;
		other_expense = null;
	}

	public Apply_Reimburse getApply_Reimburse() {
		return apply_Reimburse;
	}

	public void setApply_Reimburse(Apply_Reimburse apply_Reimburse) {
		this.apply_Reimburse = apply_Reimburse;
	}

	public Reimburse getReimburse() {
		return reimburse;
	}

	public void setReimburse(Reimburse reimburse) {
		this.reimburse = reimburse;
	}

	public Trans getTrans() {
		return trans;
	}

	public void setTrans(Trans trans) {
		this.trans = trans;
	}

	public Other_expense getOther_expense() {
		return other_expense;
	}

	public void setOther_expense(Other_expense other_expense) {
		this.other_expense = other_expense;
	}

	public List<Reimburse> getReimburses() {
		return reimburses;
	}

	public void setReimburses(List<Reimburse> reimburses) {
		this.reimburses = reimburses;
	}

	public List<Trans> getTranss() {
		return transs;
	}

	public void setTranss(List<Trans> transs) {
		this.transs = transs;
	}

	public List<Other_expense> getOther_expenses() {
		return other_expenses;
	}

	public void setOther_expenses(List<Other_expense> other_expenses) {
		this.other_expenses = other_expenses;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	

}
