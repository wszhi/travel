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
		//��ѯ���ݿ��е����ݣ��Ƿ��������Ϣƥ��ɹ��ļ�¼��ƥ��ɹ�����¼�ɹ���
		BaseDao dao = new BaseDao();
		String singleSql ="select * from login where employee_id = ? and password = ? ";
        Object params[] = {username,password};
		try {
			Login entity = (Login) dao.getSingle(singleSql, Login.class,params);
			if(entity != null && password1.equals(password2))//��¼��Ϊ��������������һ�£��޸�����ɹ�
			{
				System.out.println("role:"+password2);
				req.setAttribute("username", username);
				String updateSql = "update login set password = ? where employee_id=?";  
				Object params2[] = {password1,username};  //�ʺű�ʾ����
				int deleteCount = dao.update(updateSql, params2);
				//��ʱ��ת����¼����
				
				RequestDispatcher rd =req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
				
			}
			else{
				JOptionPane.showMessageDialog(null,"�޸�����ʧ��");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
