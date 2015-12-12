package com.lds.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lds.dao.interfaces.BaseInterface;
import com.lds.dao.interfaces.BudgetInterface;
import com.lds.entity.Budget;
import com.lds.entity.Employee;
import com.lds.entity.Finance_reimburse;
import com.lds.entity.Reimburse;
import com.lds.entity.Triptab;
import com.lds.service.interfaces.Finance_reimburseServiceInterface;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BackViewReimburseAction extends ActionSupport {
	public void setBudgetInterface(BudgetInterface budgetInterface) {
		this.budgetInterface = budgetInterface;
	}

	public void setFinance_reimburse(Finance_reimburse finance_reimburse) {
		this.finance_reimburse = finance_reimburse;
	}

	private Finance_reimburse finance_reimburse;
	public void setBaseInterface(BaseInterface baseInterface) {
		this.baseInterface = baseInterface;
	}

	@Override
	public String execute() throws Exception {
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			Reimburse reimburse1 = (Reimburse) request.getSession().getAttribute("reimburse");
			System.out.println(reimburse1);
			Budget budget = budgetInterface.getBudgetByTravelId(reimburse1.getTravel_id());
			System.out.println("111111111111111111111111111");
			reimburse1.setReimburse_state("已报销");
			System.out.println("4444444444444444");
			System.out.println(budget+"  "+budget.getTravel_id());
			Triptab triptab = baseInterface.getTriptab(budget.getTravel_id());
			System.out.println("333333333333333");
			baseInterface.updateReimburse(reimburse1);
			String detail = request.getParameter("detail");
			double money = Double.parseDouble(request.getParameter("money"));
			System.out.println("222222222222222222222222222");
			finance_reimburse = new Finance_reimburse();
			finance_reimburse.setBudget_id(budget.getBudget_id());
			finance_reimburse.setReal_total_money(money);
			finance_reimburse.setReimburse_detail(detail);
			finance_reimburse.setReimburse_id(reimburse1.getReimburse_id());
			finance_reimburse.setTravel_id(reimburse1.getTravel_id());
			finance_reimburse.setStart_time(triptab.getStart_time());
			finance_reimburse.setReimburse_time(reimburse1.getReimburse_time());
			finance_reimburseServiceInterface.saveFinance_reimburse(finance_reimburse);
			ArrayList<Reimburse> reimburses =  baseInterface.getReimburses("通过");
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
		}catch(Exception e){
			return "error";
		}
	}

	public void setFinance_reimburseServiceInterface(
			Finance_reimburseServiceInterface finance_reimburseServiceInterface) {
		this.finance_reimburseServiceInterface = finance_reimburseServiceInterface;
	}

	private Finance_reimburseServiceInterface finance_reimburseServiceInterface;
	
	private BaseInterface baseInterface;
	
	private BudgetInterface budgetInterface;
}
