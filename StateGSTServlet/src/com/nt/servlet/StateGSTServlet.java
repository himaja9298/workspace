package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/stateurl")
public class StateGSTServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	PrintWriter pw=null;
	String pname=null,company=null,ctype=null;
	float cost=0.0f;
	float sgst=0.0f;
	ServletContext sc1=null,sc2=null;
	RequestDispatcher rd=null;
	pw=res.getWriter();
	res.setContentType("text/html");
	pname=req.getParameter("pname");
	company=req.getParameter("company");
	ctype=req.getParameter("ctype");
	cost=Float.parseFloat(req.getParameter("cost"));
	//calculate state gst
	if(ctype.equalsIgnoreCase("product")){
			 sgst=cost*0.12f;
	}else if(ctype.equalsIgnoreCase("service"))
    	sgst=cost*0.1f;		   
    else if(ctype.equalsIgnoreCase("startup"))
    	sgst=cost*0.03f;
     pw.println("<b><i><h2>Company and Project Details</h2></i></b>");
	 pw.println("<h4 style='color:green;text-align:center'>Company Name::"+company+"</h4>");	
	 pw.println("<h4 style='color:green;text-align:center'>Company Type::"+ctype+"</h4>");
	 pw.println("<h4 style='color:green;text-align:center'>Project Name::"+pname+"</h4>");
	 pw.println("<h4 style='color:green;text-align:center'>Project Cost::"+cost+"</h4>");
	 pw.println("<h4 style='color:green;text-align:center'>State GST::"+sgst+"</h4>");
	 //communication with destination servlet of CentralGSTApp using cross context Communication
	 //get servletContext object
	 sc1=getServletContext();
	 sc2=sc1.getContext("CentralGSTApp");
	 //getRequestdispacther object pointing to CentralGSTApp
	 rd=sc2.getRequestDispatcher("/centralurl");
	 rd.include(req,res);
	 pw.println("<a href='input.html'>Home</a>");
   }//doGet
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost

}
