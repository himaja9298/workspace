package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

 public class SessionDurationListener implements HttpSessionListener {
  private long start,end;
  ServletContext sc=null;
  HttpSession ses=null;
public void sessionCreated(HttpSessionEvent hse) { 
	start=System.currentTimeMillis();
	//get servletcontext object
	sc=hse.getSession().getServletContext();
    //get session object
	ses=hse.getSession();
	sc.log("Session Id::"+ses.getId()+"Session starts at"+new Date());
    System.out.println("Session Id::"+ses.getId()+"Session starts at"+new Date());
}//initialized
public void sessionDestroyed(HttpSessionEvent hse) {
	   end=System.currentTimeMillis();
	   //get servletcontext object
	   sc=hse.getSession().getServletContext();
	    //getsession object
	   ses=hse.getSession();
	    //create log file
	    sc.log("Session Id::"+ses.getId()+"Session ended at"+new Date());
	    System.out.println("Session Id::"+ses.getId()+"Session ended at"+new Date());
	    sc.log("Session Id::"+ses.getId()+"Session duration is::"+(end-start)+"ms");
	    System.out.println("Session Id::"+ses.getId()+"Session duration is::"+(end-start)+"ms");
}//destroyed
}//class

