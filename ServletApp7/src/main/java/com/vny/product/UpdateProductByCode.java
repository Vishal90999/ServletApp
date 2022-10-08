package com.vny.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/updateprice")
@SuppressWarnings("serial")
public class UpdateProductByCode extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException 
	{
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		String pCode=req.getParameter("pcode");
		float pPrice=Float.parseFloat(req.getParameter("pprice"));
		ProductBean pb=new ProductBean();
		pb.setpCode(pCode);
		pb.setPprice(pPrice);
		UpdateProductDAO upd=new UpdateProductDAO();
		int m=upd.updateProduct(pb);
		if(m>0)
		{
			
		  pw.println("<h3>Product Price Updated Successfully...</h3><br><br>");
		  RequestDispatcher rd=req.getRequestDispatcher("input.html");
		  rd.include(req, resp);
		}
		else
		{
			pw.println("<h3>Somthing Goes Wrong...Request failed</h3><br><br><br>");
			RequestDispatcher rd=req.getRequestDispatcher("input.html");
			  rd.include(req, resp);
		}
		
		
	}

}
