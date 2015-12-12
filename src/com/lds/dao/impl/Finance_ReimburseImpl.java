package com.lds.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;


import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.lds.dao.interfaces.Finance_ReimburseInterface;
import com.lds.entity.Finance_reimburse;

@Repository
public class Finance_ReimburseImpl implements Finance_ReimburseInterface {

	private HibernateTemplate hibernateTemplate;

	private SessionFactory  sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(this.sessionFactory);
	}
	
	@Override
	public void saveFinance_reimburse(Finance_reimburse finance_Reimburse)
			throws SQLException {
		hibernateTemplate.save(finance_Reimburse);
	}

	@Override
	public Finance_reimburse getFinance_RemiburseById(int id)
			throws SQLException {
		Finance_reimburse finance_reimburse =  hibernateTemplate.get(Finance_reimburse.class,id);
		return finance_reimburse;
	}

	@Override
	public void updateFinance_Remiburse(Finance_reimburse finance_Reimburse)
			throws SQLException {
		hibernateTemplate.update(finance_Reimburse);
	}

	@Override
	public void deleteFinance_Remiburse(Finance_reimburse finance_Reimburse)
			throws SQLException {
		hibernateTemplate.delete(finance_Reimburse);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Finance_reimburse> findFinance_Reimburse(
			String str) throws SQLException {
		return (ArrayList<Finance_reimburse>) hibernateTemplate.find(str);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Finance_reimburse> getFinance_reimburseById(int travel_id)
			throws SQLException {
		String hql = "from Finance_reimburse where travel_id = " + travel_id;
		ArrayList<Finance_reimburse> afr = (ArrayList<Finance_reimburse>) hibernateTemplate.find(hql);
		return afr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Finance_reimburse> getFinance_reimburses()
			throws SQLException {
		String hql = "from Finance_reimburse";
		if(null != hibernateTemplate.find(hql)){
			ArrayList<Finance_reimburse> f = (ArrayList<Finance_reimburse>) hibernateTemplate.find(hql);
			return f;
		}else{
			return null;
		}
	}

}
