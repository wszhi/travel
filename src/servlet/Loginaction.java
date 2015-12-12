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
		//��ѯ���ݿ��е����ݣ��Ƿ��������Ϣƥ��ɹ��ļ�¼��ƥ��ɹ�����¼�ɹ���
		BaseDao dao = new BaseDao();
		String singleSql ="select * from login where employee_id = ? and password = ? and role = ?";
        Object params[] = {username,password,role};
		try {
			Login entity = (Login) dao.getSingle(singleSql, Login.class,params);
			if(entity != null)//��¼�ɹ�
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
				if(entity.getRole().equals("��������Ա"))
				{
					JOptionPane.showMessageDialog(null,"���������ڵ�¼��");
				}
				else
				{
				int login_times2=entity.getLogin_times();
				if(login_times2 >= 1 )//���ǵ�һ�ε�¼����ȡԱ��������Ϣ����ת����ҳ
				{
					
					String updateSql = "update login set login_times=? where employee_id=?";  
					Object params2[] = {login_times2+1,username};  //�ʺű�ʾ����
					dao.update(updateSql, params2);//���µ�¼����
					if(entity.getRole().equals("��ͨԱ��"))
					{
						RequestDispatcher rd =req.getRequestDispatcher("apply_travel.jsp");
						rd.forward(req, resp);
					}
					if(entity.getRole().equals("����"))
					{
						session.setAttribute("finance_id", employee_id);
						resp.sendRedirect("login.do?finance_id="+employee_id);
					}
					if(entity.getRole().equals("�����쵼"))
					{
						RequestDispatcher rd =req.getRequestDispatcher("manager.jsp");
						rd.forward(req, resp);
					}
				}
				else{//��һ�ε�¼����ת��������Ϣҳ��
					String updateSql = "update login set login_times=? where employee_id=?";  
					Object params2[] = {1,username};  //�ʺű�ʾ����
					dao.update(updateSql, params2);//���µ�¼����
					RequestDispatcher rd =req.getRequestDispatcher("employee_info.jsp");
					rd.forward(req, resp);
				}
				}		
			}else{
				JOptionPane.showMessageDialog(null,"��¼ʧ��!�û������������");
				RequestDispatcher rd =req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
