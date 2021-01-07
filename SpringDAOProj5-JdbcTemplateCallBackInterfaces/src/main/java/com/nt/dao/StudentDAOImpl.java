package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;
//@Repository("studDao")
public class StudentDAOImpl implements IStudentDAO {
	private static String STUDENT_DETAILS_BY_ID = "SELECT sname,sadd,avg FROM student WHERE sno=?";
	private static String STUDENT_DETAILS_BY_ADDRESSES="SELECT sno,sname,sadd,avg FROM student WHERE sadd IN(?,?,?)";
	private static String STUDENT_DETAILS_BY_ADDRESSES1="SELECT sno,sname,sadd,avg FROM student WHERE sadd IN(?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public StudentBO getStudentByNo(int sno) {
		StudentBO bo = null;
		bo = jt.queryForObject(STUDENT_DETAILS_BY_ID, new StudentRowMapper(), sno);

		return bo;
	}

   private static class StudentRowMapper implements RowMapper<StudentBO>{

		@Override
		public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			StudentBO bo1=null;
			bo1=new StudentBO();
			bo1.setSname(rs.getString(1));
			bo1.setSadd(rs.getString(2));
			bo1.setAvg(rs.getFloat(3));
			return bo1;
		}
		
	}

@Override
public List<StudentBO> getStudentsByAddresses(String city1, String city2, String city3) {
	List<StudentBO>listbo=null;
	listbo=new ArrayList();
	listbo=jt.query(STUDENT_DETAILS_BY_ADDRESSES, 
			        new StudentResultSetExtractor(),
			       city1,city2,city3);
	return listbo;
}
 private static class StudentResultSetExtractor implements ResultSetExtractor<List<StudentBO>>{
 @Override
public List<StudentBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
	List<StudentBO> listbo=null;
	StudentBO bo=null;
	listbo=new ArrayList();
	while(rs.next()) {
		//get each record from rs
	 bo=new StudentBO();
	 bo.setSno(rs.getInt(1));
	 bo.setSname(rs.getString(2));
	 bo.setSadd(rs.getString(3));
	 bo.setAvg(rs.getFloat(4));
	 listbo.add(bo);
	}//while
	return listbo;
}
 }

@Override
public List<StudentBO> getStudentsByAddresses1(String city1, String city2, String city3) {
	List<StudentBO>listbo=new ArrayList();
    //use jt
	jt.query(STUDENT_DETAILS_BY_ADDRESSES1,new StudentRowCallbackHandler(listbo) , city1,city2,city3);
	return listbo;
}

private static class StudentRowCallbackHandler implements RowCallbackHandler {
	private List<StudentBO> listbo;
	
	public StudentRowCallbackHandler(List<StudentBO> listbo) {
		this.listbo=listbo;
	}
	
	@Override
	public void processRow(ResultSet rs) throws SQLException {
		
		StudentBO bo=new StudentBO();
		bo.setSno(rs.getInt(1));
		bo.setSname(rs.getString(2));
		bo.setSadd(rs.getString(3));
		bo.setAvg(rs.getFloat(4));
		listbo.add(bo);
	 }
	
  }
}