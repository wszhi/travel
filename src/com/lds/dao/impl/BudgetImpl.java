package com.lds.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.lds.dao.interfaces.BudgetInterface;
import com.lds.entity.Budget;
@Repository
public class BudgetImpl implements BudgetInterface{

	private HibernateTemplate hibernateTemplate;

	private SessionFactory  sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(this.sessionFactory);
	}
	
	
	@Override
	public void saveBudget(Budget budget) throws SQLException {
		
		hibernateTemplate.save(budget);
	}

	@Override
	public Budget getBudgetById(int id) throws SQLException {
		// TODO 自动生成的方法存根
		Budget budget = hibernateTemplate.get(Budget.class, id);
		return budget;
	}

	@Override
	public void updateBudget(Budget budget) throws SQLException {
		// TODO 自动生成的方法存根
		hibernateTemplate.update(budget);
	}

	@Override
	public void deleteBudget(Budget budget) throws SQLException {
		// TODO 自动生成的方法存根
		hibernateTemplate.delete(budget);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Budget> findBudget(String str) throws SQLException {
		// TODO 自动生成的方法存根
		return (ArrayList<Budget>) hibernateTemplate.find(str);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Budget getBudgetByTravelId(int TravelId) {
		String hql = "from Budget where travel_id = "+TravelId;
		if(null!=hibernateTemplate.find(hql)&& hibernateTemplate.find(hql).size()>0){
			ArrayList<Budget> a = (ArrayList<Budget>) hibernateTemplate.find(hql);
			return a.get(0);
		}
		return null;
	}

}
