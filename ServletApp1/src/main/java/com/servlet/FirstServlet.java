package com.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/first")

public class FirstServlet extends GenericServlet {

	public void init()throws ServletException{
		//no code
	}

	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		String userName=req.getParameter("uname");
		String mailId=req.getParameter("mid");	
		String mobno=req.getParameter("mobno");
		
	    PrintWriter pw=	resp.getWriter();  
		resp.setContentType("text/html");
		
		pw.println("======LoginPageDetails======:");
		pw.println("<br>UserName :"+userName);
		pw.println("<br>Email_Id :"+mailId);
		pw.println("<br>Mobile_no:"+mobno);
	}
	 public void destroy() {
		 //no code
	 }

}
