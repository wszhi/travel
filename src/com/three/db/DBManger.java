package com.three.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManger {

	/*private static String jdbcDriver="";
	private static String jdbcUrl="";
	private static String jdbcUser="";
	private static String jdbcPassword="";
	static{
		InputStream is=null;
		try{
			is=DBManger.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties p=new Properties();
			jdbcDriver=p.getProperty("jdbc.driverClassName");
		}catch (Exception e){
		}
	}
	public static Connection getConnection() throws Exception
	{
		  Class.forName("com.mysql.jdbc.Driver");
	      Connection conn = DriverManager.getConnection(
	          "jdbc:mysql://localhost:3306/travelmanagement?useUnicode=true&characterEncoding=utf-8", "root", "123456"); // <== Check!
	      return  conn;
		
	}*/
	
	 private static String driveClassName = "com.mysql.jdbc.Driver";  
	     //private static String url = "jdbc:mysql://localhost:3306/travelmanagement?useUnicode=true&characterEncoding=utf8";   
	 private static String url = "jdbc:mysql://192.168.10.218:3306/travelmanagement?useUnicode=true&characterEncoding=utf8";   
     
	    private static String user = "root";  
	    private static String password = "123456";  
	       
	     public static Connection Connect(){  
	         Connection conn = null;  
	           
	        //load driver  
	         try {  
	            Class.forName(driveClassName);  
	       } catch (ClassNotFoundException  e) {  
	            System.out.println("load driver failed!");  
	            e.printStackTrace();  
	        }  
	           
	         //connect db  
	        try {  
	            conn = DriverManager.getConnection(url, user, password);  
	        } catch (SQLException e) {  
	            System.out.println("connect failed!");  
	             e.printStackTrace();  
	         }         
	           
	        return conn;  
	   }  


}
