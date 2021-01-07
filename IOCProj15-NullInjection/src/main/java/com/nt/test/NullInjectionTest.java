package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.PersonInfo;

public class NullInjectionTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		PersonInfo rajaInfo=null,raviInfo=null;
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		rajaInfo=factory.getBean("rajaInfo",PersonInfo.class);
		System.out.println(rajaInfo);
		raviInfo=factory.getBean("raviInfo",PersonInfo.class);
		System.out.println(raviInfo);
		
	}

}
