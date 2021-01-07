package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.A;
import com.nt.beans.B;

public class CyclicDITest {

	public static void main(String[] args) {
		        BeanFactory factory=null;
		        A a=null;
		        B b=null;
		        //create beanfactory
				factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
			    //get Marks bean class object
				a=factory.getBean("a1",A.class);
				System.out.println(a);
				b=factory.getBean("b1",B.class); 
				System.out.println(b);
				 		  
	}

}
