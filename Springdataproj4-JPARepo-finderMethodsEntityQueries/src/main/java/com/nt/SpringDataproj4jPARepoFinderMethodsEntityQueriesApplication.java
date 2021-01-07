package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@SpringBootApplication
public class SpringDataproj4jPARepoFinderMethodsEntityQueriesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerRepo custRepo=null;
		Customer entity=null,entity1=null;
		//create container
		ctx=SpringApplication.run(SpringDataproj4jPARepoFinderMethodsEntityQueriesApplication .class, args);
        //get repositiry bean
		custRepo= ctx.getBean(CustomerRepo.class);
		//call meyhods
		//System.out.println(custRepo.findByCadd("hyd"));
 	    //custRepo.findByBillAmtGreaterThan(350000.0).forEach(System.out::println);
		//custRepo.findByCnameLike("j%").forEach(System.out::println);
		//custRepo.findByCnameStartingWith("j").forEach(System.out::println);
		//custRepo.findByCnameContaining("m").forEach(System.out::println);
		//custRepo.findByCnameIsNull().forEach(System.out::println);
		//custRepo.findByCnameIsNotNull().forEach(System.out::println);
		custRepo.findByCnameOrderByCnoDesc("manohar").forEach(System.out::println);
		
		
		
		//close container
	    ((ConfigurableApplicationContext) ctx).close();
	}

}
