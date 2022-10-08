package com.vny.emp;

import java.sql.Connection;
import java.sql.DriverManager;

//singleton class design pattern
public class DBConnection {
	//Reference variable
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
			
		catch(Exception e) {e.printStackTrace();}
		
	}//end of static block
	
	private DBConnection() 
	{
		//constructor private 0-argument 
		//no one can create the object outside the class
	}
	
	public static Connection getCon() {
		return con;
	}
	

}
