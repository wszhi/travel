package com.three.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.three.db.Triptab;
import com.three.domain.Apply_Triptab;

public class TriptabAction extends ActionSupport implements Preparable {


	private Apply_Triptab apply_Triptab;
	private Triptab triptab;
	private List<Triptab> triptabs;
	private int pageNow=0;
	 private int pageSize=3;

	
	public int getPageNow() {
		return pageNow;
	}


	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public String insertTriptab() {
		apply_Triptab.insertTriptab(triptab);
		return SUCCESS;

	}


	public String UpdateTriptab() {
		apply_Triptab.UpdateTriptab(triptab, triptab.getTravel_id());
		System.out.print("ok");
		return SUCCESS;

	}


	public String queryTriptab() {
		System.out.print("ok");
		HttpServletRequest req = ServletActionContext.getRequest();
		String s=req.getParameter("flag").toString();
		int flag= Integer.parseInt(s);
		HttpSession session = req.getSession();
		if(flag==1)
		{
			session.setAttribute("Apply_time","");
			session.setAttribute("State","");
		if(!(StringUtils.isBlank(triptab.getApply_time())))
		{
		session.setAttribute("Apply_time",triptab.getApply_time() );
		}
		if(!(StringUtils.isBlank(triptab.getState())))
		{
		session.setAttribute("State",triptab.getState());
		}
		}
		if(pageNow<0)
		{
			JOptionPane.showMessageDialog(null,"ÒÑÊÇÊ×Ò³!");
		}
		else
		{
		if(null!=apply_Triptab.queryTriptab(triptab.getApply_time(), triptab.getState(), triptab.getEmployee_id(),pageNow,pageSize))
		{
		triptabs=apply_Triptab.queryTriptab(triptab.getApply_time(), triptab.getState(), triptab.getEmployee_id(),pageNow,pageSize);
		}
		}
		return SUCCESS;
	}


	public String queryTriptabInfor() {
		
		triptabs=apply_Triptab.queryTriptabInfor(triptab.getTravel_id());
		HttpServletRequest request = ServletActionContext.getRequest();
		String s=request.getParameter("flag").toString();
		int flag= Integer.parseInt(s);
		if(flag==1){
			return "success1";
		}
		else if(flag==2){
			return "success2";
		}
		return s;
	}

	@Override
	public void prepare() throws Exception {
		triptab = null;

	}

	public Apply_Triptab getApply_Triptab() {
		return apply_Triptab;
	}


	public void setApply_Triptab(Apply_Triptab apply_Triptab) {
		this.apply_Triptab = apply_Triptab;
	}


	public Triptab getTriptab() {
		return triptab;
	}


	public void setTriptab(Triptab triptab) {
		this.triptab = triptab;
	}


	public List<Triptab> getTriptabs() {
		return triptabs;
	}


	public void setTriptabs(List<Triptab> triptabs) {
		this.triptabs = triptabs;
	}
	
}
