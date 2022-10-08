package com.vny.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/addproduct")
@SuppressWarnings("serial")
public class AddProductDetails extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException 
	{
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
	    String pCode=req.getParameter("pcode");
		String pName=req.getParameter("pname");
		float price=Float.parseFloat(req.getParameter("pprice"));
		int qty=Integer.parseInt(req.getParameter("pqty"));
		
		ProductBean pb=new ProductBean();
		pb.setpCode(pCode);
		pb.setpName(pName);
		pb.setPprice(price);
		pb.setPqty(qty);
		
		InsertDAO i=new InsertDAO();
		int v=i.insert(pb);
		if(v>0)
		{
			pw.println("<b>Product Details inserted Successfully...</b><br><br>");
		}
		
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		rd.include(req, resp);
		
		
	}

}
