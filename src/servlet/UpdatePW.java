package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.three.db.*;
import com.three.dao.*;

public class UpdatePW extends HttpServlet{
	
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
		String password1= req.getParameter("password1");
		String password2= req.getParameter("password2");
		//查询数据库中的数据，是否有相关信息匹配成功的记录，匹配成功即登录成功。
		BaseDao dao = new BaseDao();
		String singleSql ="select * from login where employee_id = ? and password = ? ";
        Object params[] = {username,password};
		try {
			Login entity = (Login) dao.getSingle(singleSql, Login.class,params);
			if(entity != null && password1.equals(password2))//记录不为空且两次新密码一致，修改密码成功
			{
				System.out.println("role:"+password2);
				req.setAttribute("username", username);
				String updateSql = "update login set password = ? where employee_id=?";  
				Object params2[] = {password1,username};  //问号表示参数
				int deleteCount = dao.update(updateSql, params2);
				//暂时跳转到登录界面
				
				RequestDispatcher rd =req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
				
			}
			else{
				JOptionPane.showMessageDialog(null,"修改密码失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
