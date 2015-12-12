package com.lds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Other_expense")
public class Other_expense {
	public int getReimburse_id() {
		return reimburse_id;
	}
	public void setReimburse_id(int reimburse_id) {
		this.reimburse_id = reimburse_id;
	}
	private String other_expense_name;
	private double other_expense_money;
	private int ticket_num;
	private int reimburse_id;
	@Id @Column(name="other_expense_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int other_expense_id;
	public String getOther_expense_name() {
		return other_expense_name;
	}
	public void setOther_expense_name(String other_expense_name) {
		this.other_expense_name = other_expense_name;
	}
	public double getOther_expense_money() {
		return other_expense_money;
	}
	public void setOther_expense_money(double other_expense_money) {
		this.other_expense_money = other_expense_money;
	}
	public int getTicket_num() {
		return ticket_num;
	}
	public void setTicket_num(int ticket_num) {
		this.ticket_num = ticket_num;
	}
	public int getOther_expense_id() {
		return other_expense_id;
	}
	public void setOther_expense_id(int other_expense_id) {
		this.other_expense_id = other_expense_id;
	}
	
}
