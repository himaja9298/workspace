package com.nt;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.object.StoredProcedure;

import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@SpringBootApplication
public class SpringDataproj6jPARepoQueryMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerRepo custRepo=null;
		Customer entity=null,entity1=null;
		
		//create container
		ctx=SpringApplication.run(SpringDataproj6jPARepoQueryMethodsApplication.class, args);
        //get repositiry bean
		custRepo= ctx.getBean(CustomerRepo.class);
		//call meyhods
		//---------------------------calling procedures entity query by using @Query-----------------------------------------------------
		//custRepo.getCustomersByAddrs("hyd").forEach(System.out::println);
		
		//---------------------------calling procedures having scalar query by using @Procedure-----------------------------------------------------
		//System.out.println("Customer count"+custRepo.getCustomerCountByAddrs("hyd"));
		//System.out.println("customer count"+custRepo.GET_CUSTOMER_COUNT_BY_ADDRS("delhi"));
		
		//---------------------------calling(Entity&Scalar queries using procedures by using EntityManager-----------------------------------------------------
		     //-----Entity query contained procedure calling -------------
		/*EntityManager manager=ctx.getBean(EntityManager.class);
		//create StoredprocedureQuery object
		StoredProcedureQuery procedure=manager.createStoredProcedureQuery("GET_CUSTOMER_BY_ADDRS",Customer.class);
		//Register procedure in and out param
		procedure.registerStoredProcedureParameter(1, String.class,ParameterMode.IN);
		//Set values to IN param
		procedure.setParameter(1,"hyd");
		//calling stored procedure
		procedure.getResultList().forEach(System.out::println);
		*/
		      //-----Scalar query contained procedure calling -------------
		/*EntityManager manager=ctx.getBean(EntityManager.class);
		//Create StoredProcedureQuery object
		StoredProcedureQuery procedure= manager.createStoredProcedureQuery("GET_CUSTOPMER_COUNT_BY_ADDRS");
		//register procedure IN and OUT parameters
		procedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
		procedure.registerStoredProcedureParameter(2, Integer.class,ParameterMode.OUT);
		//set values to params
		procedure.setParameter(1,"hyd");
		//get results from outParam
		int count=(int) procedure.getOutputParameterValue(2);
		System.out.println("Count of customers:  "+count);
		*/
		
		//-----Entity query contained procedure calling -------------
		EntityManager manager=ctx.getBean(EntityManager.class);
		//create StoredprocedureQuery object
		StoredProcedureQuery procedure=manager.createStoredProcedureQuery("GET_CUSTOMER_BY_ADDRS");
		//Register procedure in and out param
		procedure.registerStoredProcedureParameter(1, String.class,ParameterMode.IN);
		//Set values to IN param
		procedure.setParameter(1,"hyd");
		//calling stored procedure
		procedure.getResultList().forEach(System.out::println);
		
		
		
		//close container
	    ((ConfigurableApplicationContext) ctx).close();
	 }

}
