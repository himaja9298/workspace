package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.bo.StudentBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dao.IStudentDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.StudentDTO;

@Service("clgService")
@Scope("singleton")
public abstract class CollegeMgmtServiceImpl implements ICollegeMgmtService {
	@Autowired
	private IStudentDAO stdao;

	@Autowired
	private IEmployeeDAO empdao;

	
	public CollegeMgmtServiceImpl() {
		System.out.println("CollegeMgmtServiceImpl:0-param constrcutor");
	}

	@Lookup
	public abstract StudentBO fetchStudentBO();

	@Lookup
	public abstract EmployeeBO fetchEmployeeBO();

	@Override
	public String enrollStudent(StudentDTO dto) throws Exception {
		int count = 0;
		int total = 0;
		float avg = 0.0f;
		// get StudentBO object
		StudentBO bo = null;
		// write logic
		total = dto.getM1() + dto.getM2() + dto.getM3();
		avg = total / 3.0f;
		bo = fetchStudentBO();
		// convert dto to bo
		BeanUtils.copyProperties(dto, bo);
		bo.setTotal(total);
		bo.setAvg(avg);
		count = stdao.registerStudent(bo);
		return (count == 0) ? "Student not registered" : "Student registered";
	}

	@Override
	public String enrollEmployee(EmployeeDTO dto) throws Exception {
		float gsalary=0.0f;
		float netsalary=0.0f;
		int count=0;
		EmployeeBO bo=null;
		//write logic
		gsalary=dto.getSalary()+(dto.getSalary()*0.4f);
		netsalary=gsalary-(gsalary*0.2f);
		//get StudentBO object
		bo=fetchEmployeeBO();
		//convert dto to bo
		BeanUtils.copyProperties(dto,bo);
		bo.setGrosssalary(gsalary);
		bo.setNetsalary(netsalary);
		count=empdao.registerEmployee(bo);
		return (count==0)?"Employee not registered":"Employee registered";
	}
 }

