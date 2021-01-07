package com.nt.filter;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class BrowserCheckingFilter extends HttpFilter{
 public void foFilter(HttpServletRequest req,HttpServletResponse res,FilterChain chain) throws ServletException,IOException {
  System.out.println("Browser checking filter::doFilter()");
  PrintWriter pw=null;
  String browser=null;
  //get printWriter object
  pw=res.getWriter();
  //set content type
  res.setContentType("text/html");
  browser=req.getHeader("user-agent");
  if(browser.indexOf("firefox")==-1) {
	  pw.println("<h1 style='color:red;text-align:center'>Use firefox browser to view this website</h1>");
	  return;
  }//if
  else {
	  System.out.println("Browser checking filter.doFilter()(before)");
	  chain.doFilter(req,res);
	  System.out.println("Browser checking filter.doFilter()(after)");
	  }//else
   }//doFilter(-,-)
 }//class
