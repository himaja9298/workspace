package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDAO dao;
	
	@Override
	public int fetchEmpCount() {
		int count=0;
		//use dao
		count=dao.getEmpCount();
		return count;
	}


	@Override
	public String fetchEnameByNo(int eno) {
		String name=null;
		//use dao
		name=dao.getEnameByNo(eno);
		return name;
	}


	@Override
	public Map<String, Object> fetchEmpDetailsByNo(int eno) {
		Map<String,Object> map=null;
		//use dao
		map=dao.getEmpDetailsByNo(eno);
		return map;
	}


	@Override
	public List<Map<String, Object>> fetchEmpDetailsByDesgs(String desg1, String desg2) {
		// use dao
		return dao.getEmpDetailsByDesgs(desg1, desg2);
	}


	@Override
	public String addBonusToEmployeeByDesg(String desg, float bonus) {
		int count=0;
		// use dao
		count=dao.addBonusToEmployeeByDesg(desg, bonus);
		return count!=0?count+" Employee Updated":"Employee not updated";
	}


	@Override
	public String insertEmployee(String name, String desg, float sal, int no) {
		int count=0;
		//use dao
		count=dao.insertEmployee(name, desg, sal, no);
		return count!=0?"Employee record inserted":"Employee record not inserted";
	}


	@Override
	public String deleteEmployeeByDesg(String desg) {
		int count=0;
		// use dao
		count=dao.deleteEmployeeByDesg(desg);
		return count!=0?count+" Employee deleted":"Employee not deleted";
	}

}
