package com.vny.httpsession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RetrieveBookDAO 
{
	public ArrayList<BookBean> bbl=new ArrayList<BookBean>();
	//ArrayList which is Store the data coming from DB 
	//Data coming from database is BookBean object
	
	public ArrayList<BookBean> retrieve()
	{// Method Which is return the ArrayList object 
	
		try 
		{
			Connection con=DBConnection.getCon();
			//Accessing DB connection
			String query="select * from bookdetails47";
			PreparedStatement ps=con.prepareStatement(query);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				BookBean bb1=new BookBean();
				bb1.setBcode(rs.getString(1));
				bb1.setBname(rs.getString(2));
				bb1.setBauthor(rs.getString(3));
				bb1.setBprice(rs.getFloat(4));
				bb1.setQty(rs.getInt(5));
				//add this bean (data) into ArrayList
				bbl.add(bb1);
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return bbl;
	}
	
	
	
}
