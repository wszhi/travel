package com.three.domain;

import com.three.db.Employee;

public interface EmployeeInfor {

	public  void insertEmployeeInfor(Employee employee);
	public  void UpdateEmployeeInfor(Employee employee,String employee_id);
	public  Employee queryEmployeeInfor(String employee_id);
}
