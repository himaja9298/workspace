package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses=null; 
		ServletContext sc=null;	
		RequestDispatcher rd=null;
		/*
		 * String sname=null,scrs[]=null; //get req param value
		 * sname=req.getParameter("sname"); scrs=req.getParameterValues("scrs");
		 */
		//create different scope attributes
		 //request scope
		 req.setAttribute("attr1", "val1");
		 //session scope
		 ses=req.getSession();
		 req.setAttribute("attr2", "val2");
		 //application scope
		 sc=getServletContext();
		 sc.setAttribute("attr3","val3");
		//forward dest object to jsp
		 rd=req.getRequestDispatcher("/ELObjects1.jsp");
		 rd.include(req, res);
		}//doGet(-,-)
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//servlet
