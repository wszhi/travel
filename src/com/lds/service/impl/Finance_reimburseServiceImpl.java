package com.lds.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.lds.dao.interfaces.BaseInterface;
import com.lds.dao.interfaces.BudgetInterface;
import com.lds.dao.interfaces.Finance_ReimburseInterface;
import com.lds.entity.Budget;
import com.lds.entity.Finance_reimburse;
import com.lds.entity.Triptab;
import com.lds.service.interfaces.Finance_reimburseServiceInterface;

public class Finance_reimburseServiceImpl implements
		Finance_reimburseServiceInterface {

//	private ClassPathXmlApplicationContext context ;
	
	public Finance_ReimburseInterface getFrs() {
		return frs;
	}


	public void setFrs(Finance_ReimburseInterface frs) {
		this.frs = frs;
	}


	public BudgetInterface getBi() {
		return bi;
	}


	public void setBi(BudgetInterface bi) {
		this.bi = bi;
	}


	public BaseInterface getBaseInterface() {
		return baseInterface;
	}


	public void setBaseInterface(BaseInterface baseInterface) {
		this.baseInterface = baseInterface;
	}

	//private String springXmlPath = "classpath:applicationContext.xml";
	private Finance_ReimburseInterface frs;
	private BudgetInterface bi;
	private BaseInterface baseInterface;
	
	
	private Finance_reimburseServiceImpl() {
	}
	
	
	@Override
	public void saveFinance_reimburse(Finance_reimburse finance_reimburse)
			throws SQLException {
		frs.saveFinance_reimburse(finance_reimburse);

	}
	
/*	public Finance_reimburseServiceImpl(String springXml){
		this.springXmlPath = springXml;
	}
	
	public void init(){
		if(StringUtils.isEmpty(springXmlPath)){
			springXmlPath = "classpath*:spring-*.xml";
		}try{
			context = new ClassPathXmlApplicationContext(springXmlPath.split("[,\\s]+"));
			context.start();
		}catch(BeansException e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings(value = { "unchecked" })
	protected <T extends Object>T getBean(String beanId){
		return (T)context.getBean(beanId);
	}
	
	protected <T extends Object>T getBean(Class<T> clazz){
		return (T)context.getBean(clazz);
	}
	
	public void after(){
		context.destroy();
	}
*/
	@Override
	public void updateFinance_reimburse(Finance_reimburse finance_reimburse)
			throws SQLException {
		frs.updateFinance_Remiburse(finance_reimburse);
	}

	@Override
	public void deleteFinance_reimburse(Finance_reimburse finance_reimburse)
			throws SQLException {
		frs.deleteFinance_Remiburse(finance_reimburse);
	}

	@Override
	public Finance_reimburse getFinance_reimburseById(int real_reimburse)
			throws SQLException {
		if(null!=frs.getFinance_RemiburseById(real_reimburse)){
			Finance_reimburse finance_reimburse = frs.getFinance_RemiburseById(real_reimburse);
			return finance_reimburse;
		}else{
			return null;
		}
	}

	@Override
	public Finance_reimburse getFinance_reimburseByBudget_id(int budget_id)
			throws SQLException {
		String hql = "from Finance_reimburse where budget_id = "+budget_id;
		ArrayList<Finance_reimburse> afr =  frs.findFinance_Reimburse(hql);
		if(null!= afr && afr.size()>0){
			return afr.get(0);
		}else{
			return null;
		}
	}

	@Override
	public ArrayList<Finance_reimburse> getFinance_reimburseByEmployee_id(
			String employee_id, boolean flag) throws SQLException {
		ArrayList<Finance_reimburse> afr = new ArrayList<Finance_reimburse>();
		ArrayList<Triptab> triptabs = new ArrayList<Triptab>();
		if(flag){
			String hql = "from Budget where employee_id = '"+employee_id+"'";
			if(null != bi.findBudget(hql) ){
				ArrayList<Budget> ab = bi.findBudget(hql);
				for(int i = 0;i<ab.size();i++){
					Finance_reimburse frTemp = getFinance_reimburseByBudget_id(ab.get(i).getBudget_id());
					if(null != frTemp){
						afr.add(frTemp);
					}
				}
			}
		}else{
			if(null != baseInterface.getTriptansByManagerId(employee_id)){
				triptabs = baseInterface.getTriptansByManagerId(employee_id);
				for(int i = 0;i<triptabs.size();i++){
					Finance_ReimburseInterface f = frs;
					if(null != f.getFinance_reimburseById(triptabs.get(i).getTravel_id())){
						ArrayList<Finance_reimburse> t = f.getFinance_reimburseById(triptabs.get(i).getTravel_id());
						if(null != t && t.size()>0){
							afr.add(t.get(0));
						}
					}
				}
			}
		}
		return afr;
	}

	@Override
	public ArrayList<Finance_reimburse> getFinance_reimburseByEmployee_id(
			String employee_id, String manager_id) throws SQLException {
		ArrayList<Finance_reimburse> af1 = new ArrayList<Finance_reimburse>();
		ArrayList<Finance_reimburse> af2 = new ArrayList<Finance_reimburse>();
		if(null != getFinance_reimburseByEmployee_id(employee_id, true)){
			 af1 = getFinance_reimburseByEmployee_id(employee_id, true);
		}else{
			return null;
		}
		if(null != getFinance_reimburseByEmployee_id(manager_id, false)){
			af2 = getFinance_reimburseByEmployee_id(manager_id, false);
		}else{
			return null;
		}
		if(null != y(af1, af2) && y(af1, af2).size()>0){
			return y(af1, af2);
		}else{
			return null;
		}
	}

	public static ArrayList<Finance_reimburse> y(ArrayList<Finance_reimburse> a,ArrayList<Finance_reimburse> b){
		ArrayList<Finance_reimburse> c = new ArrayList<Finance_reimburse>();
		if(a != null && a.size()>0 && null != b && b.size()>0){
			for(int i = 0;i<a.size();i++){
				for(int j = 0;j<b.size();j++){
					if(a.get(i).getReal_reimburse_id() == b.get(j).getReal_reimburse_id()){
						c.add(a.get(i));
					}
				}
			}
		}else{
			return null;
		}
		if(null != c && c.size() > 0){
			return c;
		}else{
			return null;
		}
	}
	@Override
	public ArrayList<Finance_reimburse> getFinance_reimburseByTime(
			Date start_time, boolean flag) throws Exception {
		ArrayList<Finance_reimburse> afr = new ArrayList<Finance_reimburse>();
		Finance_ReimburseInterface f = frs;
		if(null != f.getFinance_reimburses() && f.getFinance_reimburses().size()>0){
			ArrayList<Finance_reimburse> temp = f.getFinance_reimburses();
			if(flag){
				for(int i = 0;i<temp.size();i++){
					if(temp.get(i).getStart_time().after(start_time)){
						afr.add(temp.get(i));
					}
				}
				if(null != afr && afr.size()>0){
					return afr;
				}else{
					return null;
				}
			}else{
				for(int i = 0;i<temp.size();i++){
					if(temp.get(i).getReimburse_time().before(start_time)){
						afr.add(temp.get(i));
					}
				}
				if(null != afr && afr.size()>0){
					return afr;
				}else{
					return null;
				}			
			}
		}
		else{
			return null;
		}
	}

	@Override
	public ArrayList<Finance_reimburse> getFinance_reimburseByTime(
			Date start_time, Date reimburse_time) throws Exception{
		ArrayList<Finance_reimburse> afr = new ArrayList<Finance_reimburse>();
		Finance_ReimburseInterface f = frs;
		if(null != f.getFinance_reimburses() && f.getFinance_reimburses().size()>0){
			ArrayList<Finance_reimburse> temp = f.getFinance_reimburses();
			for(int i = 0;i<temp.size();i++){
				if(temp.get(i).getStart_time().after(start_time) && temp.get(i).getReimburse_time().before(reimburse_time)){
					afr.add(temp.get(i));
				}
			}
			if(null != afr && afr.size()>0){

				return afr;
			}else{
				return null;
			}
		}else{

			return null;
		}
	}

	@Override
	public ArrayList<Finance_reimburse> getFinance_reimburses(
			String employee_id, String manager_id, Date start_time,
			Date reimburse_time) throws Exception{
		if(null != employee_id && null != manager_id && null!=reimburse_time && null!=start_time){
			if(employee_id.length() == 10 && manager_id.length() == 10 && reimburse_time !=null && start_time != null){
				ArrayList<Finance_reimburse> fi =  getFinance_reimburseByEmployee_id(employee_id, manager_id);
				ArrayList<Finance_reimburse> ft = getFinance_reimburseByTime(start_time, reimburse_time);
				ArrayList<Finance_reimburse> f = y(fi,ft);
				if(null != f && f.size()>0){
					return f;
				}
			}
		}
		ArrayList<Finance_reimburse> fi = new ArrayList<Finance_reimburse>();
		if((null == manager_id||manager_id.length()==0) && (null!=employee_id &&employee_id.length()>0) ){
			fi = getFinance_reimburseByEmployee_id(employee_id, true);
		}else if((null == employee_id||employee_id.length()==0) && (null!=manager_id && manager_id.length()>0)){
			fi = getFinance_reimburseByEmployee_id(manager_id, false);
		}else if(null != employee_id && null!=manager_id){
			fi = getFinance_reimburseByEmployee_id(employee_id, manager_id);
		}else{
			fi = null;
		}
		ArrayList<Finance_reimburse> ft = new ArrayList<Finance_reimburse>();
		if( null == start_time &&   null != reimburse_time){
			ft = getFinance_reimburseByTime(reimburse_time, false);
		}else if( null !=start_time &&null== reimburse_time){
			ft = getFinance_reimburseByTime(start_time, true);
		}else if(null!=start_time && null!=reimburse_time){
			ft = getFinance_reimburseByTime(start_time, reimburse_time);
		}else{
			return fi;
		}
		if(null == ft || ft.size() == 0){
			return fi;
		}
		if( null ==fi || fi.size() == 0){
			return ft;
		}
		ArrayList<Finance_reimburse> fa = y(ft,fi);
		if(null == fa || fa.size()==0){
			return null;
		}else{
			return fa;
		}
	}


	@Override
	public ArrayList<Finance_reimburse> getFinance_reimburses(Date start,
			Date end) {
		ArrayList<Finance_reimburse> finance_reimburses =  baseInterface.getFinance_reimburses();
		ArrayList<Finance_reimburse> f = new ArrayList<Finance_reimburse>();
		if(null != start && null != end){
			for (Finance_reimburse finance_reimburse : finance_reimburses) {
				if(start.before(finance_reimburse.getReimburse_time()) && end.after(finance_reimburse.getReimburse_time())){
					f.add(finance_reimburse);
				}
			}
			if(null!=f && f.size()>0){
				return f;
			}else{
				return null;
			}
		}
		if(null == start && null != end){
			for (Finance_reimburse finance_reimburse : finance_reimburses) {
				if(end.after(finance_reimburse.getReimburse_time())){
					f.add(finance_reimburse);
				}
			}
			if(null!=f && f.size()>0){
				return f;
			}else{
				return null;
			}
		}
		if(null !=start && null == end){
			for (Finance_reimburse finance_reimburse : finance_reimburses) {
				if(start.before(finance_reimburse.getReimburse_time())){
					f.add(finance_reimburse);
				}
			}
			if(null!=f && f.size()>0){
				return f;
			}else{
				return null;
			}
		}
		return null;
	}


}
