package Action;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import Pojo.Employee;
import Pojo.Triptab;
import Service.TriptabService;






//import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ActionSupport;
public class TriptabAction extends ActionSupport 
{
   String u="1";
	private  Triptab triptab;
	private  Employee employee;
	private List<Triptab> triptabs;
	// �����װ���������sel1��Ա����
	private TriptabService triptabService;
	// ��ֵע��ҵ���߼�����������setter����
	public void setTriptabService(TriptabService triptabService)
	{
		this. triptabService =  triptabService;
	}
	public TriptabService getTriptabService()
	{
		return triptabService;
	}
	public List<Triptab> getTriptabs()
	{
		return triptabs;
	}
	public void setTriptabs(List<Triptab> triptabs)
	{
		this.triptabs = triptabs;
	}
	public Triptab getTriptab()
	{
		return triptab;
	}
	public void setTriptab(Triptab triptab)
	{
		this.triptab = triptab;
	}
	public Employee getEmployee()
	{
		return employee;
	}
	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}
	// ���崦���û������seeapply����
public String seeapply()
	{  
	 System.out.println(triptab.getType());
	 triptabs= triptabService.querytrip1(triptab);
     return SUCCESS;
		}
public String findapply()
	{ 
	   triptabs=triptabService.querytrip2(triptab);
	   System.out.println("findall="+triptabs);
		return SUCCESS;
	}
public String updateapply()
  { 
  	 u=Integer.toString(triptabService.updatetrip(triptab));
  	return SUCCESS;
	
	
  }		
}