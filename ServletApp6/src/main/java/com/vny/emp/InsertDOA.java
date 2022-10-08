package com.vny.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertDOA 
{
	public int k=0;
	
	public int insert(EmployeeBean eb) 
	{
		try 
		{
			Connection con=DBConnection.getCon();
			//Accessing Database connection
			String query="insert into employeedetails values(?,?,?,?,?)";
        	PreparedStatement ps=con.prepareStatement(query);
			
        	ps.setString(1, eb.getEid());
        	ps.setString(2, eb.getEname());
        	ps.setString(3, eb.getJob());
        	ps.setFloat(4, eb.getSal());
        	ps.setInt(5, eb.getDno());
        	
             k = ps.executeUpdate();	
		}//end of try
		catch(Exception e) {e.printStackTrace();}
		
		  return k;
	}//method end
	
}//class end
