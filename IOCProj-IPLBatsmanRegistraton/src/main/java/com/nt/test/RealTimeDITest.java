package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.CricketerVO;

public class RealTimeDITest {

	public static void main(String[] args) {
		
		CricketerVO vo=null;
		Scanner sc=null;
		String result=null;
		MainController controller=null;
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		String cname=null,country=null,runs=null,innings=null,wks=null,nouts=null;
		sc=new Scanner(System.in);
		System.out.println("enter cricketer name");
		cname=sc.next();
		System.out.println("enter cricketer country");
		country=sc.next();
		System.out.println("enter no.of  runs");
		runs=sc.next();
		System.out.println("enter rate of innings");
		innings=sc.next();
		System.out.println("enter no.of wickets");
		wks=sc.next();
		System.out.println("enter no.of notouts");
		nouts=sc.next();
		vo=new CricketerVO();
		vo.setCname(cname);
		vo.setCountry(country);
		vo.setRuns(runs);
	    vo.setInnings(innings);
		vo.setWickets(wks);
		vo.setNotouts(nouts);
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
