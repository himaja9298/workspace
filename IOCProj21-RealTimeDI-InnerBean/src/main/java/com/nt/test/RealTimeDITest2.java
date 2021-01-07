package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;

public class RealTimeDITest2 {

	public static void main(String[] args) {
		
		CustomerVO vo=null;
		Scanner sc=null;
		String result=null;
		MainController controller=null;
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		String cname=null,cadd=null,pamt=null,rate=null,time=null;
		sc=new Scanner(System.in);
		System.out.println("enter customer name");
		cname=sc.next();
		System.out.println("enter customer addrs");
		cadd=sc.next();
		System.out.println("enter principleamount");
		pamt=sc.next();
		System.out.println("enter rate of intrest");
		rate=sc.next();
		System.out.println("enter time duration");
		time=sc.next();
		vo=new CustomerVO();
		vo.setCname(cname);
		vo.setCadd(cadd);
		vo.setPamt(pamt);
		vo.setTime(time);
		vo.setRate(rate);
		//create factory
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		///get Controller bean class object
		controller=factory.getBean("controller",MainController.class);
		//catch and handle the exception
		try {
			result=controller.processCustomer(vo);
			System.out.println(result);
		}
		catch(Exception e) {
			System.out.println("Internal-DB problem");
			e.printStackTrace();
		}
		
	}

}
