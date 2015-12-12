package com.lds.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lds.dao.interfaces.BaseInterface;
import com.lds.dao.interfaces.BudgetInterface;
import com.lds.entity.Department;
import com.lds.entity.Employee;
import com.lds.entity.Triptab;
import com.lds.service.interfaces.Finance_reimburseServiceInterface;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchTriptabAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		@SuppressWarnings("unchecked")
		ArrayList<Finance_record> finance_records = (ArrayList<Finance_record>) request.getSession().getAttribute("finance_records");
		int index =Integer.parseInt(request.getParameter("index"));		
		Finance_record finance_record = finance_records.get(index-1);
		Triptab triptab = baseInterface.getTriptab(finance_record.getTravel_id());
		Employee employee = baseInterface.getEmployee(triptab.getEmployee_id());
		Department department = baseInterface.getDepartmentById(employee.getDepartment_id());
		request.getSession().setAttribute("triptab", triptab);
		request.getSession().setAttribute("employee", employee);
		request.getSession().setAttribute("department", department);
		return "success";
	}
	public void setFinance_reimburseServiceInterface(
			Finance_reimburseServiceInterface finance_reimburseServiceInterface) {
		this.finance_reimburseServiceInterface = finance_reimburseServiceInterface;
	}
	public void setBudgetInterface(BudgetInterface budgetInterface) {
		this.budgetInterface = budgetInterface;
	}
	public void setBaseInterface(BaseInterface baseInterface) {
		this.baseInterface = baseInterface;
	}
	@SuppressWarnings("unused")
	private Finance_reimburseServiceInterface finance_reimburseServiceInterface;
	@SuppressWarnings("unused")
	private BudgetInterface budgetInterface;
	private BaseInterface baseInterface;
	
	
	
}
