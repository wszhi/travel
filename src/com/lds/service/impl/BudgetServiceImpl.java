package com.lds.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import com.lds.dao.interfaces.BudgetInterface;
import com.lds.entity.Budget;
import com.lds.service.interfaces.BudgetServiceInterface;

public class BudgetServiceImpl implements BudgetServiceInterface {

	//private ClassPathXmlApplicationContext context;
	
	

	//private String springXmlPath = "classpath:applicationContext.xml";

	public BudgetInterface getBudgetInterface() {
		return budgetInterface;
	}

	public void setBudgetInterface(BudgetInterface budgetInterface) {
		this.budgetInterface = budgetInterface;
	}

	private BudgetInterface budgetInterface;
	
	
	
	public BudgetServiceImpl() {

	}
	
/*	public void init(){
		if(StringUtils.isEmpty(springXmlPath)){
			springXmlPath = "classpath*:spring-*.xml";
		}try{
			context = new ClassPathXmlApplicationContext(springXmlPath.split("[,\\s]+"));
			context.start();
		}catch(BeansException e){
			e.printStackTrace();
		}
	}
	
	public void after(){
		context.destroy();
	}
	*/
/*	protected <T extends Object>T getBean(String beanId){
		return (T)context.getBean(beanId);
	}
	
	protected <T extends Object>T getBean(Class<T> clazz){
		return (T)context.getBean(clazz);
	}
	
	public BudgetServiceImpl(String springXml){
		this.springXmlPath = springXml;
	}
	*/
	@Override
	public void saveBudget(Budget budget) throws SQLException{
		budgetInterface.saveBudget(budget);
	}

	@Override
	public void updateBudget(Budget budget) throws SQLException{
		budgetInterface.updateBudget(budget);
	}

	@Override
	public void deleteBudget(Budget budget) throws SQLException{
		// TODO 自动生成的方法存根
		budgetInterface.deleteBudget(budget);
	}

	@Override
	public Budget getBudget(int id) throws SQLException{
		Budget budget = budgetInterface.getBudgetById(id);
		return budget;
		
	}

	@Override
	public ArrayList<Budget> getBudget(String emoloyee_id,boolean flag) throws SQLException{
		ArrayList<Budget> budget = null;
		if(flag){
			String hql = "from Budget where employee_id =  '"+emoloyee_id+"'";
			if(null != budgetInterface.findBudget(hql)){
				budget = budgetInterface.findBudget(hql);
			}
		}else{
			String hql = "from Budget where finance_id =  '"+emoloyee_id+"'";
			if(null != budgetInterface.findBudget(hql)){
				budget = budgetInterface.findBudget(hql);
			}
		}
		if(null != budget && budget.size()>0){
			return budget;
		}else{
			return null;
		}
	}

	@Override
	public Budget getBudgetByTravelId(int TravelId) {
		return budgetInterface.getBudgetByTravelId(TravelId);
	}

}
