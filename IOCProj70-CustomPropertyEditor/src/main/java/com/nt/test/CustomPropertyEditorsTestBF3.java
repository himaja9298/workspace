package com.nt.test;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.cglib.proxy.Factory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.LoanAmntCalculator;
import com.nt.beans.LoanAmntDetails;
import com.nt.editors.LoanAmntDetailsEditor;

public class CustomPropertyEditorsTestBF3 {

	public static void main(String[] args) {

		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		LoanAmntCalculator lcalc = null;
		CustomEditorConfigurer cecfg = null;

		// create container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
        
		// get PersonInfo class object
		lcalc = factory.getBean("lacalc", LoanAmntCalculator.class);
		System.out.println(lcalc.getIntrestAmnt());
		// get object of CustomEditorconfigurer class
		cecfg = factory.getBean(CustomEditorConfigurer.class);
		cecfg.postProcessBeanFactory(factory);
	}

}
