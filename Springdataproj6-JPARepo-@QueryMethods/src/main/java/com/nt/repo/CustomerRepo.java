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
	// Bulk select operations on entity queries with positional params(Entity
	// queries all column values)
	@Query("FROM Customer")
	Iterable<Customer> getAllCustomers();

	@Query("FROM Customer WHERE cadd=?1")
	Iterable<Customer> getCustomersByCadd(String addrs);

	@Query("FROM Customer WHERE billAmt>=?1 AND billAmt<=?2")
	Iterable<Customer> getCustomersByBillAmtRange(double start, double end);

	// Bulk select operations on entity queries with named params(Entity queries all
	// column values)
	@Query("FROM Customer WHERE cadd in(:city1,:city2)")
	Iterable<Customer> getCustomersByCadd(String city1, String city2);

	/*
	 * @Query("FROM Customer WHERE cadd IN(:cityOne,:cityTwo)")
	 * Iterable<Customer>getCustomersByAddrs(@Param("cityOne")String
	 * city1,@Param("cityTwo")String city2);
	 */
	// Bulk select operations with named params(specific multiple column
	// values-scalar queries)
	@Query("SELECT cno,cadd FROM Customer WHERE cname=:name")
	Iterable<Object[]> getCustomersByName(@Param("name") String str);

	// Bulk select operations with named params(specific column values-scalar
	// queries)
	@Query("SELECT cno FROM Customer WHERE billAmt>:amnt")
	Iterable<Integer> getCustomersByBill(@Param("amnt") double bill);

	// Single row select operation using HQL/JPQL (entity query)
	@Query("FROM Customer WHERE cname=:name")
	Customer getCustomerByName(String name);

	// Single row select operation using HQL/JPQL scalar queries(selecting multiple
	// columns data)
	@Query("SELECT cno,cname FROM Customer WHERE billAmt=:amnt")
	Object getDataOfCustomerByBillAmt(double amnt);
	/*
	 * @Query("SELECT cno,cname FROM Customer WHERE billAmt=:amnt") List<Object[]>
	 * getDataOfCustomerByBillAmt(double amnt);
	 */

	// Single row select operation using HQL/JPQL scalar queries(selecting single
	// column data)

	@Query("SELECT billAmt FROM Customer WHERE cno=:no")
	Double getCustomerBillAmtByNo(int no);
	
	//--------Aggreagte functions
	@Query("SELECT COUNT(*) FROM Customer")
	int getCountofCustomers();
	@Query("SELECT COUNT(*),MAX(billAmt),SUM(billAmt),AVG(billAmt) FROM Customer")
	Object getAggregateResults();

	// nonselect operations (Mainly update operation,delete operation[for insert go for hibernate save() method])
	// -------update operation-------------------
	@Modifying
	@Query("UPDATE Customer SET cadd=:addrs WHERE cname=:name")
	int updateCustomerAddrsByName(String name, String addrs);

	// -------delete operation-------------------
    @Modifying
	@Query("DELETE FROM Customer WHERE cadd=:addrs")
	int dleteCustomerByAdd(String addrs);

   //-------------working with native sql queries--------------------
    //@Query(nativeQuery = true,value="SELECT CNO,CNAME,CADD,BILL_AMT FROM CUSTOMER WHERE CADD=?")
    //@Query(nativeQuery = true,value="SELECT CNO,CNAME,CADD,BILL_AMT FROM CUSTOMER WHERE CADD=?1")
    @Query(nativeQuery = true,value="SELECT CNO,CNAME,CADD,BILL_AMT FROM CUSTOMER WHERE CADD=:addrs")
    Iterable<Customer> fetchCustomersByCadd(String addrs);
   
     //selecting sysdate
    @Query(nativeQuery = true,value="SELECT NOW()")
    java.util.Date getSysDate();
    
    //insert queries using nativeSQL queries
    @Transactional
    @Query(nativeQuery=true,value="INSERT INTO CUSTOMER(CNO,BILL_AMT,CADD,CNAME) VALUES(HIBERNATE_SEQUENCE.NEAXT_VAL,?,?,?)")
    @Modifying
    int insertCustomersData(double biiamnt,String addrs,String name);

    //using stored procedure
    @Procedure(name="getCustomersByAddrs")
    public int getCustomersCountByaddrs(String addrs);

}

