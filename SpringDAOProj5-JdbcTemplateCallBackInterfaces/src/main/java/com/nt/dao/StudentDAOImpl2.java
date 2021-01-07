package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository("studDao")
public class StudentDAOImpl2 implements IStudentDAO {
	private static String STUDENT_DETAILS_BY_ID = "SELECT sname,sadd,avg FROM student WHERE sno=?";
	private static String STUDENT_DETAILS_BY_ADDRESSES="SELECT sno,sname,sadd,avg FROM student WHERE sadd IN(?,?,?)";
	private static String STUDENT_DETAILS_BY_ADDRESSES1="SELECT sno,sname,sadd,avg FROM student WHERE sadd IN(?,?,?)";

	@Autowired
	private JdbcTemplate jt;

	@Override
	public StudentBO getStudentByNo(int sno) {
		StudentBO bo = null;
		bo = jt.queryForObject(STUDENT_DETAILS_BY_ID, 
				(rs,rowNum)->{
				StudentBO bo1 = null;
				bo1 = new StudentBO();
				bo1.setSname(rs.getString(1));
				bo1.setSadd(rs.getString(2));
				bo1.setAvg(rs.getFloat(3));
				return bo1;
                }
	          , sno);
		
		return bo;
			
	}

	@Override
	public List<StudentBO> getStudentsByAddresses(String city1, String city2, String city3) {
		List<StudentBO> listbo=null;
		//use jt
		listbo=jt.query(STUDENT_DETAILS_BY_ADDRESSES, 
				(rs)->{
					List<StudentBO> listbo1=null;
					StudentBO bo=null;
					listbo1=new ArrayList();
					while(rs.next()) {
						//get each record from rs
					 bo=new StudentBO();
					 bo.setSno(rs.getInt(1));
					 bo.setSname(rs.getString(2));
					 bo.setSadd(rs.getString(3));
					 bo.setAvg(rs.getFloat(4));
					 listbo1.add(bo);
					}//while
					return listbo1;

				}, 
				city1,city2,city3);
		return listbo;
	}

	@Override
	public List<StudentBO> getStudentsByAddresses1(String city1, String city2, String city3) {
		List<StudentBO>listbo=new ArrayList();
		jt.query(STUDENT_DETAILS_BY_ADDRESSES1, rs->{
			StudentBO bo=new StudentBO();
			bo.setSno(rs.getInt(1));
			bo.setSname(rs.getString(2));
			bo.setSadd(rs.getString(3));
			bo.setAvg(rs.getFloat(4));
			listbo.add(bo);
		 }, 
        city1,city2,city3);
		return listbo;
	}
	}