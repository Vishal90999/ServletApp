package com.vny.loginfilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		
		String fname=(String) req.getAttribute("fname");
		
		pw.println("<h3>Logine process successful..</h3><br>");
		pw.println("<h4>welcome user <span style=color:red>"+fname+"</span></h4><br>");
		
		
	}

}
