package com.lds.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lds.dao.interfaces.BaseInterface;
import com.lds.dao.interfaces.BudgetInterface;
import com.lds.entity.Employee;
import com.lds.entity.Finance_reimburse;
import com.lds.entity.Triptab;
import com.lds.service.interfaces.Finance_reimburseServiceInterface;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchForFinanceAction extends ActionSupport {
	public void setFinance_reimburses(
			ArrayList<Finance_reimburse> finance_reimburses) {
		this.finance_reimburses = finance_reimburses;
	}
	public void setFemployees(ArrayList<Employee> femployees) {
		this.femployees = femployees;
	}
	public void setFtriptabs(ArrayList<Triptab> ftriptabs) {
		this.ftriptabs = ftriptabs;
	}
	public void setFinance_records(ArrayList<Finance_record> finance_records) {
		this.finance_records = finance_records;
	}
	private Finance_reimburseServiceInterface finance_reimburseServiceInterface;
	private BaseInterface baseInterface;
	@SuppressWarnings("unused")
	private BudgetInterface budgetInterface;
	private ArrayList<Finance_reimburse> finance_reimburses;
	private ArrayList<Employee>  femployees;
	private ArrayList<Triptab> ftriptabs;
	private ArrayList<Finance_record> finance_records;
	
	@Override
	public String execute() throws Exception {
		femployees = new ArrayList<Employee>();
		ftriptabs = new ArrayList<Triptab>();
		finance_records = new ArrayList<Finance_record>();
		finance_reimburses = new ArrayList<Finance_reimburse>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String employee_id = request.getParameter("employee_id");
		String manager_id = request.getParameter("manager_id");
		String start_time = request.getParameter("start_time");
		String reimburse_time = request.getParameter("reimburse_time");
		String button = request.getParameter("search");
		System.out.println(employee_id+"|"+reimburse_time);
		request.getSession().setAttribute("button", button);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date start = new Date();
		Date end = new Date();
		if(null==employee_id || employee_id.length() != 10){
			employee_id = null;
		}
		if(null == manager_id || manager_id.length() != 10){
			manager_id = null;
		}
		if(null == start_time || start_time.length() == 0){
			start_time = null;
			start = null;
		}else{
			start = sdf.parse(start_time);
		}
		if(null == reimburse_time || reimburse_time.length() == 0){
			end = null;
		}else{
			end = sdf.parse(reimburse_time);
		}
		if(null!=finance_reimburseServiceInterface.getFinance_reimburses(employee_id, manager_id, start, end)){
			finance_reimburses = finance_reimburseServiceInterface.getFinance_reimburses(employee_id, manager_id, start, end);
			if(null!=finance_reimburses &&finance_reimburses.size()>1){
				baseInterface.sortByReimburseTime(finance_reimburses, true);
			}
			for (Finance_reimburse finance_reimburse : finance_reimburses) {
				Triptab triptab = baseInterface.getTriptab(finance_reimburse.getTravel_id());
				ftriptabs.add(triptab);
				Employee employee = baseInterface.getEmployee(triptab.getEmployee_id());
				femployees.add(employee);
			}
			String s;
			for(int i = 0;i<femployees.size();i++){
				Triptab triptab = ftriptabs.get(i);
				Employee employee = femployees.get(i);
				Finance_reimburse finance_reimburse = finance_reimburses.get(i);
				Finance_record finance_record = new Finance_record();
				finance_record.setTravel_id(triptab.getTravel_id());
				finance_record.setEmployee_id(employee.getEmployee_id());
				finance_record.setEmployee_name(employee.getName());
				finance_record.setManager_id(triptab.getManager_id());
				Employee employee2 = baseInterface.getEmployee(triptab.getManager_id());
				finance_record.setManager_name(employee2.getName());
				finance_record.setReason(triptab.getReason());
				s = sdf.format(finance_reimburse.getReimburse_time());
				finance_record.setReimburse_time(s);
				finance_record.setTotal_money(finance_reimburse.getReal_total_money());
				finance_records.add(finance_record);
			}
		}
		request.getSession().setAttribute("finance_records", finance_records);
		return "success";
	}
	public void setFinance_reimburseServiceInterface(
			Finance_reimburseServiceInterface finance_reimburseServiceInterface) {
		this.finance_reimburseServiceInterface = finance_reimburseServiceInterface;
	}
	public void setBaseInterface(BaseInterface baseInterface) {
		this.baseInterface = baseInterface;
	}
	public void setBudgetInterface(BudgetInterface budgetInterface) {
		this.budgetInterface = budgetInterface;
	}
	
}
