package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet(name="annotation",urlPatterns="/annotationurl")
@WebServlet(name="annotat",urlPatterns={"/annourl","/annoturl","/ationurl"})
public class AnnotationServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			PrintWriter pw=null;
			pw=res.getWriter();
			try {
				
				String First=null,Second=null;
				int num1=0,num2=0;
				res.setContentType("text/html");
			    num1=Integer.parseInt(req.getParameter("first"));
				num2=Integer.parseInt(req.getParameter("second"));
				pw.println("<h1 style='color:red'>Addition of two numbers is"+(num1+num2)+"</h1>");
				}//try
				catch(Exception e) {
				pw.println("<h1>Intenal DB problem</h1>");
				pw.println("<a href=input.html>Home</a>");	
				}//catch
			  }//doGet
				
				
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
