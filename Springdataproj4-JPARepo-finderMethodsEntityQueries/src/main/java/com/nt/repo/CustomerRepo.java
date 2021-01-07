package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	//SELECT CNO,CNAME,CADD,BILL_AMT FROM CUSTOMER WHERE CADD=?;
	List<Customer>findByCadd(String addrs);
	
	//SELECT CNO,CNAME,CADD,BILL_AMT FROM CUSTOMER WHERE BILL_AMT>?;
	List<Customer>findByBillAmtGreaterThan(double billamnt);
	
	//SELECT CNO,CNAME,CADD,BILL_AMT FROM CUSTOMER WHERE CNAME LIKE 'J%';
	List<Customer>findByCnameLike(String initChars);
	
	//SELECT CNO,CNAME,CADD,BILL_AMT FROM CUSTOMER WHERE CNAME LIKE 'J&';
    List<Customer>findByCnameStartingWith(String initChars);
    
    //SELECT CNO,CNAME,CADD,BILL_AMT FROM CUSTOMER WHERE CNAME LIKE '%J%';
    List<Customer>findByCnameContaining(String chars);
   
     //SELECT CNO,CNAME,CADD,BILL_AMT FROM CUSTOMER WHERE CNAME IS NULL;
     List<Customer>findByCnameIsNull();
     
     //SELECT CNO,CNAME,CADD,BILL_AMT FROM CUSTOMER WHERE CNAME IS NOT NULL;
     List<Customer>findByCnameIsNotNull();
  
   //SELECT CNO,CNAME,CADD,BILL_AMT FROM CUSTOMER WHERE CNAME=? ORDERBY CNO DESC;
     List<Customer>findByCnameOrderByCnoDesc(String str);




}
