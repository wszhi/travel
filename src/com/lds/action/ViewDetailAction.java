package com.lds.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lds.dao.interfaces.BaseInterface;
import com.lds.entity.Department;
import com.lds.entity.Employee;
import com.lds.entity.Other_expense;
import com.lds.entity.Reimburse;
import com.lds.entity.Trans;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ViewDetailAction extends ActionSupport {
	public void setBaseInterface(BaseInterface baseInterface) {
		this.baseInterface = baseInterface;
	}


	private BaseInterface baseInterface;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		ArrayList<Reimburse> reimburses = (ArrayList<Reimburse>) request.getSession().getAttribute("reimburses");
		int index = Integer.parseInt(request.getParameter("jsParam"));
		Reimburse reimburse = reimburses.get(index-1);
		ArrayList<Employee> employees = (ArrayList<Employee>) request.getSession().getAttribute("employees");
		Employee employee = employees.get(index-1);
		request.getSession().setAttribute("employee", employee);
		Department department = baseInterface.getDepartmentById(employee.getDepartment_id());
		request.getSession().setAttribute("department", department);
		request.getSession().setAttribute("reimburse",reimburse);
		ArrayList<Trans> trans = baseInterface.getTrans(reimburse.getReimburse_id());
		ArrayList<Other_expense> other_expenses = baseInterface.getOtherExpense(reimburse.getReimburse_id()) ;
		request.getSession().setAttribute("trans", trans);
		request.getSession().setAttribute("other_expenses", other_expenses);
		return "success";
	}

}
