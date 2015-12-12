package PgBaseDao;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Pojo.Triptab;
import founDao.*;
import Service.TriptabService;
public class MyFirstServlet extends HttpServlet {
	private TriptabService triptabService;
	public TriptabService getTriptabService() {
		return triptabService;
	}
    public void setTriptabService(TriptabService triptabService) {
		this.triptabService = triptabService;
	}
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String travel_id = req.getParameter("travel");
		System.out.println("传参数travel_id="+travel_id);
		String manger_id = req.getParameter("manager_id");
		String state = req.getParameter("stete");
		String reason = req.getParameter("reason");
		String  u ="1";
		try {
		BaseDao baseDao=new BaseDao();
		String updateSql = "update triptab set manager_id=? man_rea=? state=? where travel_id=?";  
		Object params[] = {manger_id,state,reason,travel_id};  //问号表示参数
	   try {
		 u =Integer.toString(baseDao.update(updateSql, params));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(null!=u){
				u= "exist";
			}else{
				u= "noExist";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OutputStream os = resp.getOutputStream();
		os.write(u.getBytes("utf-8"));
		os.close();

	}

	
}
