package com.lds.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Finance_reimburse")
public class Finance_reimburse {
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getReimburse_time() {
		return reimburse_time;
	}
	public void setReimburse_time(Date reimburse_time) {
		this.reimburse_time = reimburse_time;
	}
	@Id @Column(name="real_reimburse_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int real_reimburse_id;
	private int reimburse_id;
	private int travel_id;
	private int budget_id;
	private double real_total_money;
	private String reimburse_detail;
	private Date start_time;
	private Date reimburse_time;
	public int getReal_reimburse_id() {
		return real_reimburse_id;
	}
	public void setReal_reimburse_id(int real_reimburse_id) {
		this.real_reimburse_id = real_reimburse_id;
	}
	public int getReimburse_id() {
		return reimburse_id;
	}
	public void setReimburse_id(int reimburse_id) {
		this.reimburse_id = reimburse_id;
	}
	public int getTravel_id() {
		return travel_id;
	}
	public void setTravel_id(int travel_id) {
		this.travel_id = travel_id;
	}
	public int getBudget_id() {
		return budget_id;
	}
	public void setBudget_id(int budget_id) {
		this.budget_id = budget_id;
	}
	public double getReal_total_money() {
		return real_total_money;
	}
	public void setReal_total_money(double real_total_money) {
		this.real_total_money = real_total_money;
	}
	public String getReimburse_detail() {
		return reimburse_detail;
	}
	public void setReimburse_detail(String reimburse_detail) {
		this.reimburse_detail = reimburse_detail;
	}
	
}
