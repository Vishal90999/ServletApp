package com.vishal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/mlt")
public class MulServlet3 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException 
	{
		
		
	PrintWriter pw=resp.getWriter();
	resp.setContentType("text/html");
	try
	{
		int value1=Integer.parseInt(req.getParameter("v1"));
		int value2=Integer.parseInt(req.getParameter("v2"));
		int value3=value1*value2;
		
        pw.println("<h3 style=color:#cc3366>Multiplication of given number</h3>");
        pw.println(value1+"*"+value2+"="+value3);
        
        RequestDispatcher rd=req.getRequestDispatcher("index.html");
        rd.include(req, resp);
	}
	catch(Exception e) 
	{
	  pw.println("Invalid data type...<br>")	;
	  
	RequestDispatcher rd = req.getRequestDispatcher("index.html");
	rd.include(req, resp);
	}
		
		
		
		
	}
	

}
