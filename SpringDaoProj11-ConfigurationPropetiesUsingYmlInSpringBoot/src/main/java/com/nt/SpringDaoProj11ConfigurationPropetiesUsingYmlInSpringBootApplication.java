package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.beans.Person;
import com.nt.beans.Person1;

@SpringBootApplication
public class SpringDaoProj11ConfigurationPropetiesUsingYmlInSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		Person1 per1 = null;
		Person per = null;
		ctx = SpringApplication.run(SpringDaoProj11ConfigurationPropetiesUsingYmlInSpringBootApplication.class, args);
		// get Person1 class object
		per1 = ctx.getBean("per1", Person1.class);
		// System.out.println(per1);
		
		// get Person class object
		per = ctx.getBean("per", Person.class);
		 System.out.println(per);

	}

}
