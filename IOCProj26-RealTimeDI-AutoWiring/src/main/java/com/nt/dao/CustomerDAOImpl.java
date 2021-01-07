package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.sql.DataSource;

import com.nt.bo.CustomerBO;

public class CustomerDAOImpl implements CustomerDAO {
	private static String CUSTOMER_INSERT_QUERY="INSERT INTO spring_customer(cname,cadd,pamt,intrstamt) VALUES(?,?,?,?)";
	private DataSource ds;
	int count;
	
    //1-param constructor
	public CustomerDAOImpl(DataSource ds) {
		System.out.println("CustomerDAOImpl:1-param constructor");
		this.ds = ds;
	}

	@Override
	public int insert(CustomerBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		//get jdbc connection object
		con=ds.getConnection();
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
