package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.nt.bo.CricketerBO;

public class CricketerDAOImpl implements CricketerDAO {
	private static String CRICKETER_INSERT_QUERY="INSERT INTO spring_cricketer(cname,country,btavg,bwavg) VALUES(?,?,?,?)";
	private DataSource ds;
	int count;
	//1-param constructor
    public CricketerDAOImpl(DataSource ds) {
		System.out.println("CricketerDAOImpl:1-param constructor");
		this.ds = ds;
	}	@Override
	public int insert(CricketerBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		//get jdbc connection object
		con=ds.getConnection();
		ps=con.prepareStatement(CRICKETER_INSERT_QUERY);
		//set values to query params
		ps.setString(1,bo.getCname());
		ps.setString(2, bo.getCountry());
		ps.setFloat(3, bo.getBtavg());
		ps.setFloat(4, bo.getBwavg());
		//execute query
		count=ps.executeUpdate();
		//close jdbc objects
		ps.close();
		con.close();
		return count;
		
	}

	

}
