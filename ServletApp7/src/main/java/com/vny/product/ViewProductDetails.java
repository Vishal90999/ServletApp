package com.vny.product;

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
@WebServlet("/viewall")
@SuppressWarnings("serial")
public class ViewProductDetails extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp)
			throws ServletException, IOException
	{
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		RetrieveDAO r=new RetrieveDAO();
	ArrayList<ProductBean> pbl	=r.retrieve();
	
	if(pbl.size()==0)
	{
		pw.println("Product Details not found..");
		
	}
	else
	{
		
	 Iterator <ProductBean> i=pbl.iterator();
	 while(i.hasNext())
	 {
		 ProductBean pb=( ProductBean)i.next();
      pw.println("&nbsp&nbsp&nbsp"+pb.getpCode()+"&nbsp&nbsp&nbsp"
                +pb.getpName()+"&nbsp&nbsp&nbsp"
                +pb.getPprice()+"&nbsp&nbsp&nbsp"
                +pb.getPqty()); 
      //
	             pw.println("<br>");
	 }
	 pw.println("<br><br><br><br>");
	 
	 RequestDispatcher rd=req.getRequestDispatcher("input.html");	
		rd.include(req, resp);
	}
	
	
	}

}
