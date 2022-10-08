package com.vny.httpsession;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDAO {
	int k=0;
	public int register(UserBean ub) 
	{
		try 
		{
			Connection con=DBConnection.getCon();
			String query="insert into userlogin47 values(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setString(1, ub.getuName());
			ps.setString(2, ub.getPwd());
			ps.setString(3, ub.getfName());
			ps.setString(4, ub.getlName());
			ps.setString(5, ub.getCity());
			ps.setString(6, ub.getMailId());
			ps.setLong(7, ub.getPhoneNo());
			
			k=ps.executeUpdate();
			
		}
	catch(Exception e)
		{
		e.printStackTrace();
		}
		
		
		return k;
	}

}
