package com.nt.service;

import java.util.List;

import com.nt.bo.EmployeeBO;
import com.nt.dto.EmployeeDTO;

public interface IEmployeeService {

	public String fetchEmployeeByNo(int no);
	public List<EmployeeDTO> fetchEmployeeByDesg(String desg1,String desg2,String desg3);
	 public String registerEmployee(EmployeeDTO dto);
}
