package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;




@Repository("authDao")
public class AuthDAOImpl implements IAuthDAO {
    @Autowired
	private SimpleJdbcCall sjc;

	@Override
	public String loginUser(String user, String pwd) {
		//set procedurename to sjc
		sjc.setProcedureName("P_AUTHENTICATION");
		Map<String,Object> inputmap=new HashMap();
		inputmap.put("USERNAME", user);inputmap.put("PASSWORD",pwd);
		//use sjc& call procedure
		Map<String,Object> outparam=sjc.execute(inputmap);
		String output=(String) outparam.get("RESULT");
		System.out.println(output);
		 return (String) outparam.get("RESULT");
	}//method

 }//dao
