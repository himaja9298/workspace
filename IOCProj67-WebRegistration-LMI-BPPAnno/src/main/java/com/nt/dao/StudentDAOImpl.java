package com.nt.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository("stuDAO")
@Scope("singleton")
public class StudentDAOImpl implements IStudentDAO {

	public StudentDAOImpl() {
	System.out.println("StudentDAO:0-param constructor");
	}
	
	@Override
	public int registerStudent(StudentBO bo) throws Exception {
		System.out.println("inserting into student db table having data::"+bo);
		return 1;
	}

}
