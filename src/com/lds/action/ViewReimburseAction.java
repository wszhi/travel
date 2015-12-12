package com.lds.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lds.dao.interfaces.BaseInterface;
import com.lds.entity.Employee;
import com.lds.entity.Reimburse;
import com.lds.service.interfaces.Finance_reimburseServiceInterface;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ViewReimburseAction extends ActionSupport {
	public void setBaseInterface(BaseInterface baseInterface) {
		this.baseInterface = baseInterface;
	}

	@Override
	public String execute() throws Exception {
		ArrayList<Reimburse> reimburses =  baseInterface.getReimburses("Í¨¹ý");
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("reimburses", reimburses);
		ArrayList<Employee> employees = new ArrayList<Employee>();
		for (Reimburse reimburse : reimburses) {
			if(null!=baseInterface.getEmployee(reimburse.getEmployee_id())){
				Employee employee = baseInterface.getEmployee(reimburse.getEmployee_id());
				employees.add(employee);
			}
		}
		request.getSession().setAttribute("employees", employees);
		return "success";
	}

	public void setFinance_reimburseServiceInterface(
			Finance_reimburseServiceInterface finance_reimburseServiceInterface) {
		this.finance_reimburseServiceInterface = finance_reimburseServiceInterface;
	}

	@SuppressWarnings("unused")
	private Finance_reimburseServiceInterface finance_reimburseServiceInterface;
	
	private BaseInterface baseInterface;
}
