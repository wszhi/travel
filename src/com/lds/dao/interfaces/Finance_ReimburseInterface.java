package com.lds.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import com.lds.entity.Finance_reimburse;


public interface Finance_ReimburseInterface {
	public void saveFinance_reimburse(Finance_reimburse finance_Reimburse)throws SQLException;
	public Finance_reimburse getFinance_RemiburseById(int id) throws SQLException ;
	public void updateFinance_Remiburse(Finance_reimburse finance_Reimburse) throws SQLException ;
	public void deleteFinance_Remiburse(Finance_reimburse finance_Reimburse) throws SQLException ;
	public ArrayList<Finance_reimburse> getFinance_reimburseById(int travel_id) throws SQLException;
	public ArrayList<Finance_reimburse> getFinance_reimburses() throws SQLException ;
	/**
	 * 通过hql语句查询Finance_Reimburse信息
	 * @param str
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Finance_reimburse> findFinance_Reimburse(String str) throws SQLException;
}
