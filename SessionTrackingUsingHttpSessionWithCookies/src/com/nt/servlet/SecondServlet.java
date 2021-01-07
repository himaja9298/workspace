package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String tax=null,income=null,pname=null,fname=null;
		 HttpSession ses=null;
		 //get PrintWriter object
		 pw=res.getWriter();
		 //get already created session
          ses=req.getSession(false);		
		 //get req1/form1 data
          pname=(String)ses.getAttribute("pname");
          fname=(String)ses.getAttribute("fname");
          //get req2/form2 data
		 income=req.getParameter("income");
		 tax=req.getParameter("tax");
		 pw.println("<h3 style='color:green;text-align:center'>Req1/Form1 data::"+pname+"...."+fname+"</h3><br><br>");
		 pw.println("<h3 style='color:green;text-align:center'>Req2/Form2 data::"+income+".... "+tax+"</h3>");
	 }//doGet
		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doGet(req, res);
   }//doPost
}//servlet
