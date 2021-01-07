package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hyperurl")
public class SRDHyperlinkServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 PrintWriter pw=null;
	 String str=null;
	 pw=res.getWriter();
	 res.setContentType("text/html");
	 str=req.getParameter("str");
	 pw.println("<a href='https://www.google.com/search?q="+str+"'>Go to Google</a>");
	 //close stream
	 pw.close();
	 
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
