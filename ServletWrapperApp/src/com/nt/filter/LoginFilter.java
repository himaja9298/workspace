package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.wrapper.MyRequest;
import com.nt.wrapper.MyResponse;
@WebFilter("/loginurl")
public class LoginFilter extends HttpFilter implements Filter {
    @Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	       //create custom request object 
    	   MyRequest mrequest=null;
    	   //create custom response object		
           MyResponse mresponse=null;
           String output=null;
           PrintWriter pw=null;
    	   mrequest=new MyRequest((HttpServletRequest)req);
    	   mresponse=new MyResponse((HttpServletResponse)res);
		  //call chain.diFilter(-,-)
		  chain.doFilter(mrequest,mresponse );
			/*
			 * res.toString().toUpperCase(); output=output+"HCL,Ameerpet";
			 */
			
			  output=mresponse.toString().toUpperCase(); 
			  //add signature
			  output=output+"HCL,Ameerpet"; 
			  //write response to browser 
			  pw=res.getWriter();
			  pw.println(output);
			}//doFilter(-,-)

}//filter
