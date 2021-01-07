package com.nt.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class ReqProcessingTimeCalculatorListener implements ServletRequestListener{
   private long start,end;
   ServletContext sc=null;
   HttpServletRequest req=null;
   public void requestInitialized(ServletRequestEvent sre) {
	   start=System.currentTimeMillis();
   }//initialized
   public void requestDestroyed(ServletRequestEvent sre) {
	   end=System.currentTimeMillis();
	   //write request processing time to logfile
	   sc=sre.getServletContext();
	   //get request object
	    req=(HttpServletRequest)sre.getServletRequest();
	    //create log file
	    sc.log(req.getRequestURI()+"Has taken"+(end-start)+"ms");
	    System.out.println(req.getRequestURI()+"Has taken"+(end-start)+"ms");
  	}//destroyed
}//class
