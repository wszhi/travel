package com.lds.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;












import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.lds.dao.interfaces.BaseInterface;
import com.lds.entity.Department;
import com.lds.entity.Employee;
import com.lds.entity.Finance_reimburse;
import com.lds.entity.Other_expense;
import com.lds.entity.Reimburse;
import com.lds.entity.Trans;
import com.lds.entity.Triptab;
@Repository
public class BaseImpl implements BaseInterface {

	private HibernateTemplate hibernateTemplate;
	private SessionFactory  sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(this.sessionFactory);
	}
	@Override
	public Triptab getTriptab(int travel_id) {
		
		return hibernateTemplate.get(Triptab.class, travel_id);
	}

	@Override
	public Reimburse getReimburse(int reimburse_id) {
		return hibernateTemplate.get(Reimburse.class, reimburse_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Triptab> getTriptans(String state) {
		String hql = "from Triptab where state = '"+state+"'";
		ArrayList<Triptab> triptabs =  (ArrayList<Triptab>) hibernateTemplate.find(hql);
		return triptabs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Reimburse> getReimburses(String reimburse) {
		String hql = "from Reimburse where reimburse_state = '"+reimburse+"'";
		ArrayList<Reimburse> reimburses =  (ArrayList<Reimburse>) hibernateTemplate.find(hql);
		return reimburses;
	}

	
	//鏃堕棿瓒婂ぇ瓒婇潬鍓�
	public  static ArrayList<Triptab> sortByDown(ArrayList<Triptab> triptans){
		Collections.sort(triptans, new Comparator<Triptab>() {

			@Override
			public int compare(Triptab o1, Triptab o2) {

				Date d1 = o1.getApply_time();
				Date d2 = o2.getApply_time();
				if(d1.before(d2)){
					return 1;
				}else if(d1.after(d2)){
					return -1;
				}else{
					return 0;
				}
			}
		});
		return triptans;
	}
	
	public  static ArrayList<Triptab> sortByUp(ArrayList<Triptab> triptans){
		Collections.sort(triptans, new Comparator<Triptab>() {

			@Override
			public int compare(Triptab o1, Triptab o2) {

				Date d1 = o1.getApply_time();
				Date d2 = o2.getApply_time();
				if(d1.before(d2)){
					return -1;
				}else if(d1.after(d2)){
					return 1;
				}else{
					return 0;
				}
			}
		});
		return triptans;
	}
	
	public  static ArrayList<Finance_reimburse> sortByUp1(ArrayList<Finance_reimburse> finance_reimburse){
		Collections.sort(finance_reimburse, new Comparator<Finance_reimburse>() {

			@Override
			public int compare(Finance_reimburse o1, Finance_reimburse o2) {

				Date d1 = o1.getReimburse_time();
				Date d2 = o2.getReimburse_time();
				if(d1.before(d2)){
					return -1;
				}else if(d1.after(d2)){
					return 1;
				}else{
					return 0;
				}
			}
		});
		return finance_reimburse;
	}
	
	public  static ArrayList<Finance_reimburse> sortByDown1(ArrayList<Finance_reimburse> finance_reimburse){
		Collections.sort(finance_reimburse, new Comparator<Finance_reimburse>() {

			@Override
			public int compare(Finance_reimburse o1, Finance_reimburse o2) {

				Date d1 = o1.getReimburse_time();
				Date d2 = o2.getReimburse_time();
				if(d1.before(d2)){
					return 1;
				}else if(d1.after(d2)){
					return -1;
				}else{
					return 0;
				}
			}
		});
		return finance_reimburse;
	}

		
	@Override
	public ArrayList<Triptab> sortByStartTime(ArrayList<Triptab> triptans,boolean flag) {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		if(flag){
			BaseImpl.sortByUp(triptans);
		}else{
			BaseImpl.sortByDown(triptans);
		}
		return triptans;
	}

	
	//true鍏堟彁浜ゅ厛鏄剧ず鍦ㄥ墠锛宖alse鎸夋渶杩戞椂闂存帓搴�
	@Override
	public ArrayList<Finance_reimburse> sortByReimburseTime(
			ArrayList<Finance_reimburse> finance_reimburse,boolean flag) {
		
		if(flag){
			BaseImpl.sortByUp1(finance_reimburse);
		}else{
			BaseImpl.sortByDown1(finance_reimburse);
		}
		return finance_reimburse;
	}

	public static String DateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		String s = sdf.format(date);
		return s;
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Triptab> getTriptabs() {
		String hql = "from Triptab where state='通过'";
		ArrayList<Triptab> list = (ArrayList<Triptab>) hibernateTemplate.find(hql);
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Reimburse> getReimburses() {
		ArrayList<Reimburse> list = (ArrayList<Reimburse>) hibernateTemplate.find("from Reimburse");
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Triptab> getTriptansByManagerId(String manager_id) {
		String hql = "from Triptab where manager_id = '"+manager_id+"'";
		ArrayList<Triptab> triptans = (ArrayList<Triptab>) hibernateTemplate.find(hql);
		return triptans;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Employee getEmployee(String employee_id) {
		String hql = "from Employee where employee_id = '"+employee_id+"'";
		ArrayList<Employee> employee = (ArrayList<Employee>)hibernateTemplate.find(hql);
		if(null!= employee && employee.size()>0){
			Employee employee2 = employee.get(0);
			return employee2;
		}else{
			return null;
		}
	}
	
	@Override
	public Department getDepartmentById(int department_id) {
		Department department = hibernateTemplate.get(Department.class, department_id);
		return department;
	}
	@Override
	public void updateTriptab(Triptab triptab) {
		hibernateTemplate.update(triptab);
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Trans> getTrans(int reimburse_id) {
		String hql = "from Trans where reimburse_id = "+reimburse_id;
		ArrayList<Trans> trans = (ArrayList<Trans>) hibernateTemplate.find(hql);
		return trans;
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Other_expense> getOtherExpense(int reimburse_id) {
		String hql = "from Other_expense where reimburse_id = "+reimburse_id;
		ArrayList<Other_expense> other_expenses = (ArrayList<Other_expense>) hibernateTemplate.find(hql);
		return other_expenses;
	}
	@Override
	public void updateReimburse(Reimburse reimburse) {
		hibernateTemplate.update(reimburse);
	}
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Finance_reimburse> getFinance_reimburses() {
		String hql = "from Finance_reimburse";
		ArrayList<Finance_reimburse> finance_reimburses = (ArrayList<Finance_reimburse>) hibernateTemplate.find(hql);
		return finance_reimburses;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Reimburse getReimburseByTravelId(int travel_id) {
		String hql = "from Reimburse where travel_id = "+travel_id;
		ArrayList<Reimburse> reimburses = (ArrayList<Reimburse>)hibernateTemplate.find(hql);
		if(null != reimburses && reimburses.size()>0){
			return reimburses.get(0);
		}else{
			return null;
		}
	}

}


