package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sendurl")
public class SRDServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String str=null,engine=null,url=null;
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 str=req.getParameter("str");
		 engine=req.getParameter("engine");
		 //prepae url with query string for sendredirection
		 
		 if(engine.equalsIgnoreCase("google")) {
			 url="https://www.google.com/search?q="+str;
		 }
		 else if(engine.equalsIgnoreCase("bing")) {
			 url="https://www.bing.com/search?q="+str;
		 }
		 else if(engine.equalsIgnoreCase("yahoo")) {
			 url="https://in.search.yahoo.com/search?q="+str;
		 }
		 res.sendRedirect(url);
		 RequestDispatcher rd=req.getRequestDispatcher("input.html");
		 rd.forward(req,res);
	
		 //close stream
		 pw.close();
			
	
	
	}
@Override	
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
