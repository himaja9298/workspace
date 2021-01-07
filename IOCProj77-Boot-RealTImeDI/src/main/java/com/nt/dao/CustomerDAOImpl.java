package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;
@Repository("custDao")
public class CustomerDAOImpl implements CustomerDAO {
	private static String CUSTOMER_INSERT_QUERY="INSERT INTO spring_customer(cname,cadd,pamt,intrstamt) VALUES(?,?,?,?)";
	
	@Autowired
	//@Qualifier("mysql2hkds")
	private DataSource ds;

	int count;
    
	@Override
	public int insert(CustomerBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		//get jdbc connection object
		con=ds.getConnection();
		System.out.println(ds.getClass());
		ps=con.prepareStatement(CUSTOMER_INSERT_QUERY);
		//set values to query params
		ps.setString(1,bo.getCname());
		ps.setString(2, bo.getCadd());
		ps.setFloat(3, bo.getPamt());
		ps.setFloat(4, bo.getIntramt());
		//execute query
		count=ps.executeUpdate();
		//close jdbc objects
		ps.close();
		con.close();
		return count;
		
	}

}
