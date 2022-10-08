package com.vny.urlpattern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.http.HttpServletRequest;

public class RetrieveDAO {
//ArrayList <ProductBean> al=new ArrayList <ProductBean>();
ProductBean pb=null;
public ProductBean retrive(HttpServletRequest req)
{
	try
	{
		Connection con=DBConnection.getCon();
		String Query="Select * from product47 where code=?";
		PreparedStatement ps=con.prepareStatement(Query);
		ps.setString(1, req.getParameter("pcode"));
		ResultSet rs=ps.executeQuery();
		
		if(rs.next())
		{
			pb=new ProductBean();
			pb.setpCode(rs.getString(1));
			pb.setpName(rs.getString(2));
			pb.setPprice(rs.getFloat(3));
			pb.setPqty(rs.getInt(4));
			
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
	
	return pb;
}
}
