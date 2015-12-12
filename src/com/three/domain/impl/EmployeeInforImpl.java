package com.three.domain.impl;

import com.three.dao.EmployeeDao;
import com.three.db.Employee;
import com.three.domain.EmployeeInfor;

public class EmployeeInforImpl implements EmployeeInfor {

	private EmployeeDao employeeDao;
	@Override
	public void insertEmployeeInfor(Employee employee) {
		employeeDao.insertEmployeeInfor(employee);

	}

	@Override
	public void UpdateEmployeeInfor(Employee employee, String employee_id) {
		employeeDao.UpdateEmployeeInfor(employee, employee_id);

	}

	@Override
	public Employee queryEmployeeInfor(String employee_id) {
		
		return employeeDao.queryEmployeeInfor(employee_id);
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	

}
