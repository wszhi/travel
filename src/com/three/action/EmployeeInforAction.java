package com.three.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.three.db.Employee;
import com.three.domain.EmployeeInfor;

public class EmployeeInforAction extends ActionSupport implements Preparable{

	private EmployeeInfor employeeInfor;
	private Employee employee;
	
	public String insertEmployeeInfor() {
		employeeInfor.insertEmployeeInfor(employee);
		return SUCCESS;

	}


	public String UpdateEmployeeInfor() {
		
		employeeInfor.UpdateEmployeeInfor(employee, employee.getEmployee_id());
		return SUCCESS;

	}


	public String queryEmployeeInfor() {
		//System.out.print(employee.getEmployee_id());
		employee=employeeInfor.queryEmployeeInfor(employee.getEmployee_id());
		HttpServletRequest request = ServletActionContext.getRequest();
		String s=request.getParameter("flag").toString();
		int flag= Integer.parseInt(s);
		if(flag==1){
			return "success1";
		}
		else if(flag==2){
			return "success2";
		}
		return s;
	}


	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		employee=null;
	}


	public EmployeeInfor getEmployeeInfor() {
		return employeeInfor;
	}


	public void setEmployeeInfor(EmployeeInfor employeeInfor) {
		this.employeeInfor = employeeInfor;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
