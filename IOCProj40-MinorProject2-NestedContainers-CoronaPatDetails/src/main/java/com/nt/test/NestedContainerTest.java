package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.CoronaVO;

public class NestedContainerTest {

	public static void main(String[] args) {
		ApplicationContext parentctx=null,childctx=null;
		MainController controller=null;
		List<CoronaVO> listvo=null;
		//get parent container
		parentctx=new ClassPathXmlApplicationContext("com/nt/cfgs/Bussiness-beans.xml");
		//get child container
		childctx=new ClassPathXmlApplicationContext(new String[] {"com/nt/cfgs/Presentation-beans.xml"},parentctx);
	   //get controller class object
		controller=childctx.getBean("controller",MainController.class);
		try {
		controller.gatherEmpDetails("hyd", "delhi","mumbai").forEach(System.out::println);
	   }//try
	   catch(Exception e) {
		 e.printStackTrace();
	   }
		//close container
		((AbstractApplicationContext) parentctx).close();
		((AbstractApplicationContext) childctx).close();
	}

}
