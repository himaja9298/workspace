package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.ProjectDto;
import com.nt.service.ProjectService;

@SpringBootApplication
public class OrmProj3SpringWithHibernateSpringBootApplication {
    
     
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ProjectService service=null;
		ProjectDto dto=null;
		ctx=SpringApplication.run(OrmProj3SpringWithHibernateSpringBootApplication.class, args);
	    //get service class object
		service=ctx.getBean("pservice",ProjectService.class);
		try {
			//create dto
		    dto=new ProjectDto(); 
		    dto.setProjName("infrx");
	        dto.setTeamSize(25);
	        dto.setCompany("tcs");
	        dto.setCost(250000000000.0);
	        dto.setLocation("chennai"); 
	        //use service
	   System.out.println(service.registerProject(dto)); 
	  }
	  catch(DataAccessException dae) {
		   dae.printStackTrace();
		   }
   System.out.println("29 project details:"+service.fetchProjectById(29));
   System.out.println("10 project details:"+service.fetchProjectById(10));
   System.out.println("update 30 project details"+service.modifyProjectById(30, 5, 55000000.0));
   System.out.println("update 10 project details"+service.modifyProjectById(10, 9, 6000000));
   //System.out.println("Remove 31 project details"+service.RemoveProjectById(31));
   List<ProjectDto> listDto=service.fecthProjectsByCostrange(20000000.0, 60000000.0);
    listDto.forEach( System.out::println);
     
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
		}
	}


