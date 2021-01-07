package com.nt;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;
@SpringBootApplication
public class IocProj77BootRealTImeDiApplication {

	public static void main(String[] args) {
		CustomerVO vo=null;
		Scanner sc=null;
		String result=null;
		String cname=null,cadd=null,pamt=null,rate=null,time=null;
		ApplicationContext ctx=null;
		MainController controller=null;
		
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
		
		//get container
		//ctx=SpringApplication.run(IocProj77BootRealTImeDiApplication.class, args);
		
		SpringApplication app=new SpringApplication();
		app.setBannerMode(org.springframework.boot.Banner.Mode.CONSOLE);
		ctx=app.run(IocProj77BootRealTImeDiApplication.class, args);
		//get controller class object
	    controller=ctx.getBean("mainController",MainController.class);
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
