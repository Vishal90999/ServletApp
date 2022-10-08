package com.vny.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductByCodeDOA 
{
	
public ArrayList<ProductBean> pbc=new ArrayList<ProductBean>();
	
public ArrayList<ProductBean> getProduct(ProductBean pb)
{
  try 
  {
	 
	 Connection con=DBConnection.getCon();
	 String query="select * from product47 where code=?";
	 PreparedStatement ps=con.prepareStatement(query);
	 ps.setString(1, pb.getpCode());
	 ResultSet rs=ps.executeQuery();
	 
	 while(rs.next())
	 {
		 ProductBean pb1=new ProductBean();
		 pb1.setpCode(rs.getString(1));
		 pb1.setpName(rs.getString(2));
		 pb1.setPprice(rs.getFloat(3));
		 pb1.setPqty(rs.getInt(4));
		 
		 pbc.add(pb1);
	 }
	  
	  
  }
  catch(Exception e)
  {
	 e.printStackTrace(); 
  }
	
	
	return pbc;
}
}
