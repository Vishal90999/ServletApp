package com.vny.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/deleteproduct")
@SuppressWarnings("serial")
public class DeleteProductByCode extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException 
	{
		
			PrintWriter pw=resp.getWriter();
			resp.setContentType("text/html");
			
			String pCode=req.getParameter("pcode");
			ProductBean pb=new ProductBean();
			pb.setpCode(pCode);
			DeleteProductDAO dp=new DeleteProductDAO ();
			int l=dp.deleteProduct(pb);
			
			if(l>0)
			{
				pw.println("<h3>Product Deleted Successfully...</h3><br><br>");
				
				RequestDispatcher rd=req.getRequestDispatcher("input.html");
				rd.include(req, resp);
				
			}
			else
			{
				pw.println("<h3>Product Not Found...</h3><br><br>");
				
				RequestDispatcher rd=req.getRequestDispatcher("input.html");
				rd.include(req, resp);
				
			}
		
	}

}
