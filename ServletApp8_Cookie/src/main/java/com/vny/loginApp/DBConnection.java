package com.vny.loginApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static Connection con=null;
	static
	{
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	private DBConnection() {
		
	}
	public static Connection getCon() 
	{
	
		return con;
	}
	

}
