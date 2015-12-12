package com.lds.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Component;

import com.lds.dao.interfaces.BaseInterface;
import com.lds.dao.interfaces.BudgetInterface;
import com.lds.entity.Employee;
import com.lds.entity.Triptab;
import com.opensymphony.xwork2.ActionSupport;

@Component
@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	
	public void setBudgetInterface(BudgetInterface budgetInterface) {
		this.budgetInterface = budgetInterface;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BaseInterface getBaseImpl() {
		return baseImpl;
	}

	public void setBaseImpl(BaseInterface baseImpl) {
		this.baseImpl = baseImpl;
	}

	private BaseInterface baseImpl;
	private BudgetInterface budgetInterface;
	private String username;
	private String password;
	
	
	@Override
	public String execute(){
		try{
			ArrayList<Triptab> triptabs = new ArrayList<Triptab>();
			if(null!=baseImpl.getTriptabs()){
				triptabs = baseImpl.getTriptabs();
				System.out.println(triptabs);
			}
			ArrayList<Triptab> triptabs1 = new ArrayList<Triptab>();
			for (Triptab triptab : triptabs){
				if(null==budgetInterface.getBudgetByTravelId(triptab.getTravel_id())){
					triptabs1.add(triptab);
				}
			}
			HttpServletRequest request = ServletActionContext.getRequest();
			String finance_id = request.getParameter("finance_id");
			System.out.println(request.getSession().getAttribute("employee_id"));
			ArrayList<Employee> employees = new ArrayList<Employee>();
			for (Triptab triptab : triptabs1) {
				if(null != baseImpl.getEmployee(triptab.getEmployee_id())){
					Employee employee = baseImpl.getEmployee(triptab.getEmployee_id());
					employees.add(employee);
				}
			}
			System.out.println(employees+" "+triptabs1);
			request.getSession().setAttribute("triptabs", triptabs1);
			request.getSession().setAttribute("employees", employees);
			return "success";
		}catch(Exception e){
			return "error";
		}
	}

	public String query(){
		return "success";
	}
	
	
	
}
