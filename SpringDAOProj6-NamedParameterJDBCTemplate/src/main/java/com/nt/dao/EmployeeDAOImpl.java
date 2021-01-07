package com.nt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;


@Repository("empDao")
public class EmployeeDAOImpl implements IEmployeeDAO {
    @Autowired
	private NamedParameterJdbcTemplate npjt;
	
    private static final String GET_EMP_BY_NAME="SELECT ename FROM emp WHERE eno=:no"; 
    private static final String GET_EMP_BY_DESGS="SELECT eno,ename,desg,salary FROM emp WHERE desg in(:desg1,:desg2,:desg3)";
    private static final String INSERT_EMP_QUERY="INSERT INTO emp values(:eno,:ename,:desg,:salary)";
    
    @Override
	public String getEnameByNO(int no) {
	String name=null;
    	//use jt
	Map<String,Object> map=new HashMap();
	map.put("no", no);
	name=npjt.queryForObject(GET_EMP_BY_NAME, map, String.class);
		return name;
	}
	@Override
	public  List<EmployeeBO> getEmployeeByDesgs(String desg1, String desg2, String desg3) {
		List<EmployeeBO>listbo=null;
		MapSqlParameterSource msps=new MapSqlParameterSource();
		msps.addValue("desg1",desg1);
		msps.addValue("desg2",desg2);
		msps.addValue("desg3",desg3);
		//use dao
		listbo=npjt.query(GET_EMP_BY_DESGS, msps, rs->{
			List<EmployeeBO> listbo1=null;
			listbo1=new ArrayList();
			while(rs.next()) {
				//get each record from rs
			EmployeeBO bo=new EmployeeBO();
			 bo.setEno(rs.getInt(1));
			 bo.setEname(rs.getString(2));
			 bo.setDesg(rs.getString(3));
			 bo.setSalary(rs.getFloat(4));
			 listbo1.add(bo);
			}//while
			return listbo1;

			
		});

		return listbo;
	}
	@Override
	public int insertEmployee(EmployeeBO bo) {
		int count=0;
		BeanPropertySqlParameterSource bpsps=new BeanPropertySqlParameterSource(bo);
		count=npjt.update(INSERT_EMP_QUERY, bpsps);
		return count;
	}

	

}
