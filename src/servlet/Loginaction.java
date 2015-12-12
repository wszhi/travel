package servlet;

import java.awt.Button;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.opensymphony.xwork2.ActionContext;
import com.three.dao.BaseDao;
import com.three.db.Department;
import com.three.db.Employee;
import com.three.db.Login;


public class Loginaction extends HttpServlet{

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
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String role= req.getParameter("Item");
		//查询数据库中的数据，是否有相关信息匹配成功的记录，匹配成功即登录成功。
		BaseDao dao = new BaseDao();
		String singleSql ="select * from login where employee_id = ? and password = ? and role = ?";
        Object params[] = {username,password,role};
		try {
			Login entity = (Login) dao.getSingle(singleSql, Login.class,params);
			if(entity != null)//登录成功
			{ 
				HttpSession session = req.getSession();
				session.setAttribute("employee_id", username);
				String employee_id = req.getSession().getAttribute("employee_id").toString(); 
				String Sql ="select * from employee where employee_id ='"+employee_id+"'";
				Employee entity3 = (Employee) dao.getSingle(Sql, Employee.class,null);
				String name=entity3.getName();  
				String position=entity3.getPosition();
				session.setAttribute("position", position);
				session.setAttribute("name", name);   
				session.setAttribute("role", role);
				String Sql2 ="select * from department where department_id ='"+entity3.getDepartment_id()+"'";
				Department entity2 = (Department) dao.getSingle(Sql2, Department.class,null);
				session.setAttribute("department_name", entity2.getDepartment_name());
				if(entity.getRole().equals("超级管理员"))
				{
					JOptionPane.showMessageDialog(null,"请从特殊入口登录！");
				}
				else
				{
				int login_times2=entity.getLogin_times();
				if(login_times2 >= 1 )//不是第一次登录，获取员工部分信息，跳转到首页
				{
					
					String updateSql = "update login set login_times=? where employee_id=?";  
					Object params2[] = {login_times2+1,username};  //问号表示参数
					dao.update(updateSql, params2);//更新登录次数
					if(entity.getRole().equals("普通员工"))
					{
						RequestDispatcher rd =req.getRequestDispatcher("apply_travel.jsp");
						rd.forward(req, resp);
					}
					if(entity.getRole().equals("财务部"))
					{
						session.setAttribute("finance_id", employee_id);
						resp.sendRedirect("login.do?finance_id="+employee_id);
					}
					if(entity.getRole().equals("审批领导"))
					{
						RequestDispatcher rd =req.getRequestDispatcher("manager.jsp");
						rd.forward(req, resp);
					}
				}
				else{//第一次登录，跳转到完善信息页面
					String updateSql = "update login set login_times=? where employee_id=?";  
					Object params2[] = {1,username};  //问号表示参数
					dao.update(updateSql, params2);//更新登录次数
					RequestDispatcher rd =req.getRequestDispatcher("employee_info.jsp");
					rd.forward(req, resp);
				}
				}		
			}else{
				JOptionPane.showMessageDialog(null,"登录失败!用户名或密码错误");
				RequestDispatcher rd =req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
