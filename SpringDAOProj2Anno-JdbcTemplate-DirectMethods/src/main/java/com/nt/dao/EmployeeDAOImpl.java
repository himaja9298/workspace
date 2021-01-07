package com.nt.dao;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("empDao")
public class EmployeeDAOImpl implements IEmployeeDAO {
   private static String EMP_COUNT_QUERY="SELECT COUNT(*) FROM EMPLOYEE"; 
   private static String EMP_NAME_QUERY="SELECT ename FROM EMPLOYEE WHERE eno=?";
   private static String EMP_DETAILS_QUERY="SELECT ename,desg,salary,deptno FROM employee WHERE eno=?";
   private static String EMPS_DETAILS_QUERY="SELECT ename,desg,salary,deptno FROM employee WHERE desg in(?,?) ORDER BY desg";
   private static String EMPS_INSERT_QUERY="INSERT INTO employee(ename,desg,salary,deptno) VALUES(?,?,?,?)";
   private static String UPDATE_EMP_SAL_QUERY="UPDATE employee SET salary=salary+? WHERE desg=?";
   private static String DELETE_EMP_QUERY="DELETE FROM employee WHERE desg=?";
   
   @Autowired
   private JdbcTemplate jt;
	
	@Override
	public int getEmpCount() {
    	int count=0;
    	//use jt
    	count=jt.queryForObject(EMP_COUNT_QUERY, Integer.class);
    	return count;
	}

	@Override
	public String getEnameByNo(int eno) {
		String name=null;
		//use jt
		name=jt.queryForObject(EMP_NAME_QUERY, String.class, eno);
		return name;
	}

	@Override
	public Map<String, Object> getEmpDetailsByNo(int eno) {
		Map<String,Object> mapdata=null;
		//use jt
		mapdata=jt.queryForMap(EMP_DETAILS_QUERY,eno);
		return mapdata;
	}

	@Override
	public List<Map<String, Object>> getEmpDetailsByDesgs(String desg1, String desg2) {
		//use jt
		return jt.queryForList(EMPS_DETAILS_QUERY, desg1,desg2);
	}

	@Override
	public int insertEmployee(String name, String desg, float sal, int no) {
		int count=0;
		//use jt
		count=jt.update(EMPS_INSERT_QUERY,name,desg,sal,no);
		return count;
	}
	
	
	@Override
	public int addBonusToEmployeeByDesg(String desg, float bonus) {
		int count=0;
		//use jt
		count=jt.update(UPDATE_EMP_SAL_QUERY, bonus,desg);
		return count;
	}

	@Override
	public int deleteEmployeeByDesg(String desg) {
		int count=0;
		// use jt
		count=jt.update(DELETE_EMP_QUERY, desg);
		return count;
	}

	

}
