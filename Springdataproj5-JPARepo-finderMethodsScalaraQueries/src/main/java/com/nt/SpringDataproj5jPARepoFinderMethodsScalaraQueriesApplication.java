package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;
import com.nt.repo.CustomerRepo.ResultView;
import com.nt.repo.CustomerRepo.ResultView1;

@SpringBootApplication
public class SpringDataproj5jPARepoFinderMethodsScalaraQueriesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		CustomerRepo custRepo=null;
		Customer entity=null,entity1=null;
		
		//create container
		ctx=SpringApplication.run(SpringDataproj5jPARepoFinderMethodsScalaraQueriesApplication.class, args);
        //get repositiry bean
		custRepo= ctx.getBean(CustomerRepo.class);
		//call meyhods
		/*List<ResultView> listview=custRepo.findByCadd("hyd");
		for(ResultView v:listview) {
			System.out.println(v.getCno() +" "+ v.getCname());
		}
		
		List<ResultView1> listview1=custRepo.findByCname("harsita");
		for(ResultView1 v:listview1) {
			System.out.println(v.getCadd() +" "+ v.getBillAmt());
		}*/
		
		List<ResultView> listview=custRepo.findByCadd("hyd",(Class<T>) ResultView.class);
		
		//close container
	    ((ConfigurableApplicationContext) ctx).close();
	}

}
