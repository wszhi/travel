package com.three.db;

public class Login {
	private int login_id;
	private String employee_id;
	private String password;
	private String role;
	private int login_times;
	public int getLogin_times() {
		return login_times;
	}
	public void setLogin_times(int login_times) {
		this.login_times = login_times;
	}
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
