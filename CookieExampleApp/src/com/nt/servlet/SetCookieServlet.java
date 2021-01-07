package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/seturl" )
public class SetCookieServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//create cookie varaiable
		Cookie ck1,ck2,ck3,ck4;
		// create in-memory cookies
		ck1=new Cookie("ap","amaravati");
		ck2=new Cookie("ts","hyderabad");
		//add cookies
		res.addCookie(ck1);
		res.addCookie(ck2);
	    //create persistent cookies
		ck3=new Cookie("kr","banglore");
	    ck4=new Cookie("maharastra","mumbai");
	    //set maxsize to cookies
	    ck3.setMaxAge(60);
	    ck4.setMaxAge(60);
	    res.addCookie(ck3);
	    res.addCookie(ck4);
	  // create printwriter object 
	    PrintWriter pw=res.getWriter();
	  //set content type
	   res.setContentType("text/html");
	   //print Cookie information
	   pw.println("<b>Successful in setting cookies</b>");
	}//doGet
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost

}
