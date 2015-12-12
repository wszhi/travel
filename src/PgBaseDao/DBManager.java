package PgBaseDao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.*;
public class DBManager {
	public static Connection getConn() throws Exception
		{
			  Class.forName("com.mysql.jdbc.Driver");
		      Connection conn = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/travelmanagement?useUnicode=true&characterEncoding=utf-8", "root", "123456"); 
		      return  conn;
			
		}
	
/*public static void main(String args[]){
		try{
			System.out.println(getConn());
		}catch (Exception e){
			e.printStackTrace();
		}
		}
*/
}
