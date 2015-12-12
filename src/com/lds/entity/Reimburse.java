package com.lds.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="Reimburse")
public class Reimburse {
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public int getTravel_id() {
		return travel_id;
	}
	public void setTravel_id(int travel_id) {
		this.travel_id = travel_id;
	}
	@Id @Column(name="reimburse_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reimburse_id;
	private String employee_id;
	private String company;
	//private int trans_id;
	//private int other_expense_id;
	private String reimburse_remark;
	private int travel_id;
	private String manager_id;
	private String reimburse_state;
	private String reimburse_type;
	private double total_money;
	private Date reimburse_time;
	public int getReimburse_id() {
		return reimburse_id;
	}
	public void setReimburse_id(int reimburse_id) {
		this.reimburse_id = reimburse_id;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	/*
	public int getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}
	public int getOther_expense_id() {
		return other_expense_id;
	}
	public void setOther_expense_id(int other_expense_id) {
		this.other_expense_id = other_expense_id;
	}*/
	public String getReimburse_remark() {
		return reimburse_remark;
	}
	public void setReimburse_remark(String reimburse_remark) {
		this.reimburse_remark = reimburse_remark;
	}
	
	public String getReimburse_state() {
		return reimburse_state;
	}
	public void setReimburse_state(String reimburse_state) {
		this.reimburse_state = reimburse_state;
	}
	public String getReimburse_type() {
		return reimburse_type;
	}
	public void setReimburse_type(String reimburse_type) {
		this.reimburse_type = reimburse_type;
	}
	public double getTotal_money() {
		return total_money;
	}
	public void setTotal_money(double total_money) {
		this.total_money = total_money;
	}
	public Date getReimburse_time() {
		return reimburse_time;
	}
	public void setReimburse_time(Date reimburse_time) {
		this.reimburse_time = reimburse_time;
	}
	
	
}
