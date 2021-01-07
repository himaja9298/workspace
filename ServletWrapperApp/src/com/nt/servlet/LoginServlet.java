package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   //create PrintWriter object
			PrintWriter pw=null;
			String uname=null,pwd=null;
		    //get PrintWriter object
			pw=res.getWriter();
			//set content type
			res.setContentType("text/html");
			uname=req.getParameter("uname");
			pwd=req.getParameter("pwd");
			//write bussiness logic
			if(uname.equals("raja@gmail.com")&&pwd.equals("rani")) {
			   pw.println("<h1 style='color:red;text-align:center'>Valid credentials</h1>");
			 }
			else
				pw.println("<h1 style='color:red;text-align:center'>InValid credentials</h1>");
			
		pw.println("<a href='input.html'>Home</a>");
		System.out.println("req object class name"+req.getClass());
		System.out.println("res object class name"+res.getClass());	
		

		}//doGet(-,-)
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request, response);
	   }//doPost(-,-)

}
