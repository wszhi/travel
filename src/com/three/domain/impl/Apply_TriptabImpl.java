package com.three.domain.impl;

import java.util.Date;
import java.util.List;

import com.three.dao.ReimburseDao;
import com.three.dao.TriptabDao;
import com.three.db.Triptab;
import com.three.domain.Apply_Triptab;

public class Apply_TriptabImpl implements Apply_Triptab {

	private TriptabDao triptabDao;
	@Override
	public void insertTriptab(Triptab triptab) {
		triptabDao.insertTriptab(triptab);

	}

	@Override
	public void UpdateTriptab(Triptab triptab, int travel_id) {
		triptabDao.UpdateTriptab(triptab, travel_id);

	}

	@Override
	public List<Triptab> queryTriptab(String apply_time, String state,
			String employee_id,int pageNow,int pageSize) {
		System.out.println(apply_time);
		System.out.println(state);
		System.out.println(employee_id);
		return triptabDao.queryTriptab(apply_time, state, employee_id,pageNow,pageSize);
	}

	@Override
	public List<Triptab> queryTriptabInfor(int travel_id) {
		
		return triptabDao.queryTriptabInfor(travel_id);
	}

	public void setTriptabDao(TriptabDao triptabDao) {
		this.triptabDao = triptabDao;
	}
	

}
