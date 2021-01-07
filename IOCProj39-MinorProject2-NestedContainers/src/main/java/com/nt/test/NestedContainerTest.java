package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class NestedContainerTest {

	public static void main(String[] args) {
		ApplicationContext parentctx=null,childctx=null;
		MainController controller=null;
		List<EmployeeVO> listvo=null;
		//get parent container
		parentctx=new ClassPathXmlApplicationContext("com/nt/cfgs/Bussiness-beans.xml");
		//get child container
		childctx=new ClassPathXmlApplicationContext(new String[] {"com/nt/cfgs/Presentation-beans.xml"},parentctx);
	   //get controller class object
		controller=childctx.getBean("controller",MainController.class);
		try {
		controller.gatherEmpDetails("teacher", "sales","marketing").forEach(System.out::println);
	   }//try
	   catch(Exception e) {
		 e.printStackTrace();
	   }
		//close container
		((AbstractApplicationContext) parentctx).close();
		((AbstractApplicationContext) childctx).close();
	}

}
