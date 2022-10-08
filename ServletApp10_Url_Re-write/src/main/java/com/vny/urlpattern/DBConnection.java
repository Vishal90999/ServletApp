package com.vny.urlpattern;

import java.sql.Connection;
import java.sql.DriverManager;
//singleton class design pattern
public class DBConnection {
	// static reference variable
	private static Connection con=null;
	
	//static block
	static 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:xe","system","123");
			
		}//end of try
		catch(Exception e)
		{
			e.printStackTrace();
		}//end of catch
	}
	private DBConnection() {
		//0-arg private constructor 
	}
	public static Connection getCon() 
	{
		//static method 
		return con;
	}

}
