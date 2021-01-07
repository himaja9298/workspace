package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Customer;

@Transactional
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	//-------------------Calling procedures---------------------------
	
	//-------------------------calling procedures  having  entity query by using @Query--------------------------------------
    @Query(nativeQuery =true,value="{CALL GET_CUSTOMER_BY_ADDRS(?)}")//In @Query approach we can't work with out params we have to work with only in params
    Iterable<Customer> getCustomersByAddrs(String addrs);
    
  //---------------------------calling procedures having scalar query by using @Procedure-----------------------------------------------------
	@Procedure(procedureName = "GET_CUSTOMER_COUNT_BY_ADDRS")//In @Procedure approach we can work with only scalar queries that too only with one outparam with required no.of inparams
    //int getCustomerCountByAddrs(String addrs);
     int GET_CUSTOMER_COUNT_BY_ADDRS(String addrs);
}
