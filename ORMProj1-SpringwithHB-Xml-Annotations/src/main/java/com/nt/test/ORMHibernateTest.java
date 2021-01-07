package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.ProjectDto;
import com.nt.service.ProjectService;

public class ORMHibernateTest {

	public static void main(String[] args) {
		   ApplicationContext ctx=null;
		   ProjectService  service=null;
		   ProjectDto dto=null;
		   //create IOC container
		   ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		   
		   //get Service class object
		   service=ctx.getBean("pservice",ProjectService.class);
		   //save object
			/*try { 
				  //create dto
				    dto=new ProjectDto(); 
				    dto.setProjName("foreginExchane");
			        dto.setTeamSize(10);
			        dto.setCompany("tcs");
			        dto.setCost(25000000.0);
			        dto.setLocation("banglore"); 
			        //use service
			   System.out.println(service.registerProject(dto)); 
			  }
			  catch(DataAccessException dae) {
				   dae.printStackTrace();
				   }*/
		   //System.out.println("29 project details:"+service.fetchProjectById(29));
           //System.out.println("10 project details:"+service.fetchProjectById(10));
		   //System.out.println("update 30 project details"+service.modifyProjectById(30, 7, 55000000.0));
		   //System.out.println("update 10 project details"+service.modifyProjectById(10, 5, 5000000));
		   //System.out.println("Remove 31 project details"+service.RemoveProjectById(31));
		   List<ProjectDto> listDto=service.fecthProjectsByCostrange(20000000.0, 60000000.0);
		    listDto.forEach(dto1->{
		    	   System.out.println(dto1); 
		    });
		   
		   
		   //close container
		   ((AbstractApplicationContext) ctx).close();

	}//main
}//class