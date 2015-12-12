package com.three.dao.impl;

import java.sql.SQLException;





import javax.swing.JOptionPane;

import com.three.dao.BaseDao;
import com.three.dao.EmployeeDao;
import com.three.db.Employee;
import com.three.db.Login;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void insertEmployeeInfor(Employee employee) {
		BaseDao dao=new BaseDao();
		String insertSql = "update employee set name=?,sex=?,birth=?,tel=?,address=?,email=?,Identity_num=?,entry_time=? where employee_id=?";  
		Object insertParams[] = {employee.getName(),employee.getSex(),employee.getBirth(),employee.getTel(),employee.getAddress(),employee.getEmail(),employee.getIdentity_num(),employee.getEntry_time(),employee.getEmployee_id()};  //问号表示参数)";  
		try {
			int insertCount = dao.update(insertSql, insertParams);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void UpdateEmployeeInfor(Employee employee,String employee_id) {
		BaseDao dao=new BaseDao();
		String updateSql = "update employee set name=?,birth=?,tel=?,address=?,email=? where employee_id=?";  
		
		Object params[] = {employee.getName(),employee.getBirth(),employee.getTel(),employee.getAddress(),employee.getEmail(),employee.getEmployee_id()};  //问号表示参数
		System.out.print(employee.getEmployee_id());
		int updateCount;
		try {
			updateCount = dao.update(updateSql, params);
			System.out.print(updateCount);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Employee queryEmployeeInfor(String employee_id) {
		BaseDao dao=new BaseDao();
		Employee entity=null;
		String singleSql ="select * from employee where employee_id ='"+employee_id+"'";
		try {
			entity = (Employee) dao.getSingle(singleSql, Employee.class,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

}
