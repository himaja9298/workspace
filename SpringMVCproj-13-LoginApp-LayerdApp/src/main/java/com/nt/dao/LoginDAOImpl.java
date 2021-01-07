package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.nt.bo.UserBO;
@Repository("loginDAO")
public class LoginDAOImpl implements ILoginDAO {
    @Autowired
	private SimpleJdbcCall sjc;
	
	@Override
	public String authenticate(UserBO bo) {
		//set procedure name
		sjc.setProcedureName("P_AUTHENTICATION");
		//prepare map object with in param,outparams
		Map<String,Object> inputmap=new HashMap();
		inputmap.put("USERNAME",bo.getUname());inputmap.put("PASSWORD",bo.getPwd());
		Map<String, Object>  outputmap=sjc.execute(inputmap);
        //get result from outputmap
	   String result=(String) outputmap.get("RESULT");
	    return result;
	}

}
