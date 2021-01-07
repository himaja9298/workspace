package com.nt.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class Corei18ntest {

	public static void main(String[] args) {
		Locale locale=null;
		ResourceBundle bundle=null;
		//get locale through commandLine arguments
		locale=new Locale(args[0],args[1]);
		bundle=ResourceBundle.getBundle("com/nt/commons/app",locale);
		System.out.println(bundle.getString("btn1.cap")+" "+bundle.getString("btn2.cap")+" "+bundle.getString("btn3.cap")+" "+bundle.getString("btn4.cap"));
	}

}
