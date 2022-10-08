package com.vny.product;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProductDAO 
{
    int k=0;
    
    public int deleteProduct(ProductBean pb) 
    {
    	try
    	{
    	 Connection con=DBConnection.getCon();
    	 String query="delete from product47 where code=?";
    	 PreparedStatement ps=con.prepareStatement(query);
    	 ps.setString(1, pb.getpCode());
    	 k= ps.executeUpdate();	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	
    	return k;
    }

	
		
		
		
	
}


