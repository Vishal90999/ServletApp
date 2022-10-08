package com.vny.product;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertDAO 
{
public int insert(ProductBean pb) 
{
	int k=0;
	
	try
	{
	  Connection con=DBConnection.getCon();
	  String query="insert into product47 values(?,?,?,?)";
	  PreparedStatement ps = con.prepareStatement(query);
	  
	  ps.setString(1, pb.getpCode());
	  ps.setString(2, pb.getpName());
	  ps.setFloat(3, pb.getPprice());
	  ps.setInt(4, pb.getPqty());
	  
		k=ps.executeUpdate();
		
		
	}
	
	catch(Exception e) {e.printStackTrace();}

	return k;
}
}
