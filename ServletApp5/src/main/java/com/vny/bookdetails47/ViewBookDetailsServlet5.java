package com.vny.bookdetails47;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/view")
@SuppressWarnings("serial")
public class ViewBookDetailsServlet5 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException 
	{
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		RetrieveDAO ri=new RetrieveDAO();
		ArrayList<BookBean> al=ri.retrieve();
		if(al.size()==0)
		{
			pw.println("<b>Book Details not found...</b><br><br>");
			RequestDispatcher rd=req.getRequestDispatcher("input.html");
			rd.include(req, resp);
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
			
			RequestDispatcher rd=req.getRequestDispatcher("input.html");
			rd.include(req, resp);
		}
		
	}

}
