package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpSessionListener;

public class WebApplicationMonitoringListener implements HttpSessionListener {
    private long start,end;
    ServletContext sc=null;
   	public void contextInitialized(ServletContextEvent sce) {
		//getstart time
		start=System.currentTimeMillis();
		//get servletContext object
		sc=sce.getServletContext();
		sc.log(sc.getContextPath()+"Id deployed/restarted/reloaded at::"+new Date());
        System.out.println(sc.getContextPath()+"Id deployed/restarted/reloaded at::"+new Date());	
   	}//initialized
   	public void contextDestroyed(ServletContextEvent sce) {
   		//write to log file
   		sc.log("Webapplication is stooped/Undeployed at"+new Date());
   		System.out.println("Webapplication is stooped/Undeployed at"+new Date());
   	}//destroyed
}//class
