package com.lds.action;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lds.dao.interfaces.BaseInterface;
import com.lds.entity.Department;
import com.lds.entity.Employee;
import com.lds.entity.Triptab;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ViewTriptabAction extends ActionSupport {
	
	private BaseInterface baseImpl;
	
	public void setBaseImpl(BaseInterface baseImpl) {
		this.baseImpl = baseImpl;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		HttpServletRequest request = ServletActionContext.getRequest();
		int index = Integer.parseInt(request.getParameter("jsParam"));
		ArrayList<Triptab> triptabs = (ArrayList<Triptab>) request.getSession().getAttribute("triptabs");
		Triptab triptab = triptabs.get(index-1); 
		request.getSession().setAttribute("triptab", triptab);
		ArrayList<Employee> employees = (ArrayList<Employee>) request.getSession().getAttribute("employees");
		System.out.println(employees);
		Employee employee  = null;
		if(index>0){
		 employee = employees.get(index-1);
		}
		request.getSession().setAttribute("employee", employee);
		Department department = baseImpl.getDepartmentById(employee.getDepartment_id());
		request.getSession().setAttribute("department", department);
		return "success";
	}

	
	
	
	
}
