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
@WebServlet("/equal")
public class EqualOrNot extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException
	{
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		try 
		{		
		int n1=Integer.parseInt(req.getParameter("num1"));
		int n2=Integer.parseInt(req.getParameter("num2"));
		int n3=Integer.parseInt(req.getParameter("num3"));
		
		
		//logic for greater & smaller
//		if(n1>n2&&n1>n3) 	
//			pw.println("<h3>First number is Greater("+n1+") than "+n2+","+n3+"</h3>");
//		else if(n2>n3) 	
//			pw.println("Second number is Greater("+n2+") than "+n1+","+n3);
//		else if(n3>n1&&n3>n2) 
//			pw.println("Third number is Greater("+n3+") than "+n1+","+n2); 
//		else if(n1<n2&&n1<n3)
//			pw.println("First number is Smaller("+n1+") than "+n2+","+n3);	
//		else if(n2<n3)
//			pw.println("Second number is Smaller("+n2+") than "+n1+","+n3);
//		else if(n3<n1&&n3<n2)
//			pw.println("Third number is Smaller("+n3+") than "+n1+","+n2);
		
	    if(n1==n2&&n1==n3)
			pw.println("<h2>All are same number</h2>");
		else if(n1==n2||n1==n3)
			pw.println("<h2>Any tow number are same</h2>");
		else
			pw.println("<h2> Goto( <b><,></b> )comparision...<h2>");
		
		RequestDispatcher rd=req.getRequestDispatcher("bigno.html");
		rd.include(req, resp);
		}
		catch(Exception e) 
		{
			pw.println("Invalid number format...<br>");	
			
			RequestDispatcher rd=req.getRequestDispatcher("bigno.html");
			rd.include(req, resp);
		}
		
		
	}

}
