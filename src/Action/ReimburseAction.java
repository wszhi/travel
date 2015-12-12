package Action;
import java.util.List;
import java.util.TreeMap;

import Pojo.Reimburse;
import Service.ReimburseService;





//import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.ActionSupport;
public class ReimburseAction extends ActionSupport 
{
	private Reimburse reimburse;
	int u=1;
	private List<Reimburse> reimburses;
	// 定义封装请求参数的sel1成员变量
	private ReimburseService reimburseService;
	// 设值注入业务逻辑组件所必需的setter方法
	public ReimburseService getReimburseService() {
		return reimburseService;
	}
	public void setReimburseService(ReimburseService reimburseService) {
		this.reimburseService = reimburseService;
	}
	public List<Reimburse> getReimburses()
	{
		return reimburses;
	}
	public void setReimburses(List<Reimburse> reimburses)
	{
		this.reimburses = reimburses;
	}
	public Reimburse getReimburse()
	{
		return reimburse;
	}
	public void setReimburse(Reimburse reimburse)
	{
		this.reimburse =reimburse;
	}
	// 定义处理用户请求的seeapply方法
	public String seereimb()
	{
		System.out.print(reimburse.getDepartment());
		reimburses= reimburseService.reimbquery1(reimburse);
		return SUCCESS;
		}
  
   public String findreimb()
	{ 
	   reimburses= reimburseService.reimbquery2(reimburse);
		return SUCCESS;
	}
   public String updatereimb()
  	{ 
	   //System.out.println(reimburse.getReimburse_id());
  	    u= reimburseService.updaterei(reimburse);
  	  return SUCCESS;
  		
  	}


}