package com.lds.service.interfaces;


import java.sql.SQLException;
import java.util.ArrayList;

import com.lds.entity.Budget;

public interface BudgetServiceInterface {
	
	/*
	 * 保存预算单信息
	 */
	public void saveBudget(Budget budget) throws SQLException;
	
	/*
	 * 更新预算单信息
	 */
	public void updateBudget(Budget budget) throws SQLException;
	
	/*
	 * 删除预算单信息
	 */
	public void deleteBudget(Budget budget) throws SQLException;
	
	/*
	 *通过id取的预算单信息 
	 */
	
	public Budget getBudget(int id) throws SQLException;
	/*
	 * 通过员工号或者财务部人员员工id取的预算单信息
	 * flag=true 搜索员工id号
	 * flag=false 搜索财务部人员号
	 */
	public ArrayList<Budget> getBudget(String emoloyee_id,boolean flag) throws SQLException;

	public Budget getBudgetByTravelId(int TravelId);
}
