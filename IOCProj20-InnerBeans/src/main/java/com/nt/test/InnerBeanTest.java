package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.ProfessionalCricketer;

public class InnerBeanTest {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		ProfessionalCricketer pcrct=null;
		// create factory
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		// get kohli bean class object
		pcrct=factory.getBean("kohli",ProfessionalCricketer.class);
        System.out.println(pcrct.Batting());
        //get dhoni bean class object
        pcrct=factory.getBean("dhoni",ProfessionalCricketer.class);
        System.out.println(pcrct.Batting());
	}

}
