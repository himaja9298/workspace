package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	
	//@Query("SELECT p.userid,p.name,c.mobileno,c.provider FROM User p INNER JOIN p.phones c")
	//@Query("SELECT p.userid,p.name,c.mobileno,c.provider FROM User p LEFT JOIN p.phones c")
	//@Query("SELECT p.userid,p.name,c.mobileno,c.provider FROM User p RIGHT JOIN p.phones c")
	@Query("SELECT p.userid,p.name,c.mobileno,c.provider FROM User p FULL JOIN p.phones c ")
	List<Object[]> fetchDataByJoins();

	

}