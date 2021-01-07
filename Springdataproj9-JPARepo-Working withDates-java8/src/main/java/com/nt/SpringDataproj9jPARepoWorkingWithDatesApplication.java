package com.nt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.EmployeeInfoDTO;
import com.nt.service.EmployeeInfoService;

@SpringBootApplication
public class SpringDataproj9jPARepoWorkingWithDatesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeInfoService service=null;
		EmployeeInfoDTO dto=null;
		
		
		//create container
		ctx=SpringApplication.run(SpringDataproj9jPARepoWorkingWithDatesApplication.class, args);
        //get service class object
		service=ctx.getBean("empService",EmployeeInfoService.class);
		dto=new EmployeeInfoDTO();
		dto.setEname("mahi");
		dto.setEadd("delhi");
		dto.setDob(LocalDateTime.of(90, 11, 12, 12,20,30));
		dto.setDoj(LocalDate.of(120, 10, 20));
		dto.setBatchTime(LocalTime.of(13, 30, 45));
		
		//call meyhods
		System.out.println(service.registerEmployee(dto));		
		//close container
	    ((ConfigurableApplicationContext) ctx).close();
	 }

}
