package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	String pname=null,fname=null,ms=null,f2t1=null,f2t2=null;
	pw=res.getWriter();
	res.setContentType("text/html");
	//read form1/req data
	pname=req.getParameter("pname");
	fname=req.getParameter("fname");
	ms=req.getParameter("ms");
	//read form2 request data
	f2t1=req.getParameter("f2t1");
	f2t2=req.getParameter("f2t2");
	pw.println("<h1 style='color:red;text-align:center'>Result page</h1>");
	pw.println("<br>form1/req1 data::"+pname+"....."+fname+"...."+ms);
	pw.println("<br>form2/req2 data::"+f2t1+"...."+f2t2);
	//ad hyperlink
	pw.println("<br><br><a href='input.html'>Home</a>");
	//close the stream
	pw.close();
	}//doGet
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
