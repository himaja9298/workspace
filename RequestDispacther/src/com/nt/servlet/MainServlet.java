package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="main1",urlPatterns={"/main1url"})
public class MainServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	try {
	
	    RequestDispatcher rd1=req.getRequestDispatcher("/headurl");
	    rd1.include(req,res);	
        //get PrintWriter object
	    PrintWriter pw=null;
	    String First=null,Second=null;
	    int num1=0,num2=0;
	    pw=res.getWriter();
	    res.setContentType("text/html");
     	num1=Integer.parseInt(req.getParameter("first"));
	    num2=Integer.parseInt(req.getParameter("second"));
	    pw.println("<h5 style='color:red'>Addition of two numbers is"+(num1+num2)+"</h5>");
	    pw.println("<h5 style='color:red'>Substraction of two numbers is"+(num1-num2)+"</h5>");
	    pw.println("<h5 style='color:red'>Multiplication of two numbers is"+(num1*num2)+"</h5>");
	    pw.println("<h5 style='color:red'>Division of two numbers is"+(num1/num2)+"</h5>");
    	pw.println("<h5 style='color:red'>ModuloDivision of two numbers is"+(num1%num2)+"</h5>");
    	RequestDispatcher rd2=req.getRequestDispatcher("/footer.html");
	    rd2.include(req,res);
	}//try
	catch(Exception e) {
		RequestDispatcher rd=req.getRequestDispatcher("/error1url");
	    rd.forward(req,res);
	}//catch
  }//doGet
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost
}//class
