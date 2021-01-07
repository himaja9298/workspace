package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String pname=null,fname=null,ms=null;	
	PrintWriter pw=null;
	ServletContext sc=null;
	pw=res.getWriter();
	res.setContentType("text/html");
	pname=req.getParameter("pname");
	fname=req.getParameter("fname");
	ms=req.getParameter("ms");
	if(ms.equalsIgnoreCase("single")) {
		pw.println("<h1 style='color:green;text-align:center'>provide Bachelor life related data</h1>");
		pw.println("<form action='Servlet2' method='POST'>");
		pw.println("<table bgcolor='orange' align='center'>");
		pw.println("<tr><td>When do you want to marry::</td><td><input type='text' name='f2t1'></td></tr>");
		pw.println("<tr><td>Why do you want to marry::</td><td><input type='text' name='f2t2'></td></tr>"); 
	    pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
	    pw.println("</table>");
	    pw.println("</form>");
	    //get servletContect object
	    sc=getServletContext();
	    pw.println("req count::"+sc.getAttribute("reqCount"));
	}
	else {
		pw.println("<h1 style='color:orange;text-align:center'>provide Married life related data</h1>");
		pw.println("<form action='Servlet2' method='POST'>");
		pw.println("<table bgcolor='pink' align='center'>");
		pw.println("<tr><td>Spouse Name::</td><td><input type='text' name='f2t1'></td></tr>");
		pw.println("<tr><td>No.Of.Childern::</td><td><input type='text' name='f2t2'></td></tr>"); 
	    pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
	    pw.println("</table>");
	    pw.println("</form>");
	    sc=getServletContext();
	    pw.println("req count::"+sc.getAttribute("reqCount"));

	}
	pw.close();
	}//doGet
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost

}
