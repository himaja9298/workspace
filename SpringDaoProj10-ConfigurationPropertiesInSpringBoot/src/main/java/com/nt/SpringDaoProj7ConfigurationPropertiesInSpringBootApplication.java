package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.beans.Person;

@SpringBootApplication
public class SpringDaoProj7ConfigurationPropertiesInSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Person person=null;
		ctx=SpringApplication.run(SpringDaoProj7ConfigurationPropertiesInSpringBootApplication.class, args);
	    //get target class bean
		person=ctx.getBean("person",Person.class);
		System.out.println(person);
	
	}

}
