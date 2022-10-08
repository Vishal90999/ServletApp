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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)
	 throws ServletException,IOException
	 
	{
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		LogBean lb=new LogBean();
		lb.setuName(req.getParameter("uname"));
		lb.setPwd(req.getParameter("pwd"));
		
		UserBean ub1=new LoginDAO().login(lb);
		
		if(ub1==null)
		{
			pw.println("<h2><b><i>Invalid Login Credential...</i></b></h2><br><br><br>");
			
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}
		else
		{
			//Creating cookie 
			Cookie ck=new Cookie("uname" ,ub1.getfName());
			//adding cookie to respose
			resp.addCookie(ck);
			pw.println("<h3>Welcome User:: </h3>"+"<h1>"+ub1.getfName()+"</h1><br>");
			
			RequestDispatcher rd=req.getRequestDispatcher("more.html");
			rd.include(req, resp);
			
		}
		
		
		
	}

}
