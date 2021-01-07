package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pname=null,fname=null;
		Cookie ck1=null,ck2=null;
		///get PrintWriter object
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		pname=req.getParameter("pname");
		fname=req.getParameter("fname");
		//cretae cookies to store form1 data
		ck1=new Cookie("name",pname);
		ck2=new Cookie("fname",fname);
		res.addCookie(ck1);
		res.addCookie(ck2);
		//generatimg dynamic form
		pw.println("<h1 style='color:red;text-align:center'>Provide income details</h1><br><br>");
		pw.println("<form action='secondurl' method='POST'>");
		pw.println("<table align='center'>");
		pw.println("<tr>");
		pw.println("<td>Income:</td>");
		pw.println("<td><input type='text' name='income'></td>");
		pw.println("</tr>");
		pw.println("<tr>");
		pw.println("<td>Tax::</td>");
	    pw.println("<td><input type='text' name='tax'></td>");
	    pw.println("</tr>");
	    pw.println("<tr><td><input type='submit' value='submit'></td></tr>");
		pw.println("</table>");
		pw.println("</form>");
		//close stream
		pw.close();
		}//doGet

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
