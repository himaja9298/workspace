package com.nt;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.EmployeeInfoDTO;
import com.nt.service.EmployeeInfoService;

@SpringBootApplication
public class SpringDataproj8jPARepoWorkingWithDatesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeInfoService service=null;
		EmployeeInfoDTO dto=null;
		
		
		//create container
		ctx=SpringApplication.run(SpringDataproj8jPARepoWorkingWithDatesApplication.class, args);
        //get service class object
		service=ctx.getBean("empService",EmployeeInfoService.class);
		dto=new EmployeeInfoDTO();
		dto.setEname("mahi");
		dto.setEadd("delhi");
		//using LocalDate of time API
		dto.setDoj(LocalDate.of(12,10,2));
		dto.setDob(new Date(90,10,12,12,10,90));
		dto.setBatchTime(new Date());
		
		//call meyhods
		System.out.println(service.registerEmployee(dto));		
		//close container
	    ((ConfigurableApplicationContext) ctx).close();
	 }

}
