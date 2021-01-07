package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.beans.TestBean;

public class PrivateBeanTest {

	public static void main(String[] args) {
		Resource res=null;
		BeanFactory factory=null;
		TestBean test=null;
		Object inner=null;
		//hold applicationContect.xml file
		res=new ClassPathResource("com/nt/cfgs/applicationContext.xml");
		//create beanFactory
		factory=new XmlBeanFactory(res);
		test=factory.getBean("test", TestBean.class);
	    System.out.println(test);
	    inner=factory.getBean("inner", Object.class);
	    System.out.println(inner);

	}

}
