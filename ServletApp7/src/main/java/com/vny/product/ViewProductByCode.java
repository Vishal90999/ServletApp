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
@WebServlet("/viewproduct")
@SuppressWarnings("serial")
public class ViewProductByCode extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException 
	{
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		String pCode=req.getParameter("pcode");
		ProductBean pb=new ProductBean();
	    pb.setpCode(pCode);
		ProductByCodeDOA pc=new ProductByCodeDOA();
		ArrayList<ProductBean> xx=pc.getProduct(pb);
		
		if(xx.size()==0)
		{
			pw.println("<h3>Product Details not Found...</h><br><br>");
			RequestDispatcher rd=req.getRequestDispatcher("input.html");
			rd.include(req, resp);
		}
		else
		{
		 Iterator<ProductBean> pbi=xx.iterator();
		 while(pbi.hasNext())
		 {
			 
	        	ProductBean pb5=(ProductBean)pbi.next();
	        	
	        	 pw.println("&nbsp&nbsp&nbsp"+pb5.getpCode()+"&nbsp&nbsp&nbsp"
	                     +pb5.getpName()+"&nbsp&nbsp&nbsp"
	                     +pb5.getPprice()+"&nbsp&nbsp&nbsp"
	                     +pb5.getPqty()); 
	        	
	        	 pw.println("<br>");
		 }//end of while
		 
		 pw.println("<br><br><br><br>");
		 
		 
			RequestDispatcher rd=req.getRequestDispatcher("input.html");
			rd.include(req, resp);
		}
		
		
	}

}
