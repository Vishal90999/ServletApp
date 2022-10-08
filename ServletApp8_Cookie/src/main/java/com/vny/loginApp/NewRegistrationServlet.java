package com.vny.loginApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/registration")
@SuppressWarnings("serial")

public class NewRegistrationServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException,IOException
	{
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		UserBean ub=new UserBean();
		ub.setuName(req.getParameter("uname"));
		ub.setPwd(req.getParameter("pwd"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setCity(req.getParameter("city"));
		ub.setMailId(req.getParameter("mailId"));
		ub.setPhoneNo(Long.parseLong(req.getParameter("phoneNo")));
		
		int k=new RegisterDAO().register(ub);
		
		if(k>0)
		{
			pw.println("<h3>User Registration successfull...</h3><br><br><br>");
			
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
			
		}
		
		
		
		
	}

}
