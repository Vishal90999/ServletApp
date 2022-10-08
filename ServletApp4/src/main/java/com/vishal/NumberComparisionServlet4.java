package com.vishal;

import java.io.IOException;


import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/vishal")
@SuppressWarnings("serial")

public class NumberComparisionServlet4 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException {
		
		String n1=req.getParameter("n1");
		
		if(n1.equals("gre"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("greater");
			rd.forward(req, resp);
		}
		else if(n1.equals("sma"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("smaller");
			rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("equal");
			rd.forward(req, resp);
		}
		
	
		
	}

}
