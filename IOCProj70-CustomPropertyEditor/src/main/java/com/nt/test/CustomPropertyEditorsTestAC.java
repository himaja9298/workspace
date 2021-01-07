package com.nt.test;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.cglib.proxy.Factory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.LoanAmntCalculator;
import com.nt.beans.LoanAmntDetails;
import com.nt.editors.LoanAmntDetailsEditor;

public class CustomPropertyEditorsTestAC {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		LoanAmntCalculator lcalc = null;
		// create container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get PersonInfo class object
		lcalc = ctx.getBean("lacalc", LoanAmntCalculator.class);
		System.out.println(lcalc.getIntrestAmnt());
	}

		}
	

