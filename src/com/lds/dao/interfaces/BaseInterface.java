package com.lds.dao.interfaces;

import java.util.ArrayList;

import com.lds.entity.Department;
import com.lds.entity.Employee;
import com.lds.entity.Finance_reimburse;
import com.lds.entity.Other_expense;
import com.lds.entity.Reimburse;
import com.lds.entity.Trans;
import com.lds.entity.Triptab;

public interface BaseInterface {
	
	public ArrayList<Triptab> getTriptabs();
	
	public ArrayList<Reimburse> getReimburses();
	
	//通过id查看申请表信息
	public Triptab getTriptab(int travel_id);
	
	//通过id查看报销单信息
	public Reimburse getReimburse(int reimburse_id);
	
	//通过审批状态查看申请表信息
	public ArrayList<Triptab> getTriptans(String state);
	
	//通过状态查看报销单信息
	public ArrayList<Reimburse> getReimburses(String reimburse);
	
	//通过提交时间排序,true则按时间升序先提交先显示排列 false反之
	public ArrayList<Triptab> sortByStartTime(ArrayList<Triptab> triptans,boolean flag);
	
	//通过报销时间排序
	public ArrayList<Finance_reimburse> sortByReimburseTime(ArrayList<Finance_reimburse> finance_reimburse,boolean flag);
 	
	//通过manager_id查找申请表
	public ArrayList<Triptab> getTriptansByManagerId(String manager_id);
	
	//通过员工号查看员工信息
	public Employee getEmployee(String employee_id);
	
	//通过部门Id查找部门信息
	public Department getDepartmentById(int department_id);
	
	//更新申请表信息
	public void updateTriptab(Triptab triptab);
	
	//获取报销行程信息
	public ArrayList<Trans> getTrans(int reimburse_id);
	
	//获取其他消费信息
	public ArrayList<Other_expense> getOtherExpense(int reimburse_id);
	
	//更新报销单信息
	public void updateReimburse(Reimburse reimburse);
	
	//查找所有报销记录
	public ArrayList<Finance_reimburse> getFinance_reimburses();
	
	//通过travel_id查找报销单
	public Reimburse getReimburseByTravelId(int travel_id);

	
}
