package com.nt.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBO;

@Profile({"uat","prod"})
@Repository("mysql1custDao")
public class MySql1CustomerDAOImpl implements CustomerDAO {
	private static String CUSTOMER_INSERT_QUERY="INSERT INTO spring_customer(cname,cadd,pamt,intrstamt) VALUES(?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	int count;
    
	@Override
	public int insert(CustomerBO bo) throws Exception {
		System.out.println("MySql1CustomerDAOImpl.insert()"+jt.getDataSource().getClass());
		int count=0;
		//use jt
		count=jt.update(CUSTOMER_INSERT_QUERY, bo.getCname(),bo.getCadd(),bo.getPamt(),bo.getIntramt());
		return count;
		
	}

}
