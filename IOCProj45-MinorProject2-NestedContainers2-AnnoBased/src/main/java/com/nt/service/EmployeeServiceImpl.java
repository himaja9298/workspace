package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;
@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {
   
	@Autowired
	private EmployeeDAO dao;
   
	@Override
	public List<EmployeeDTO> fetchEmployeeDetails(String desg1, String desg2, String desg3) throws Exception {
		
		List<EmployeeBO> listbo=null;
		List<EmployeeDTO>listdto=new ArrayList();
		//convert inputs to uppercase
		desg1=desg1.toUpperCase();
		desg2=desg2.toUpperCase();
		desg3=desg3.toUpperCase();
		listbo=dao.getEmployeeDetails(desg1, desg2, desg3);
		
		listbo.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSal((float)Math.round(bo.getSal()));
			dto.setSerialNo(listdto.size()+1);
			listdto.add(dto);
		});
		return listdto;
	}

}
