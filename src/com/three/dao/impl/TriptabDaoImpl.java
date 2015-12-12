package com.three.dao.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.lang.StringUtils;

import com.three.dao.BaseDao;
import com.three.dao.TriptabDao;
import com.three.db.Reimburse;
import com.three.db.Triptab;


public class TriptabDaoImpl implements TriptabDao {

	@Override
	public void insertTriptab(Triptab triptab) {
			BaseDao dao=new BaseDao();
			System.out.println("-------------新增申请-------------");
			String insertSql = "insert into triptab(employee_id,destination,type,reason,apply_time,start_time,end_time,schedule,remark,state,position,department,travel_state) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";  
			java.util.Date date=null;
			System.out.println("time:"+triptab.getApply_time());
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(triptab.getApply_time());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}     
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			Object insertParams[] = {triptab.getEmployee_id(),triptab.getDestination(),triptab.getType(),triptab.getReason(),sqlDate,triptab.getStart_time(),triptab.getEnd_time(),triptab.getSchedule(),triptab.getRemark(),"未审核",triptab.getPosition(),triptab.getDepartment(),triptab.getTravel_state()};  //问号表示参数)";  
			int insertCount;
			try {
				insertCount = dao.update(insertSql, insertParams);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public List<Triptab> queryTriptab(String apply_time, String state,
			String employee_id,int pageNow,int pageSize) {
		
		List<Triptab> list=null;
		try {
		BaseDao dao = new BaseDao();
		if(StringUtils.isBlank(apply_time) && StringUtils.isBlank(state))
		{
		String sql = "select * from triptab where employee_id='"+employee_id+"'limit "+pageNow+","+pageSize+"";
		list= dao.getList(sql, Triptab.class, null);
		}
		else if(StringUtils.isBlank(apply_time))
		{
			String sql = "select * from triptab where state='"+state+"'and employee_id='"+employee_id+"'limit "+pageNow+","+pageSize+"";
			list= dao.getList(sql, Triptab.class, null);
		}
		else if(StringUtils.isBlank(state))
		{
			String sql = "select * from triptab where apply_time='"+apply_time+"'and employee_id='"+employee_id+"'limit "+pageNow+","+pageSize+"";
			list= dao.getList(sql, Triptab.class, null);
		}
		else
		{
			String sql = "select * from triptab where state='"+state+"'and employee_id='"+employee_id+"'and apply_time='"+apply_time+"'limit "+pageNow+","+pageSize+"";
			list= dao.getList(sql, Triptab.class, null);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;
	}

	@Override
	public void UpdateTriptab(Triptab triptab, int travel_id) {
		BaseDao dao=new BaseDao();
		System.out.println("-------------新增申请-------------");
		String insertSql = "update triptab set destination=?,type=?,reason=?,start_time=?,end_time=?,schedule=?,remark=? where travel_id=?";  
		Object insertParams[] = {triptab.getDestination(),triptab.getType(),triptab.getReason(),triptab.getStart_time(),triptab.getEnd_time(),triptab.getSchedule(),triptab.getRemark(),travel_id};  //问号表示参数)";  
		int insertCount;
		try {
			insertCount = dao.update(insertSql, insertParams);
			System.out.print(insertCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public List<Triptab> queryTriptabInfor(int travel_id) {
		List<Triptab> list=null;
		try {
		BaseDao dao = new BaseDao();
		String sql = "select * from triptab where travel_id='"+travel_id+"'";
		list  = dao.getList(sql, Triptab.class, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;
	}

}
