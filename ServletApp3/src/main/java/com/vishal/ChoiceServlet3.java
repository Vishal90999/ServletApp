package com.vishal;
import java.io.*;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@SuppressWarnings("serial")
@WebServlet("/vishal")
public class ChoiceServlet3 extends GenericServlet {
	
	public void init() throws ServletException
	 {
	   //	 no code
	 }
	public void service(ServletRequest req,ServletResponse resp) 
			throws ServletException, IOException
	{
	
	   
		String s1=req.getParameter("s1");
		
		if(s1.equals("add")) 
		{
			RequestDispatcher rd=req.getRequestDispatcher("ad");
			rd.forward(req, resp);
		}
		else if(s1.equals("sub"))
		{
			 RequestDispatcher rd=req.getRequestDispatcher("sb");
			 rd.forward(req, resp);
		}
		else if(s1.equals("mul"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("mlt");
			rd.forward(req, resp);
		}
		else if(s1.equals("div"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("dvs");
			rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("mod");
			rd.forward(req, resp);
		}
		
	}
	public void destroy() {
		//no code
	}
	

}
