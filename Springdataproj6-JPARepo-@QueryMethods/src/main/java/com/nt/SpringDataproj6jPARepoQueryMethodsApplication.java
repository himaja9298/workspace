package com.nt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

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
		
		//------Bulk data select operations------------------
		
		//custRepo.getAllCustomers().forEach(System.out::println);
		//custRepo.getCustomersByCadd("hyd").forEach(System.out::println);
		//custRepo.getCustomersByBillAmtRange(150000, 350000).forEach(System.out::println);
		//custRepo.getCustomersByAddrs("hyd","kadapa").forEach(System.out::println);
		/* custRepo.getCustomersByName("manohar").forEach( row-> {
			//System.out.println(row[0]+" "+row[1]);
			for(Object o:row) {
				System.out.println(o+"  ");
			}
		 });
		*/
		//custRepo.getCustomersByBill(150000.0).forEach(System.out::println);
		
		//------------------single row select operations------------------
		
		//System.out.println(custRepo.getCustomerByName("manohar"));
		/* Object obj=custRepo.getDataOfCustomerByBillAmt(150000.0);
		 Object data[]= (Object[]) obj;
		 System.out.println(data[0]+" "+data[1]);
		*/
		/* List<Object[]> list=custRepo.getDataOfCustomerByBillAmt(150000.0);
	    //Object data[]=list.get(0);
	    //System.out.println(data[0]+"  "+data[1]);
		 list.forEach(arr->{
			 System.out.println(arr[0]+" "+arr[1]);
		 });
		*/
		//System.out.println(custRepo.getCustomerBillAmtByNo(56));
		//System.out.println("count of customers::"+custRepo.getCountofCustomers());
		/* Object data[]=(Object[])custRepo.getAggregateResults();
		System.out.println("count of customers:"+data[0]);
		System.out.println("Max of BillAmt:"+data[1]);
		System.out.println("Sum of BillAmt:"+data[2]);
		System.out.println("Avg of BillAmt:"+data[3]);
		*/

		//---------update operations-------------------
		//System.out.println("updated customers::"+custRepo.updateCustomerAddrsByName("jagdeesh", "delhi"));
		//System.out.println("Deleted customers::"+custRepo.dleteCustomerByAdd("hyd"));
		
		//------------Working with nativeSQL queries-----------------------
		//custRepo.fetchCustomersByCadd("delhi").forEach(System.out::println);
		//System.out.println("System date::"+custRepo.getSysDate());
		//System.out.println(custRepo.insertCustomersData(500000.0, "hyd","mahi"));
		System.out.println(custRepo.getCustomersCountByaddrs("delhi"));
		
		//close container
	    ((ConfigurableApplicationContext) ctx).close();
	 }

}
