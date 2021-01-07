package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface IEmployeeDAO {
	public List<EmployeeBO> getAllEmployee();
    public int insertEmployeee(EmployeeBO bo);
    public List<Integer>getAllDeptnos();
    public int deleteEmployee(int id);
    public EmployeeBO getEmployeeById(int id); 
    public int updateEmployee(EmployeeBO bo);
}
