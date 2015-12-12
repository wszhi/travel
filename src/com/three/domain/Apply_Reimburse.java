package com.three.domain;

import java.util.Date;
import java.util.List;

import com.three.db.Other_expense;
import com.three.db.Reimburse;
import com.three.db.Trans;

public interface Apply_Reimburse {

	public  void insertReimburse(Reimburse reimburse,List<Trans> transs,List<Other_expense> other_expenses);
	public  void UpdateReimburse(Reimburse reimburse,List<Trans> transs,List<Other_expense> other_expenses,int reimburse_id);
	public  List<Reimburse> queryReimburse(String apply_time,String state,String employee_id,int pageNow,int pageSize);
	public  List<Reimburse> queryReimburseInfor(int reimburse_id);
	public  List<Trans> queryTransInfor(int reimburse_id);
	public  List<Other_expense> queryOther_expenseInfor(int reimburse_id);
}
