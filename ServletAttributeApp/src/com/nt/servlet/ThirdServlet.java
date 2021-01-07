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
import javax.servlet.http.HttpSession;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  PrintWriter pw=null;
	  HttpSession ses=null;
	  ServletContext sc=null;
	  RequestDispatcher rd=null;
	  pw=res.getWriter();
	  res.setContentType("text/html");
	  pw.println("<b>Servlet3::attr1 attribute value:"+req.getAttribute("attr1"));
	  ses=req.getSession();
	  pw.println("<br><b>Servlet3::attr2 attribute value:"+req.getAttribute("attr2"));
	  sc=getServletContext();
	  pw.println("<br><b>Servlet3::attr3 attribute value:"+req.getAttribute("attr3"));
	  
	  pw.close();
	 }
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
