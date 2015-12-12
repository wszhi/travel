package com.three.db;

public class Budget {
	private int budget_id;
	private String employee_id;
	private int travel_id;
	private double budget_money;
	private String travel_detail;
	private String finance_id;
	public int getBudget_id() {
		return budget_id;
	}
	public void setBudget_id(int budget_id) {
		this.budget_id = budget_id;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public int getTravel_id() {
		return travel_id;
	}
	public void setTravel_id(int travel_id) {
		this.travel_id = travel_id;
	}
	public double getBudget_money() {
		return budget_money;
	}
	public void setBudget_money(double budget_money) {
		this.budget_money = budget_money;
	}
	public String getTravel_detail() {
		return travel_detail;
	}
	public void setTravel_detail(String travel_detail) {
		this.travel_detail = travel_detail;
	}
	public String getFinance_id() {
		return finance_id;
	}
	public void setFinance_id(String finance_id) {
		this.finance_id = finance_id;
	}
	@Override
	public String toString() {
		return "Budget [budget_id=" + budget_id + ", employee_id="
				+ employee_id + ", travel_id=" + travel_id + ", budget_money="
				+ budget_money + ", travel_detail=" + travel_detail
				+ ", finance_id=" + finance_id + "]";
	}
	
}
