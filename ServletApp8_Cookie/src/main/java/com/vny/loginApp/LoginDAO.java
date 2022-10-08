package com.vny.loginApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	public UserBean login(LogBean lb) 
	{
		UserBean ub1=null;
		try
		{
		
			Connection con =DBConnection.getCon();
			String query="select * from userlogin47 where uname=? and pwd=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, lb.getuName());
			ps.setString(2, lb.getPwd());
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				  ub1=new UserBean();
				ub1.setuName(rs.getString(1));
				ub1.setPwd(rs.getString(2));
				ub1.setfName(rs.getString(3));
				ub1.setlName(rs.getString(4));
				ub1.setCity(rs.getString(5));
				ub1.setMailId(rs.getString(6));
				ub1.setPhoneNo(rs.getLong(7));
			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return ub1;
	}

}
