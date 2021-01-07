package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	//--------------Static Scalar Projections--------------------------------------
	
	//ResultView interface
	interface ResultView{
		Integer getCno();
		String getCname();
	}
	
	//SELECT CNO,CNAME FROM CUSTOMER WHERE CADD=?;
	//List<ResultView>findByCadd(String addrs);
	//ResultView1 interface
	interface ResultView1{
		String getCadd();
		Double getBillAmt();
	}
	
	//SELECT CNAME,BILL_AMT FROM CUSTOMER WHERE CNAME=?;
		List<ResultView1>findByCname(String name);
	
//--------------Dynamic Scalar Projections--------------------------------------
		interface view{
			//marker interface
		}
		
		<T extends view> List<T>findByCadd(String addrs,Class<T> clazz);

		
		

}
