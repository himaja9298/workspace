package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {

	public List<EmployeeDTO> fetchAllEmployee();
	public String registerEmployee(EmployeeDTO dto);
	public List<Integer> fetchAllDeptnos();
	public String removeEmployee(int id);
	public EmployeeDTO fetchEmployeeById(int id);
	public String ModifyEmployee(EmployeeDTO dto);
}
