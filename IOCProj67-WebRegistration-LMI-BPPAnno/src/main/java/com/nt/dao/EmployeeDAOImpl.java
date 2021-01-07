package com.nt.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
@Scope("singleton")
public class EmployeeDAOImpl implements IEmployeeDAO {

	public EmployeeDAOImpl() {
	System.out.println("EmployeeDAO:0-param constructor");
	}
	
	@Override
	public int registerEmployee(EmployeeBO bo) throws Exception {
		System.out.println("inserting into employee db table having data::"+bo);
		return 1;
	}

}
