package com.test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.lds.dao.interfaces.BaseInterface;
import com.lds.dao.interfaces.BudgetInterface;
import com.lds.dao.interfaces.Finance_ReimburseInterface;
import com.lds.entity.Budget;
import com.lds.entity.Finance_reimburse;
import com.lds.entity.Triptab;
import com.lds.service.interfaces.BudgetServiceInterface;
import com.lds.service.interfaces.Finance_reimburseServiceInterface;



public class TestHibernate extends UnitTestBase{

	
	public  TestHibernate(){
		super("classpath:applicationContext.xml");
	}
	
	@Test
	public void test1() throws Exception{
		//BudgetImpl budgetImpl = super.getBean("budgetDao");
		if(null  != super.getBean("budgetInterface")){
			System.out.println(2);
			BudgetInterface budgetImpl = super.getBean("budgetInterface");
			Budget budget = budgetImpl.getBudgetById(3);
			System.out.println(budget.getBudget_money());
		}
	}
	@Test
	public void test2() throws Exception{
		
		BudgetInterface budget= super.getBean("budgetInterface");
		Budget budget2  = new Budget();
		budget2.setBudget_id(2);
		budget2.setBudget_money(1);
		budget2.setEmployee_id("2311111111");
		budget2.setFinance_id("2222222222");
		budget2.setTravel_detail("dfasfasfa");
		budget2.setTravel_id(1);
		budget.updateBudget(budget2);
	}
	
	@Test
	public void test3() throws Exception {
		BudgetServiceInterface budgetServiceInterface = super.getBean("budgetServiceInterface");
		ArrayList<Budget> budget= budgetServiceInterface.getBudget("1111111111",true);
		if(budget != null){
			System.out.println(budget.get(0));
		}
		budgetServiceInterface.deleteBudget(budget.get(0));
		
	}
	
	@Test
	public void test4(){
		BaseInterface baseInterface = super.getBean("BaseInterface");
		ArrayList<Triptab> reimburse =  baseInterface.getTriptabs();
		System.out.println(reimburse.get(0)+" "+reimburse.get(1));
		
	}
	
	@Test
	public void test5(){
		BaseInterface baseInterface = super.getBean("BaseInterface");
		ArrayList<Triptab> reimburse =  baseInterface.getTriptabs();
		System.out.println(reimburse.get(0).getApply_time()+" "+reimburse.get(1).getApply_time()+" "+reimburse.get(2).getApply_time());
		reimburse = baseInterface.sortByStartTime(reimburse,true);
		System.out.println(reimburse.get(0).getApply_time()+" "+reimburse.get(1).getApply_time()+" "+reimburse.get(2).getApply_time());
		reimburse = baseInterface.sortByStartTime(reimburse,false);
		System.out.println(reimburse.get(0).getApply_time()+" "+reimburse.get(1).getApply_time()+" "+reimburse.get(2).getApply_time());
	}
	
	
	@Test
	public void test6() throws Exception{
		Finance_ReimburseInterface finance_ReimburseInterface = super.getBean("finance_ReimburseInterface");
		System.out.println(finance_ReimburseInterface.getFinance_RemiburseById(1));
	}
	
	@Test
	public void test7() throws Exception {
		Finance_reimburseServiceInterface fs = super.getBean("finance_reimburseServiceInterface");
		Finance_reimburse fr =  fs.getFinance_reimburseById(1);
		System.out.println(fs.getFinance_reimburseById(1));
		fr.setReal_total_money(200.22);
		fs.updateFinance_reimburse(fr);
		System.out.println(fr.getReal_total_money());
		fs.deleteFinance_reimburse(fr);
		
	}
	
	@Test 
	public void test8() throws Exception{
		Finance_reimburseServiceInterface fs = super.getBean("finance_reimburseServiceInterface");
		Finance_reimburse fr =  fs.getFinance_reimburseByBudget_id(0);
		System.out.println(fr.getReal_reimburse_id());
	}

	@Test
	public void test9() throws Exception{
		BaseInterface bf = super.getBean("BaseInterface");
		ArrayList<Triptab> triptans =  bf.getTriptansByManagerId("2011099099");
		System.out.println(triptans.get(0)+"   "+triptans.get(1));
		Finance_ReimburseInterface fri= super.getBean("finance_ReimburseInterface");
		ArrayList<Finance_reimburse> f = fri.getFinance_reimburseById(2);
		System.out.println(f.get(0).getReal_total_money()+" " +f.get(1).getReal_reimburse_id() );
	}
	
	@Test
	public void test10() throws Exception{
		Finance_reimburseServiceInterface f = super.getBean("finance_reimburseServiceInterface");
			if(null!=f.getFinance_reimburseByEmployee_id("2011099099", false)){
				ArrayList<Finance_reimburse> af = f.getFinance_reimburseByEmployee_id("2011099099", false);
				System.out.println(af.get(1).getReal_total_money());
			}else{
				//System.out.println("鏃犺褰�);
			}
		
	}
	
	
	@Test
	public void test11() throws Exception{
		Finance_reimburseServiceInterface f = super.getBean("finance_reimburseServiceInterface");
		ArrayList<Finance_reimburse> f1 =  f.getFinance_reimburseByEmployee_id("231111111", "2011001001");
		if(null != f1&&f1.size()>0){
		System.out.println(f1.get(0).getReal_total_money());
		}else{
			//System.out.println("");
		}
	}
	
	@Test
	public void test12 () throws Exception{
		Finance_reimburseServiceInterface f = super.getBean("finance_reimburseServiceInterface");
		String s =  "2015-07-16 14:20:50";
		String s1 = "2015-07-14 14:20:50";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = sdf.parse(s);
		Date d1= sdf.parse(s1);
		System.out.println(d+" "+d1);
		ArrayList<Finance_reimburse> fr =  f.getFinance_reimburses("2012001001", "2011001001", d1, d);
		if(fr != null && fr.size() != 0){
			System.out.println(fr.size());
		}else{
			//System.out.println("鏈壘鍒拌褰�);
		}
	}
	
	@Test
	public void test13() throws Exception{
		Finance_reimburseServiceInterface f = super.getBean("finance_reimburseServiceInterface");
		String s =  "2015-07-16 14:20:50";
		String s1 = "2015-07-14 14:20:50";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = sdf.parse(s);
		Date d1= sdf.parse(s1);
		System.out.println(d1.before(d));
		ArrayList<Finance_reimburse> fr = f.getFinance_reimburses("2011001001", "2011001001", d1, d);
		System.out.println(fr.size()+" "+fr.get(0).getReal_reimburse_id());
		
	}
	
	@Test
	public void test14() {
		BaseInterface baseInterface = super.getBean("BaseInterface");
		System.out.println(baseInterface.getTriptabs());
	}
	
	@Test
	public void test15() throws SQLException{
		BudgetInterface budgetInterface = super.getBean("budgetInterface");
		Budget budget = new Budget();
		budget.setBudget_money(100.0);
		budget.setEmployee_id("2000000000");
		budget.setFinance_id("1000000000");
		budget.setTravel_detail("dsnakdmsa");
		budget.setTravel_id(1);
		budgetInterface.saveBudget(budget);
	}
}
