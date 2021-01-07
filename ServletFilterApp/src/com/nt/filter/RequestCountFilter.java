package com.nt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/*")
public class RequestCountFilter extends HttpFilter {
	private int count;
	public void init() throws ServletException {
		count=0;
	}
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		ServletContext sc=null;
		//increment request count
		count++;
		//keep count in  servletContext object
		sc=getServletContext();
		sc.setAttribute("reqCount", count);
		//delegate request to nextFilter or dest comp
		chain.doFilter(req, res);
	}//doFilter(-,-)
	
}//filter
