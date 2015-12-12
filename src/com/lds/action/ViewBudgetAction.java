package com.lds.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lds.dao.interfaces.BudgetInterface;
import com.lds.entity.Budget;
import com.lds.entity.Triptab;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ViewBudgetAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		Triptab triptab = (Triptab)request.getSession().getAttribute("triptab");
		if(null != budgetInterface.getBudgetById(triptab.getTravel_id())){
			Budget budget = budgetInterface.getBudgetById(triptab.getTravel_id());
			request.getSession().setAttribute("budget", budget);
		}else{
			request.getSession().setAttribute("budget", null);
		}
		return "success";
	}

	public void setBudgetInterface(BudgetInterface budgetInterface) {
		this.budgetInterface = budgetInterface;
	}

	BudgetInterface budgetInterface;
	
	
	
	
}
