package com.lds.service.interfaces;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.lds.entity.Finance_reimburse;

public interface Finance_reimburseServiceInterface {
	
	//保存报销记录
	public void saveFinance_reimburse(Finance_reimburse finance_reimburse) throws SQLException;
	
	//更新报销记录
	public void updateFinance_reimburse(Finance_reimburse finance_reimburse) throws SQLException;
	
	//删除报销记录
	public void deleteFinance_reimburse(Finance_reimburse finance_reimburse) throws SQLException;
	
	//通过id查找记录
	public Finance_reimburse getFinance_reimburseById(int real_reimburse) throws SQLException;
	
	//通过预算单id查找
	public Finance_reimburse getFinance_reimburseByBudget_id(int budget_id) throws SQLException;
	
	//通过travel_id查找记录
	/**
	 * 
	 * @param employee_id--------员工号
	 * @param flag-----根据true or false判断是通过员工号查找还是领导工号查找
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Finance_reimburse> getFinance_reimburseByEmployee_id(String employee_id,boolean flag) throws SQLException;
	
	/*
	 * 通过员工号和领导工号同时查找记录
	 */
	
	public ArrayList<Finance_reimburse> getFinance_reimburseByEmployee_id(String employee_id,String manager_id) throws SQLException;
	
	//通过开始或者报销时间查找报销记录 true为开始时间查找
	public ArrayList<Finance_reimburse> getFinance_reimburseByTime(Date start_time,boolean flag) throws Exception;
	
	//通过两个时间查找记录
	public ArrayList<Finance_reimburse> getFinance_reimburseByTime(Date start_time,Date reimburse_time) throws Exception;
	
	//通过四个条件查找记录:员工号，领导工号，开始结束时间
	public ArrayList<Finance_reimburse> getFinance_reimburses(String employee_id,String manager_id,Date start_time,Date reimburse_time) throws Exception;
	
	//查找时间段内报销记录
	public ArrayList<Finance_reimburse> getFinance_reimburses(Date start,Date end);

	
}
