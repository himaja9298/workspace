package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.bo.BankAccountBO;



@Repository("bankDao")
public class BankDAOImpl implements IBankDAO {
    @Autowired
	private SimpleJdbcInsert sji;

	/*@Override
	public int insertCustomer(BankAccountBO bo) {
		int count=0;
		//prepare map object having column names and values
		Map<String,Object>map=new HashMap();
		map.put("actno",bo.getActno());map.put("cname",bo.getCname());map.put("balamnt",bo.getBalamnt());
		//set tablename
		sji.setTableName("bankdetails");
		//use sji
		count=sji.execute(map);
		return count;
	}*/
    @Override
	public int insertCustomer(BankAccountBO bo) {
		int count=0;
		//prepare BeanPropertySqlParameterSource (here bo class name properties must match with dbtable columns
		BeanPropertySqlParameterSource bpsps=new BeanPropertySqlParameterSource(bo);
		//set tablename
		sji.setTableName("bankdetails");
		//use sji
		System.out.println(bpsps);
		count=sji.execute(bpsps);
		return count;
	}
	
    }
