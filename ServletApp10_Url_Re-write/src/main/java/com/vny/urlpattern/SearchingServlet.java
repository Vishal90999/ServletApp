package com.vny.urlpattern;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/search")
public class SearchingServlet extends HttpServlet{
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		
		
		ProductBean pb=new RetrieveDAO().retrive(req);
		
		if(pb==null)
		{
			pw.println("<h2>Invalid Product code..</h2><br>");
			RequestDispatcher rd=req.getRequestDispatcher("input.html");
			rd.include(req, resp);
			
		}
		else
		{
			pw.println("<a href='second?code="+pb.getpCode()+" &name="+pb.getpName()+" "
					 + "&price="+pb.getPprice()+" &qty="+pb.getPqty()+"'>DisplayDetails</a>");
			
		}
		
	}


}
