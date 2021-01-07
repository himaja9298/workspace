package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/centralurl")
public class CentralGSTServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String ctype=null;
		float cost=0.0f,cgst=0.0f;
		pw=res.getWriter();
		res.setContentType("text/html");
		
		cost=Float.parseFloat(req.getParameter("cost"));
		//calculate state gst
		if(ctype.equalsIgnoreCase("product")){
				 cgst=cost*0.18f;
		}else if(ctype.equalsIgnoreCase("service"))
	    	cgst=cost*0.15f;		   
	    else if(ctype.equalsIgnoreCase("startup"))
	    	cgst=cost*0.1f;
	    //display details
		pw.println("<h4 style='color:green;text-align:center'>Company Type::"+ctype+"</h4>");
		pw.println("<h4 style='color:green;text-align:center'>Project Cost::"+cost+"</h4>");
	 }//doGet
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doGet(req, res);
	}

}
