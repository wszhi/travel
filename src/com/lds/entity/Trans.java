package com.lds.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity(name="Trans")
public class Trans {
	public int getReimburse_id() {
		return reimburse_id;
	}
	public void setReimburse_id(int reimburse_id) {
		this.reimburse_id = reimburse_id;
	}
	private Date trans_start_time;
	private Date trans_end_time;
	private String trans_start_address;
	private String trans_end_address;
	private double trans_money;
	private int reimburse_id;
	@Id @Column(name="trans_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int trans_id;
	public Date getTrans_start_time() {
		return trans_start_time;
	}
	public void setTrans_start_time(Date trans_start_time) {
		this.trans_start_time = trans_start_time;
	}
	public Date getTrans_end_time() {
		return trans_end_time;
	}
	public void setTrans_end_time(Date trans_end_time) {
		this.trans_end_time = trans_end_time;
	}
	public String getTrans_start_address() {
		return trans_start_address;
	}
	public void setTrans_start_address(String trans_start_address) {
		this.trans_start_address = trans_start_address;
	}
	public String getTrans_end_address() {
		return trans_end_address;
	}
	public void setTrans_end_address(String trans_end_address) {
		this.trans_end_address = trans_end_address;
	}
	public double getTrans_money() {
		return trans_money;
	}
	public void setTrans_money(double trans_money) {
		this.trans_money = trans_money;
	}
	public int getTrans_id() {
		return trans_id;
	}
	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}
	
	
	
}
