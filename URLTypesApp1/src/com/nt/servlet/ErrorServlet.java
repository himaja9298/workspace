package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/test1.c")
public class ErrorServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  //general settings
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		//display Error message
		pw.println("<h1><center>internal problem</center></h1>");
		pw.println("<a href='input.html'>Try Again</a>");
		pw.close();
	}//doGet
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 doGet(req,res);
	}//doGet
}//class
