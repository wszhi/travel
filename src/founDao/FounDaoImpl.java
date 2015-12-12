package founDao;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.util.finder.Test;

import PgBaseDao.*;
import Pojo.Employee;
import Pojo.Triptab;
public class FounDaoImpl implements FounDao {
		List<Triptab> triptabs=null;
		Employee employee=null;
		BaseDao baseDao = new BaseDao();
		//HttpServletRequest request = ServletActionContext.getRequest();
		//String str=request.getSession().getAttribute("department_name").toString();
		@Override
	public List<Triptab> nospquery(Triptab triptab) {
		String sql1 ="select travel_id,apply_time,employee_id,position,destination,reason,schedule,remark from triptab where state='未审核' and apply_time=? and start_time=? and type=? and department=?";
		String sql2="select travel_id,apply_time,employee_id,position,destination,reason,schedule,remark from triptab where state='未审核' and start_time=? and type=? and department=?";
		String sql3="select travel_id,apply_time,employee_id,position,destination,reason,schedule,remark from triptab where state='未审核' and apply_time=? and type=? and department=?";
	    String sql4="select travel_id,apply_time,employee_id,position,destination,reason,schedule,remark from triptab where state='未审核' and type=? and department=?";
	    System.out.print(triptab.getDepartment());
	    Object params1[]={triptab.getApply_time(),triptab.getStart_time(),triptab.getType(),triptab.getDepartment()};
	    Object params2[]={triptab.getStart_time(),triptab.getType(),triptab.getDepartment()};
	    Object params3[]={triptab.getApply_time(),triptab.getType(),triptab.getDepartment()};
	    Object params4[]={triptab.getType(),triptab.getDepartment()};
		
		if(null!=triptab.getApply_time()&null!=triptab.getStart_time())
			try {
				triptabs = baseDao.getList(sql1, Triptab.class, params1);
			} catch (Exception e) {
			e.printStackTrace();
			}
		else if(null==triptab.getApply_time()&null!=triptab.getStart_time())
			try {
				triptabs = baseDao.getList(sql2, Triptab.class, params2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		else if(null!=triptab.getApply_time()&null==triptab.getStart_time())
			try {
				triptabs = baseDao.getList(sql3, Triptab.class, params3);
			} catch (Exception e) {
				e.printStackTrace();
			}
		else
			try {
				triptabs = baseDao.getList(sql4, Triptab.class, params4);
			} catch (Exception e) {
			e.printStackTrace();
			}
		System.out.println(triptabs);
		return triptabs ;
	}

	@Override
	public List<Triptab>yspquery(Triptab triptab) {
		String allSql ="select * from triptab where department=? and (state='通过' or state='不通过')";
		try {
			Object params[] = {triptab.getDepartment()};
			if(null!=triptab.getDepartment())
			{
			triptabs = baseDao.getList(allSql, Triptab.class,params);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("已审批"+triptabs);
		return triptabs;
	}
	@Override
	public int updatetrip(Triptab triptab) {
		String updateSql = "update triptab set manager_id=?,man_rea=?,state=? where travel_id=?";  
	    Object params[] = {triptab.getManager_id(),triptab.getMan_rea(),triptab.getState(),triptab.getTravel_id()};  //问号表示参数
		int upcount=1;
		try {
		 upcount = baseDao.update(updateSql, params);
		 System.out.println(upcount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return upcount;
	}


	
	}

		
