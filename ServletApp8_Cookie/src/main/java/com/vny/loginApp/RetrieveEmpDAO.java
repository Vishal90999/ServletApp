package com.vny.loginApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RetrieveEmpDAO {
	
	public ArrayList<EmployeeBean> al=new ArrayList<EmployeeBean>();
	//method which is return array data in the form of EmployeeBean
	
	public ArrayList<EmployeeBean> retrieve()
	{//this method finally return ArrayList object(al)
		try 
		{
	    	Connection con=DBConnection.getCon();
	    	//Accessing DB connection
	    	String query="select * from employeedetails";
			PreparedStatement ps=con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				EmployeeBean eb1=new EmployeeBean();
				eb1.setEid(rs.getString(1));
				eb1.setEname(rs.getString(2));
				eb1.setJob(rs.getString(3));
				eb1.setSal(rs.getFloat(4));
				eb1.setDno(rs.getInt(5));
				//adding bean to ArrayList object
				al.add(eb1);
			}//loop end
			
		}
		catch(Exception e) {e.printStackTrace();}
		
		return al;
	}
	

}
