package com.nt.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.PresentationConfig;
import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class NestedContainerTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext parentctx=null,childctx=null;
		MainController controller=null;
		List<EmployeeVO> listvo=null;
		//get parent container
		parentctx=new AnnotationConfigApplicationContext("BussinessConfig.class");
		//get child container
		//childctx=new AnnotationConfigApplicationContext("PresentationConfig.class");
	    //childctx.setParent(parentctx);
		childctx=new AnnotationConfigApplicationContext();
		childctx.setParent(parentctx);
		childctx.register(PresentationConfig.class);
		childctx.refresh();
		
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
