package com.vny.loginApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/view1")
@SuppressWarnings("serial")
public class ViewBookDetailsServlet5 extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		Cookie c[]=req.getCookies();	//Cookies from request object
	//De-serialization process
		if(c==null)
		{
			pw.println("<h4>Session Expired...</h4><br><br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}
		else
		{
			String uname=c[0].getValue();
			pw.println("page of <h1>"+uname+"</h1><br><br><br>");
			
			RequestDispatcher rd=req.getRequestDispatcher("more.html");
			rd.include(req, resp);
			
		RetrieveBookDAO ri=new RetrieveBookDAO();
		ArrayList<BookBean> al=ri.retrieve();
		if(al.size()==0)
		{
			pw.println("<b>Book Details not found...</b><br><br>");
			
		}
		else
		{
			Iterator<BookBean> ib=al.iterator();
			
			pw.println("<b><i><========Book Details========></i></b><br><br>");
			pw.println("<b>Bcode</b>"+"&nbsp&nbsp"+"<b>Bname</b>"+"&nbsp&nbsp"+""
					+ "<b>Author</b>"+"&nbsp&nbsp&nbsp&nbsp"+"<b>Price</b>"
					+ "&nbsp&nbsp"+"&nbsp&nbsp"+"<b>Qty</b><br><br>");
			
			while(ib.hasNext())
			{
				 BookBean bl=(BookBean)ib.next();
			pw.println(	bl.getBcode()+"&nbsp&nbsp;&nbsp;"+
						bl.getBname()+"&nbsp;&nbsp&nbsp;&nbsp"+
						bl.getBauthor()+"&nbsp&nbsp&nbsp;&nbsp&nbsp;"+
						bl.getBprice()+"&nbsp&nbsp&nbsp;&nbsp"+
						bl.getQty()+"&nbsp&nbsp<br><br>");
			}
			
			pw.println("<br>");
		}
		
		
	}
	}

}
