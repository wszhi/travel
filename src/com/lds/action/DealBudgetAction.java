package com.lds.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lds.dao.interfaces.BudgetInterface;
import com.lds.entity.Budget;
import com.lds.entity.Employee;
import com.lds.entity.Triptab;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DealBudgetAction extends ActionSupport {

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Triptab getTriptab() {
		return triptab;
	}

	public void setTriptab(Triptab triptab) {
		this.triptab = triptab;
	}

	public Budget getBudget() {
		return budget;
	}

	public BudgetInterface getBudgetInterface() {
		return budgetInterface;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}
	
	private Budget budget;
	private Employee employee;
	private Triptab triptab;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			if(null!=request.getParameter("submit") && request.getParameter("submit").equals("提交")){
				if(null!=request.getParameter("detail") && null != request.getParameter("budget_money")){
					employee = (Employee)request.getSession().getAttribute("employee");
					triptab = (Triptab) request.getSession().getAttribute("triptab");
					if(null != budgetInterface.getBudgetByTravelId(triptab.getTravel_id())){
						request.getSession().setAttribute("IsEmpty",true);
						return "success";
					}
					String detail = request.getParameter("detail");
					double money = Double.parseDouble(request.getParameter("budget_money"));
					budget = new Budget();
					budget.setTravel_detail(detail);
					budget.setBudget_money(money);
					budget.setEmployee_id(employee.getEmployee_id());
					budget.setTravel_id(triptab.getTravel_id());
					//鍔犺储鍔′汉鍛樺伐鍙�
					String xxxx = request.getSession().getAttribute("finance_id").toString();
					budget.setFinance_id(xxxx);
					request.getSession().setAttribute("budget", budget);
					budgetInterface.saveBudget(budget);
					ArrayList<Triptab> triptabs = (ArrayList<Triptab>) request.getSession().getAttribute("triptabs");
					ArrayList<Triptab> triptabs2 = new ArrayList<Triptab>();
					for (Triptab triptabx : triptabs) {
						if(triptabx.getTravel_id() != triptab.getTravel_id()){
							triptabs2.add(triptabx);
						}
					}
					if(null != triptabs2 && triptabs2.size()>0){
						request.getSession().setAttribute("triptabs", triptabs2);
					}else{
						request.getSession().setAttribute("triptabs", null);
					}
					return "success";
				}else{
					request.getSession().setAttribute("IsEmpty",true);
					return "update";
				}
			}else{
				budget = (Budget) request.getSession().getAttribute("budget");
				if(null!=request.getParameter("detail") && null != request.getParameter("budget_money")){
					String detail = request.getParameter("detail");
					double money = Double.parseDouble(request.getParameter("budget_money"));
					budget.setTravel_detail(detail);
					budget.setBudget_money(money);
					request.getSession().setAttribute("budget", budget);
					budget.setFinance_id("2012001002");
					budgetInterface.updateBudget(budget);
					request.getSession().setAttribute("IsEmpty",null);
					return "update";
				}else{
					request.getSession().setAttribute("IsEmpty",true);
					return "update";
				}
			}
		}catch(Exception e){
			return "error";
		}
	}

	public void setBudgetInterface(BudgetInterface budgetInterface) {
		this.budgetInterface = budgetInterface;
	}

	private BudgetInterface budgetInterface;
	
	
}
