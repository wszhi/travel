package com.lds.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;


import com.lds.entity.Budget;


public interface BudgetInterface {
	public void saveBudget(Budget budget) throws SQLException ;
	public Budget getBudgetById(int id) throws SQLException ;
	public void updateBudget(Budget budget) throws SQLException ;
	public void deleteBudget(Budget budget) throws SQLException ;
	
	/**
	 * 通过hql语句查询Budget信息
	 * @param str
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Budget> findBudget(String str) throws SQLException;
	public Budget getBudgetByTravelId(int TravelId);
}
