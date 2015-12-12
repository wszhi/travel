package com.three.db;

import java.util.Date;

public class Reimburse {
	private int reimburse_id;
	private String employee_id;
	private String department;
	private String reimburse_remark;
	private String manager_id;
	private String reimburse_state;
	private String reimburse_type;
	private double total_money;
	private double trans_totalmoney;
	private double other_totalmoney;
	private String reimburse_time;
	private int travel_id;
	
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getReimburse_remark() {
		return reimburse_remark;
	}
	public void setReimburse_remark(String reimburse_remark) {
		this.reimburse_remark = reimburse_remark;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
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
	public String getReimburse_time() {
		return reimburse_time;
	}
	public void setReimburse_time(String reimburse_time) {
		this.reimburse_time = reimburse_time;
	}
	public double getTrans_totalmoney() {
		return trans_totalmoney;
	}
	public void setTrans_totalmoney(double trans_totalmoney) {
		this.trans_totalmoney = trans_totalmoney;
	}
	public double getOther_totalmoney() {
		return other_totalmoney;
	}
	public void setOther_totalmoney(double other_totalmoney) {
		this.other_totalmoney = other_totalmoney;
	}
	public int getTravel_id() {
		return travel_id;
	}
	public void setTravel_id(int travel_id) {
		this.travel_id = travel_id;
	}
	
	
}
