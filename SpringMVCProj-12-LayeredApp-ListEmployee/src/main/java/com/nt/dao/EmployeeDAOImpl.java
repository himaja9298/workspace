
package com.nt.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static String EMPLOYEE_QUERY = "SELECT ENO,ENAME,DESG,SALARY,DEPTNO FROM employee";
    private static String REGISTER_EMPLOYEE_QUERY = "INSERT INTO employee(ename,desg,salary,deptno) VALUES(?,?,?,?)";
    private static String GET_ALL_DEPTNOS="SELECT DISTINCT deptno  FROM employee ORDER BY deptno";
    private static String DELETE_EMP_QUERY="DELETE FROM employee WHERE eno=?";
    private static String GET_EMP_BY_ID_QUERY="SELECT ENO,ENAME,DESG,SALARY,DEPTNO FROM employee WHERE eno=?";
    private static String UPDATE_EMPLOYEE_QUERY="UPDATE employee SET ename=?,desg=?,salary=?,deptno=? WHERE eno=?";
    @Autowired
	private JdbcTemplate jt;

	@Override
	
	public List<EmployeeBO> getAllEmployee() {
		List<EmployeeBO>listBO=null;
		listBO=jt.query(EMPLOYEE_QUERY,new ListEmployeeRowMapper());
		return listBO;
	}
	
	private class ListEmployeeRowMapper implements ResultSetExtractor<List<EmployeeBO>>{

		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			  List<EmployeeBO> listBO=new ArrayList();
			  //copy  RS records to ListBO
			  while(rs.next()) {
				  EmployeeBO bo = new EmployeeBO();
				  //copy each record to One BO class obj
				    bo.setEno(rs.getInt(1));
					bo.setEname(rs.getString(2));
					bo.setDesg(rs.getString(3));
					bo.setSalary(rs.getFloat(4));
					bo.setDeptno(rs.getInt(5));
					listBO.add(bo);
			  }//while
			return listBO;
		}//extractData(-)
	}//inner class

	@Override
	public int insertEmployeee(EmployeeBO bo) {
		int count=0;
		//use jt
		count=jt.update(REGISTER_EMPLOYEE_QUERY,bo.getEname(),bo.getDesg(),bo.getSalary(),bo.getDeptno());
		return count;
	}

	@Override
	public List<Integer> getAllDeptnos() {
		List<Integer>deptnolist=new ArrayList();
		List<Map<String, Object>> deptnomap=null;
		deptnomap= jt.queryForList(GET_ALL_DEPTNOS);
		deptnomap.forEach(e->{
			deptnolist.add(((Integer) ( e.get("deptno"))).intValue());
		});
		return deptnolist;
	}

	@Override
	public int deleteEmployee(int id) {
		int count;
		count=jt.update(DELETE_EMP_QUERY,id);
		return count;
	}

	/*@Override
	public EmployeeBO getEmployeeById(int id) {
		EmployeeBO bo=nul
		//get bo
		bo=jt.queryForObject(GET_EMP_BY_ID_QUERY,new EmployeeMapper() ,id);
		return bo;
	}*/
	
	/*private class EmployeeMapper implements RowMapper<EmployeeBO>{

		@Override
		public EmployeeBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			  EmployeeBO bo = new EmployeeBO();
			  //copy each record to One BO class obj
			    bo.setEno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setDesg(rs.getString(3));
				bo.setSalary(rs.getFloat(4));
				bo.setDeptno(rs.getInt(5));
				return bo;
			}
	   }*/
	
	//java8 features based rowmapper		
	/*public EmployeeBO getEmployeeById(int id) {
		EmployeeBO bo=null;
		//get bo
		bo=jt.queryForObject(GET_EMP_BY_ID_QUERY,(rs,rowNum)->{
			EmployeeBO bo1 = new EmployeeBO();
			  //copy each record to One BO class obj
			    bo1.setEno(rs.getInt(1));
				bo1.setEname(rs.getString(2));
				bo1.setDesg(rs.getString(3));
				bo1.setSalary(rs.getFloat(4));
				bo1.setDeptno(rs.getInt(5));
				return bo1;
			});
			
		return bo;
	}*/
	

	@Override
	public EmployeeBO getEmployeeById(int id) {
		EmployeeBO bo=null;
		bo=jt.queryForObject(GET_EMP_BY_ID_QUERY, new BeanPropertyRowMapper<EmployeeBO>(EmployeeBO.class), id);
		return bo;
	}

	@Override
	public int updateEmployee(EmployeeBO bo) {
		System.out.println(bo);
		int count=0;
		count=jt.update(UPDATE_EMPLOYEE_QUERY,bo.getEname(),bo.getDesg(),bo.getSalary(),bo.getDeptno(),bo.getEno());
		return count;
	}
	
	
}//DAO class