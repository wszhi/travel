package PgBaseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class JDBCdemo {
	
	public static void main(String[] args) throws Exception {
		
		String user ="root";
		String password ="root";
		String url = "jdbc:mysql://127.0.0.1:3306/wx001";
		String sql = "select * from user";
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet  rs = ps.executeQuery();
		while (rs.next()){
			String id = rs.getString(1);
			String userName = rs.getString(2);
			String sex = rs.getString("SEX");
			System.out.println(id);
			System.out.println(userName);
			System.out.println(sex);
		}
		if(rs!=null){
			rs.close();
		}
		if(ps!=null){
			ps.close();
		}
		if(conn!=null){
			conn.close();
		}
	}

}
