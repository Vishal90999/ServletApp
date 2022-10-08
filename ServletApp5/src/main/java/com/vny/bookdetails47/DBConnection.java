package com.vny.bookdetails47;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	//Singleton class design pattern
	
	private static Connection con=null;//reference variable
	
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
		}
	}
		private DBConnection() 
		{
			//constructor private 0-argument 
			//no one can create the object outside the class
		}
		//static method can be call with class
		public static Connection getCon() 
		{
			return con;
		}
	

}
