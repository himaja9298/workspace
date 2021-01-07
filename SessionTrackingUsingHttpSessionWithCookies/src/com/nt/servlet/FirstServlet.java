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

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pname=null,fname=null;
		Cookie ck1=null,ck2=null;
		HttpSession ses=null;
		///get PrintWriter object
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		pname=req.getParameter("pname");
		fname=req.getParameter("fname");
		//create HTTP session
		ses=req.getSession(true);
		//kepp form1/req1 data in session attribute
		ses.setAttribute("pname", pname);
		ses.setAttribute("fname", fname);
		//generatimg dynamic form
		pw.println("<h1 style='color:red;text-align:center'>Provide income details</h1><br><br>");
		pw.println("<form action='secondurl' method='POST'>");
		pw.println("<table align='center'>");
		pw.println("<tr><td>Income:</td><td><input type='text' name='income'></td></tr>");
		pw.println("<tr><td>Tax:</td><td><input type='text' name='tax'></td></tr>");
		pw.println("<tr><td><input type='submit' value='submit'></td><td><input type='reset' value='cancel'></td></tr>");
		pw.println("</table></form>");
		pw.println("<br>Session id::"+ses.getId());
		//close stream
		pw.close();
		}//doGet

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
