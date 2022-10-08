package com.vny.loginApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws 
	ServletException,IOException {
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		//cookies from request object
		Cookie  c[]=req.getCookies();//de-Serialization process
		
		if(c==null)
		{
			pw.println("<h3>Session Expired...</h3><br><br>");
		}
		else
		{
			c[0].setMaxAge(0);
			pw.println("<h3>User Logout Successfully...</h3><br>");
		}
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.include(req, resp);
	}
	

}
