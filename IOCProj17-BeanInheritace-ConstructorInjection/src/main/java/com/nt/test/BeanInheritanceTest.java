package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.nt.beans.TwoWheelerInfo;

public class BeanInheritanceTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		TwoWheelerInfo raviInfo=null,rajaInfo=null,ramInfo=null;
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		rajaInfo=factory.getBean("rajaCar",TwoWheelerInfo.class);
		System.out.println(rajaInfo);
		raviInfo=factory.getBean("raviCar",TwoWheelerInfo.class);
		System.out.println(raviInfo);
		ramInfo=factory.getBean("baseBean",TwoWheelerInfo.class);
		System.out.println(ramInfo);
		
	}

}
