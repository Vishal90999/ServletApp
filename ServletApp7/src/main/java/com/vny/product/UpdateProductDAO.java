package com.vny.product;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProductDAO 
{
	int k=0;
	public int updateProduct(ProductBean pb)
	{
		try
		{
			Connection con=DBConnection.getCon();
			String query="update product47 set price=? where code=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setFloat(1,pb.getPprice() );
			ps.setString(2,  pb.getpCode());
			 k=ps.executeUpdate();
			
		}
		catch(Exception e)
		{
		  e.printStackTrace();	
		}
		
		
		return k;
	}
		
		
}


