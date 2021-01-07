package com.nt.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


import com.nt.servlet.SRDServlet;

public class MyWebAppInitializer  implements ServletContainerInitializer {
	static{
		System.out.println("MyWebAppInitializer:static block");
		
	}
	public MyWebAppInitializer() {
		System.out.println("MyWebAppInitializer::0-param constructor");
	}
   public void onStartup(Set<Class<?>> set,ServletContext sc) throws ServletException{
	   System.out.println("MyWebAppInitializer.onStartup()");
	   SRDServlet servlet=null;
	   ServletRegistration.Dynamic dyna=null;
	   //create servlet class object
	   servlet=new SRDServlet();
	   //register Servlet
	   dyna=sc.addServlet("SRDServlet",servlet);
	   //provide urlPattern
	   dyna.addMapping("/searchurl");
	   //enable load-on-startup
	   dyna.setLoadOnStartup(1);
	 }//onStartup method
}//class
