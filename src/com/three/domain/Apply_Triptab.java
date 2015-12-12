package com.three.domain;

import java.util.Date;
import java.util.List;

import com.three.db.Triptab;

public interface Apply_Triptab {

	public  void insertTriptab(Triptab triptab);
	public  void UpdateTriptab(Triptab triptab,int travel_id);
	public  List<Triptab> queryTriptab(String apply_time,String state,String employee_id,int pageNow,int pageSize);
	public  List<Triptab> queryTriptabInfor(int travel_id);
}
