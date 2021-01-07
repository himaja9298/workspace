package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;


import com.nt.bo.StudentBO;

//@Repository("studDao")
public class StudentDAOImpl3 implements IStudentDAO {
	private static String STUDENT_DETAILS_BY_ID = "SELECT sname,sadd,avg FROM student WHERE sno=?";
	private static String STUDENT_DETAILS_BY_ADDRESSES="SELECT sno,sname,sadd,avg FROM student WHERE sadd IN(?,?,?)";

	@Autowired
	private JdbcTemplate jt;

	@Override
	public StudentBO getStudentByNo(int sno) {
		StudentBO bo = null;
		bo = jt.queryForObject(STUDENT_DETAILS_BY_ID, 
				new BeanPropertyRowMapper<StudentBO>(StudentBO.class)
	          , sno);
		
		return bo;
			
	}

	@Override
	public List<StudentBO> getStudentsByAddresses(String city1, String city2, String city3) {
		List<StudentBO>listbo=null;
		//use jt
		BeanPropertyRowMapper<StudentBO> bprmp=null;
		bprmp=new BeanPropertyRowMapper<StudentBO>(StudentBO.class);
		listbo=jt.query(STUDENT_DETAILS_BY_ADDRESSES, new RowMapperResultSetExtractor<StudentBO>(bprmp), city1,city2,city3);
		return listbo;
	}

	@Override
	public List<StudentBO> getStudentsByAddresses1(String city1, String city2, String city3) {
		// TODO Auto-generated method stub
		return null;
	}
	}