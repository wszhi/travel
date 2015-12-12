package com.three.dao;

import com.three.db.Employee;

public interface EmployeeDao {

	public  void insertEmployeeInfor(Employee employee);
	public  void UpdateEmployeeInfor(Employee employee,String employee_id);
	public  Employee queryEmployeeInfor(String employee_id);
}
