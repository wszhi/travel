package founDao;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import PgBaseDao.BaseDao;
import Pojo.Reimburse;
public class ReimburseDaoImpl implements ReimburseDao {
	List<Reimburse> reimburses=null;
	BaseDao baseDao = new BaseDao();
	@Override
	public List<Reimburse> nospbxquery(Reimburse reimburse) {
		String sql2 ="select reimburse_id,reimburse_time,employee_id,department,trans_totalmoney,other_totalmoney,total_money,reimburse_remark from reimburse where reimburse_state='δ���' and reimburse_type=? and department=?";
		String sql ="select reimburse_id,reimburse_time,employee_id,department,trans_totalmoney,other_totalmoney,total_money,reimburse_remark from reimburse where reimburse_state='δ���' and reimburse_type=? and reimburse_time=? and department=?";
		Object params2[]={reimburse.getReimburse_type(),reimburse.getDepartment()};
		Object params[]={reimburse.getReimburse_type(),reimburse.getReimburse_time(),reimburse.getDepartment()};
		if(null!=reimburse.getReimburse_time())
	    try {
		reimburses = baseDao.getList(sql, Reimburse.class, params);
		} catch (Exception e) {
		e.printStackTrace();
		}
		else {
			try {
				reimburses = baseDao.getList(sql2, Reimburse.class, params2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		System.out.println("δ����������="+reimburses);
		return reimburses ;
	}
	@Override
	public List<Reimburse> yspbxquery(Reimburse reimburse) {
		System.out.println("����yspbxquery����");
		String allSql ="select * from reimburse where department=? and (reimburse_state='ͨ��' or reimburse_state='��ͨ��' or reimburse_state='�ѱ���')";
		try {
			Object params[] = {reimburse.getDepartment()};
			reimburses = baseDao.getList(allSql, Reimburse.class,params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("������"+reimburses);
		return reimburses;
	}

	@Override
	public int updaterei(Reimburse reimburse) {
		String updateSql = "update reimburse set manager_id=?,reimburse_state=?,man_rea=?  where reimburse_id=?"; 
		System.out.println(reimburse.getManager_id());
		System.out.println(reimburse.getReimburse_state());
		System.out.println(reimburse.getReimburse_id());
		Object params[] = {reimburse.getManager_id(),reimburse.getReimburse_state(),reimburse.getMan_rea(),reimburse.getReimburse_id()};  //�ʺű�ʾ����
		int upcount=1;
		try {
		 upcount = baseDao.update(updateSql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return upcount;
	}
}
