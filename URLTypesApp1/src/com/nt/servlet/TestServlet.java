package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1/test.c")
    public class TestServlet extends HttpServlet implements SingleThreadModel {
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  System.out.println("TestServlet.doGet()::hashcode:::"+this.hashCode());
		  PrintWriter pw=null;
		  pw=res.getWriter();
		  res.setContentType("text/html");
		  pw.println("<h1>Date and Time :::"+new java.util.Date()+"</h1>HashCode:::"+this.hashCode());
}//doget
   public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost

}
