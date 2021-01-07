package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeService{
    @Autowired
	private IEmployeeDAO dao;
	
	@Override
	public String fetchEmployeeByNo(int no) {
		String name=null;
		//use dao
		name=dao.getEnameByNO(no);
		return name;
	}

	@Override
	public List<EmployeeDTO> fetchEmployeeByDesg(String desg1, String desg2, String desg3) {
		List<EmployeeDTO>listdto=new ArrayList();
		List<EmployeeBO>listbo=null;
		//use dao
		listbo=dao.getEmployeeByDesgs(desg1, desg2, desg3);
		listbo.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listdto.add(dto);
		});
		return listdto;
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) {
		int count=0;
		EmployeeBO bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.insertEmployee(bo);
		return (count!=0)?"Employee registered":"Employee not registered";
	}

}
