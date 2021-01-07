package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/showurl")
public class ShowCookieServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  PrintWriter pw=null;
	  Cookie cookies[]=null;
	  res.setContentType("text/html");
	  //get PrintWriter object
	  pw=res.getWriter();
	  //get Cookies
	  cookies=req.getCookies();
	  //display cookies
	  pw.println("<b>Displaying Cookies</b>");
	  if(cookies!=null) {
		  pw.println("<table border='1' bgcolor='cyan'>");
		  pw.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");
		  for(Cookie ck:cookies) {
			  pw.println("<tr><td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td></tr>");
		  }//for
		  pw.println("</table>");
	  }//if
	  else 
		  pw.println("<b>No Cookies Present</b>");
	  
	}//doGet
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost

}
