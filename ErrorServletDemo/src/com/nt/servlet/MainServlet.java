package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MainServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	try {
	PrintWriter pw=null;
	String First=null,Second=null;
	int num1=0,num2=0;
	pw=res.getWriter();
	res.setContentType("text/html");
    
	num1=Integer.parseInt(req.getParameter("first"));
	num2=Integer.parseInt(req.getParameter("second"));
	pw.println("<h1 style='color:red'>Addition of two numbers is"+(num1+num2)+"</h1>");
	pw.close();
	}//try
	catch(Exception e) {
		RequestDispatcher rd=req.getRequestDispatcher("/errorurl");
	    rd.forward(req,res);
	}//catch
  }//doGet
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost
}//class
