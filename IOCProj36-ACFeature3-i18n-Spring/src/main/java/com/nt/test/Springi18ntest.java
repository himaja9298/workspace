package com.nt.test;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Springi18ntest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		String cap1=null,cap2=null,cap3=null,cap4=null;
		//get conatiner object
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		Locale locale=null;
	    //get locale through cmdLine
	    locale= new Locale(args[0],args[1]);
	    cap1=ctx.getMessage("btn1.cap", null, locale);
	    cap2=ctx.getMessage("btn2.cap", null, locale);
	    cap3=ctx.getMessage("btn3.cap", null, locale);
	    cap4=ctx.getMessage("btn4.cap", null, locale);
	System.out.println(cap1+" "+cap2+" "+cap3+" "+cap4);
	}

}
