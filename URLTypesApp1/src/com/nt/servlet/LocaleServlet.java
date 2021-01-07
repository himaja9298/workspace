package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.c")
public class LocaleServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  PrintWriter pw=null;
	  Locale locales[]=null;
	  pw=res.getWriter();
	  res.setContentType("text/html");
	  locales=Locale.getAvailableLocales();
	  pw.println("<h2 style='color:red;text-align:center'>All Languages Present in the World</h2> ");
	  for(Locale l1:locales) {
		  pw.println("<h3 style='color:green;text-align:center'>"+l1.getDisplayLanguage()+"<br>");
	  }//for
		}//doget
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost
}//Servlet
