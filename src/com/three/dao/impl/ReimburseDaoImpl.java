package com.three.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.three.dao.BaseDao;
import com.three.dao.ReimburseDao;
import com.three.db.DBManger;
import com.three.db.Other_expense;
import com.three.db.Reimburse;
import com.three.db.Trans;
import com.three.db.Triptab;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Repository;

@Repository
public class ReimburseDaoImpl implements ReimburseDao {


	@Override
	public void insertReimburse(Reimburse reimburse,List<Trans> transs,List<Other_expense> other_expenses) {
		/*HttpServletRequest request = ServletActionContext.getRequest();
		String[] Trans = request.getParameterValues("trans");
		for(int i=0;i<Trans.length;i++)
		  {
		  System.out.println(Trans[i]);
		  }*/
		BaseDao dao=new BaseDao();
		String sql="insert into reimburse(employee_id,department,reimburse_remark,reimburse_type,reimburse_time,total_money,reimburse_state,other_totalmoney,trans_totalmoney,travel_id) values(?,?,?,?,?,?,?,?,?,?)";
		String sql2="insert into trans(trans_start_time,trans_end_time,trans_start_address,trans_end_address,trans_money,reimburse_id) values(?,?,?,?,?,?)";
		String sql3="insert into other_expense(other_expense_name,other_expense_money,ticket_num,reimburse_id) values(?,?,?,?)";
		String insertSql = "update triptab set travel_state=? where travel_id=?";  
		int reimburse_id = 0;
		try {
		Connection conn = DBManger.Connect();
		PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);//传入参数：Statement.RETURN_GENERATED_KEYS
		//System.out.println("employee_id:"+reimburse.getEmployee_id());
		pstmt.setString(1,reimburse.getEmployee_id() );
		pstmt.setString(2, reimburse.getDepartment());
		pstmt.setString(3, reimburse.getReimburse_remark());
		System.out.println("type:"+reimburse.getReimburse_type());
		pstmt.setString(4, reimburse.getReimburse_type());
		System.out.println("time:"+reimburse.getReimburse_time());
		java.util.Date  date  =  new SimpleDateFormat("yyyy-MM-dd").parse(reimburse.getReimburse_time());     
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());  

		pstmt.setDate(5,sqlDate);
		pstmt.setDouble(6, reimburse.getTotal_money());
		pstmt.setString(7, "未审核");
		pstmt.setDouble(8, reimburse.getOther_totalmoney());
		pstmt.setDouble(9, reimburse.getTrans_totalmoney());
		pstmt.setDouble(10, reimburse.getTravel_id());
		pstmt.executeUpdate();
		ResultSet rs = pstmt.getGeneratedKeys();	
		rs.next();
		reimburse_id = rs.getInt(1);//取得id的值
		//System.out.println("reimburse_id:"+reimburse_id);
		//System.out.println("start_address:"+trans.getTrans_start_address());
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		try {
				for(Trans trans:transs)
				{
					System.out.println("trans.getTrans_start_address():"+trans.getTrans_start_address());
					if(StringUtils.isNotBlank(trans.getTrans_start_address()))
					{
				Object insertParams2[] = {trans.getTrans_start_time(),trans.getTrans_end_time(),trans.getTrans_start_address(),trans.getTrans_end_address(),trans.getTrans_money(),reimburse_id};  //问号表示参数)";  
				int insertCount3 = dao.update(sql2, insertParams2);
					}
				}
				for(Other_expense other_expense:other_expenses)
				{
					System.out.println("Other_expense_name:"+other_expense.getOther_expense_name());
					if(StringUtils.isNotBlank(other_expense.getOther_expense_name()))
					{
				Object insertParams3[] = {other_expense.getOther_expense_name(),other_expense.getOther_expense_money(),other_expense.getTicket_num(),reimburse_id};  //问号表示参数)";  
				int insertCount = dao.update(sql3, insertParams3);
					}
				}
				Object insertParams[] = {"已报销",reimburse.getTravel_id()};
				int insertCount = dao.update(insertSql, insertParams);
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}
	@Override
	public void UpdateReimburse(Reimburse reimburse,List<Trans> transs,List<Other_expense> other_expenses,int reimburse_id) {
		BaseDao dao = new BaseDao();
		String updateSql = "update reimburse set total_money=?,reimburse_type=?,reimburse_remark=?,other_totalmoney=?,trans_totalmoney=? where reimburse_id=?";  
		String updateSql2 = "update trans set trans_start_time=?,trans_end_time=?,trans_start_address=?,trans_end_address=?,trans_money=? where reimburse_id=?"; 
		String updateSql3 = "update other_expense set other_expense_name=?,other_expense_money=?,ticket_num=? where reimburse_id=?"; 
		try {
		Object params[] = {reimburse.getTotal_money(),reimburse.getReimburse_type(),reimburse.getReimburse_remark(),reimburse.getOther_totalmoney(),reimburse.getTrans_totalmoney(),reimburse_id};  //问号表示参数
		int deleteCount = dao.update(updateSql, params);
		System.out.println(deleteCount);
		for(Trans trans:transs)
		{
		Object params2[] = {trans.getTrans_start_time(),trans.getTrans_end_time(),trans.getTrans_start_address(),trans.getTrans_end_address(),trans.getTrans_money(),reimburse_id};
		int deleteCount2 = dao.update(updateSql2, params2);
		}
		for(Other_expense other_expense:other_expenses)
		{
		Object params3[] = {other_expense.getOther_expense_name(),other_expense.getOther_expense_money(),other_expense.getTicket_num(),reimburse_id};
		int deleteCount3 = dao.update(updateSql3, params3);
		System.out.println(reimburse_id);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}	

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reimburse> queryReimburse(String reimburse_time, String reimburse_state,String employee_id,int pageNow,int pageSize) {
		List<Reimburse> list=null;
		System.out.println("reimburse_time:"+reimburse_time);
		System.out.println("reimburse_state:"+reimburse_state);
		try {
		BaseDao dao = new BaseDao();
		if(StringUtils.isBlank(reimburse_state) && StringUtils.isBlank(reimburse_time))
		{
		String sql = "select * from reimburse where employee_id='"+employee_id+"'limit "+pageNow+","+pageSize+"";
		list  = dao.getList(sql, Reimburse.class,null);
		}
		else if(StringUtils.isBlank(reimburse_state))
		{
		String sql = "select * from reimburse where reimburse_time='"+reimburse_time+"'and employee_id='"+employee_id+"'limit "+pageNow+","+pageSize+"";
		list= dao.getList(sql, Reimburse.class, null);
		}
		else if(StringUtils.isBlank(reimburse_time))
		{
		String sql = "select * from reimburse where reimburse_state='"+reimburse_state+"'and employee_id='"+employee_id+"'limit "+pageNow+","+pageSize+"";
		list= dao.getList(sql, Reimburse.class, null);
		}
		else
		{
		String sql = "select * from reimburse where reimburse_state='"+reimburse_state+"'and employee_id='"+employee_id+"'and reimburse_time='"+reimburse_time+"'limit "+pageNow+","+pageSize+"";
		list= dao.getList(sql, Reimburse.class, null);
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;

	}
	@Override
	public List<Reimburse> queryReimburseInfor(int reimburse_id) {
		
		List<Reimburse> list=null;
		try {
		BaseDao dao = new BaseDao();
		//String sql = "select * from reimburse A inner join trans B on A.reimburse_id=B.reimburse_id inner join other_expense C on A.reimburse_id=C.reimburse_id";
		String sql = "select * from reimburse where reimburse_id='"+reimburse_id+"'";
		list  = dao.getList(sql, Reimburse.class, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;
	}
	@Override
	public List<Trans> queryTransInfor(int reimburse_id) {
		List<Trans> list=null;
		try {
		BaseDao dao = new BaseDao();
		//String sql = "select * from reimburse A inner join trans B on A.reimburse_id=B.reimburse_id inner join other_expense C on A.reimburse_id=C.reimburse_id";
		String sql = "select * from trans where reimburse_id='"+reimburse_id+"'";
		list  = dao.getList(sql, Trans.class, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;
	}
	@Override
	public List<Other_expense> queryOther_expenseInfor(int reimburse_id) {
		List<Other_expense> list=null;
		try {
		BaseDao dao = new BaseDao();
		//String sql = "select * from reimburse A inner join trans B on A.reimburse_id=B.reimburse_id inner join other_expense C on A.reimburse_id=C.reimburse_id";
		String sql = "select * from other_expense where reimburse_id='"+reimburse_id+"'";
		list  = dao.getList(sql, Other_expense.class, null);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;
	}

}
