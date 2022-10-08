package com.vny.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RetrieveDAO 
{
	
ArrayList <ProductBean>al=new ArrayList<ProductBean>();

public ArrayList<ProductBean> retrieve()

{
		try 
		{
		  Connection con=DBConnection.getCon();
		  String query="select * from product47" ;
		  PreparedStatement ps=con.prepareStatement(query);
		  
		  ResultSet rs=ps.executeQuery();
		  
		  while(rs.next())
		  {
			ProductBean pb=new ProductBean();
			
		    pb.setpCode(rs.getString(1)); 
			pb.setpName(rs.getString(2));
			pb.setPprice(rs.getFloat(3));
			pb.setPqty(rs.getInt(4));
		    al.add(pb);
		  }
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	
	
	
	
	return al;
}



}
