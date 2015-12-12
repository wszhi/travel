package com.three.domain.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.three.dao.ReimburseDao;
import com.three.db.Other_expense;
import com.three.db.Reimburse;
import com.three.db.Trans;
import com.three.domain.Apply_Reimburse;

public class Apply_ReimburseImpl implements Apply_Reimburse {

	private ReimburseDao reimburseDao2;
	
	@Override
	@Transactional
	public void insertReimburse(Reimburse reimburse, List<Trans> transs,
			List<Other_expense> other_expenses) {
		reimburseDao2.insertReimburse(reimburse, transs, other_expenses);

	}
	@Override
	@Transactional
	public void UpdateReimburse(Reimburse reimburse, List<Trans> transs,
			List<Other_expense> other_expenses,int reimburse_id) {
		reimburseDao2.UpdateReimburse(reimburse, transs, other_expenses,reimburse_id);

	}

	@Override
	@Transactional
	public List<Reimburse> queryReimburse(String apply_time, String state,
			String employee_id,int pageNow,int pageSize) {
		// TODO Auto-generated method stub
		//System.out.println(reimburseDao.queryReimburse(apply_time, state, employee_id));
		return reimburseDao2.queryReimburse(apply_time, state, employee_id,pageNow,pageSize);
	}
	@Override
	@Transactional
	public List<Reimburse> queryReimburseInfor(int reimburse_id) {
		// TODO Auto-generated method stub
		return reimburseDao2.queryReimburseInfor(reimburse_id);
	}
	
	@Override
	public List<Trans> queryTransInfor(int reimburse_id) {
		// TODO Auto-generated method stub
		return reimburseDao2.queryTransInfor(reimburse_id);
	}

	@Override
	public List<Other_expense> queryOther_expenseInfor(int reimburse_id) {
		// TODO Auto-generated method stub
		return reimburseDao2.queryOther_expenseInfor(reimburse_id);
	}
	public void setReimburseDao2(ReimburseDao reimburseDao2) {
		this.reimburseDao2 = reimburseDao2;
	}
}
