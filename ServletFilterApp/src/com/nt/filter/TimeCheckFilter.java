package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/*")
public class TimeCheckFilter extends HttpFilter implements Filter {
	public void doFilter(HttpServletRequest requ, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		PrintWriter pw=null;
		Calendar cal=null;
		int hour=0;
		//get printWriter object
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get system date
		cal=Calendar.getInstance();
		//get hour of the day
		hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour<9||hour>17) {
			pw.println("<h1 style='color:red;text;align:center'>Request must not be given before 9am and after 5pm</h1>");
			return;
		}//if
		else {
			System.out.println("TimeCheckFilter.doFilter(-,-)(before)");
		    chain.doFilter(requ, res);
		    System.out.println("TimeCheckFilter.doFilter(-,-)(after)");
		}//else
	}//doFilter
}//filterClass
