package com.nt.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//@WebFilter("/*")
public class DoublePostingPreventingFilter extends HttpFilter implements Filter {
   	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpSession ses=null;
		String method=null;
		RequestDispatcher rd=null;
		int clientToken=0,serverToken=0;
		//get session
		ses=req.getSession();
		//get request method
		method=req.getMethod();
		if(method.equalsIgnoreCase("GET")){
			//System.out.println(new Random().nextInt(50));
			ses.setAttribute("sToken",new Random().nextInt(50));
			chain.doFilter(req,res);
		}//if
		else {
			//read server token , client token values
			clientToken=Integer.parseInt(req.getParameter("cToken"));
			serverToken=(int)ses.getAttribute("sToken");
			System.out.println(clientToken+"   "+serverToken);
			//compare both clientToken and sToken values
			if(clientToken==serverToken) {
			  ses.setAttribute("sToken", new Random().nextInt(100));
			  chain.doFilter(req, res);
			  }//if
		   else {
			   
			  //if not matching
			  rd=req.getRequestDispatcher("/error.html");
			  rd.forward(req,res);
		   }//else
		}//else	
	}//service
}//filter
