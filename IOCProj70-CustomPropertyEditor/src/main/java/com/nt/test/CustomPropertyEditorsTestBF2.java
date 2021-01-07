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

public class CustomPropertyEditorsTestBF2 {

	public static void main(String[] args) {
		
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		LoanAmntCalculator lcalc = null;
		// create container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		
		//add CustomPropertyEditorRegistar to IOC container
		factory.addPropertyEditorRegistrar(registry->{
		registry.registerCustomEditor(LoanAmntDetails.class, new LoanAmntDetailsEditor());
			
		});
		// get PersonInfo class object
		lcalc = factory.getBean("lacalc", LoanAmntCalculator.class);
		System.out.println(lcalc.getIntrestAmnt());
	}

		}
	

