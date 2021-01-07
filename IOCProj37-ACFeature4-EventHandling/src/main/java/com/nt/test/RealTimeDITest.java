package com.nt.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.event.IOCContainerMonitoringListener;
import com.nt.vo.CustomerVO;

public class RealTimeDITest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		IOCContainerMonitoringListener listener=null;
		CustomerVO vo=null;
		Scanner sc=null;
		String result=null;
		MainController controller=null;
		//create container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
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
		
		///get Controller bean class object
		controller=ctx.getBean("controller",MainController.class);
		//catch and handle the exception
		try {
			result=controller.processCustomer(vo);
			System.out.println(result);
		}
		catch(Exception e) {
			System.out.println("Internal-DB problem");
			e.printStackTrace();
		}
		listener=ctx.getBean(IOCContainerMonitoringListener.class);
	    System.out.println(listener);	
	}

}
