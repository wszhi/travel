package com.lds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Department")
public class Department {
	@Id @Column(name="department_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int department_id;
	private String department_name;
	private String department_manager;
	private String department_content;
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getDepartment_manager() {
		return department_manager;
	}
	public void setDepartment_manager(String department_manager) {
		this.department_manager = department_manager;
	}
	public String getDepartment_content() {
		return department_content;
	}
	public void setDepartment_content(String department_content) {
		this.department_content = department_content;
	}
	@Override
	public String toString() {
		return "Department [department_id=" + department_id
				+ ", department_name=" + department_name
				+ ", department_manager=" + department_manager
				+ ", department_content=" + department_content + "]";
	}
	
}
