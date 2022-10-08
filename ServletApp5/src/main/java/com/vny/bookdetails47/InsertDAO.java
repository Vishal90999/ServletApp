package com.vny.bookdetails47;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertDAO {
	
	int p=0;
	
	public int insert(BookBean bb) 
	{
		try 
		{
			Connection con=DBConnection.getCon();
			//accessing connection
			String query="insert into bookdetails47 values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			//BookBean object set into ps for insert into DB
			//Only Bean object travel throw n/w
			ps.setString(1, bb.getBcode());
			ps.setString(2, bb.getBname());
			ps.setString(3, bb.getBauthor());
			ps.setFloat(4, bb.getBprice());
			ps.setInt(5, bb.getQty());
			
			 p=ps.executeUpdate();	
		}//end of try
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return p;
		
	}

}
