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
		/* pcrct=factory.getBean("crct",ProfessionalCricketer.class); */
		/* pcrct=factory.getBean("kh",ProfessionalCricketer.class); */
		pcrct=factory.getBean("kh1",ProfessionalCricketer.class);
        System.out.println(pcrct.Batting());
        //get dhoni bean class object
		/* pcrct=factory.getBean("crct2",ProfessionalCricketer.class); */
        pcrct=factory.getBean("dh",ProfessionalCricketer.class);
		 System.out.println(pcrct.Batting());
		 
	}

}
