package com.vny.context_config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DisplayDetails extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	       throws ServletException,IOException
	{
		PrintWriter pw =resp.getWriter();
		resp.setContentType("text/html");
		
	String uname=req.getParameter("uname");
	pw.println("<h3>Hi user::</h3><h1><i>"+uname+"</i></h1>");
	
	//ServletContext  obj
	ServletContext sct=req.getServletContext();
	//Accessing ServletContext  obj
	pw.println("<br>======ServletContextDetails=======");
	pw.println("<br>ServerInfo::"+sct.getServerInfo());
	pw.println("<br>ContextValue::"+sct.getInitParameter("xyz"));
	pw.println("<br>ContextPath::"+sct.getContextPath());
	pw.println("<br>SessionTimeout::"+sct.getSessionTimeout());
	pw.println("<br>ServletContextName::"+sct.getServletContextName());
	
	//ServletContext  obj
		ServletConfig sc=this.getServletConfig();
		//Accessing ServletContext  obj
		
		pw.println("<br><br>======ServletConfigDetails=======");
		pw.println("<br>ServletName::"+sc.getServletName());
		pw.println("<br>ContextValue::"+sc.getInitParameter("abc"));
		pw.println("<br>ServletContext::"+sc.getServletContext());
		pw.println("<br>ClassNane::"+sc.getClass());
	
		
	
	
	
	
	
	}

}
