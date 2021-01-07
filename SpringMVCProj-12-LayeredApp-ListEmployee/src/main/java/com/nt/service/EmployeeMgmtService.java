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
public class EmployeeMgmtService implements IEmployeeMgmtService {
    @Autowired
	private IEmployeeDAO dao;

	@Override
	public List<EmployeeDTO> fetchAllEmployee()  {
		List<EmployeeBO> listempbo=null;
		List<EmployeeDTO> listempdto=new ArrayList();
		
		//use dao
		listempbo=dao.getAllEmployee();
		listempbo.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSerialno(listempdto.size()+1);
			dto.setGrossSal(dto.getSalary()+dto.getSalary()*0.3f);
			dto.setNetSal(dto.getGrossSal()-dto.getGrossSal()*0.1f);
			dto.setSalary( Math.round(dto.getSalary()));
			//add dto to listempdto
			listempdto.add(dto);
		});
		return listempdto;
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int count=0;
		//copy properties from dto to bo
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		bo.setSalary((float)(dto.getSalary()));
		//use dao
		count=dao.insertEmployeee(bo);
		return count!=0?"Employee Registered":"Employee not registered";
	}

	@Override
	public List<Integer> fetchAllDeptnos() {
		//use dao
		return dao.getAllDeptnos();
		
	}

	@Override
	public String removeEmployee(int id) {
		int count=0;
		//use dao
		count=dao.deleteEmployee(id);
		return count!=0?" employee deleted":"Employee not deleted";
	}

	@Override
	public EmployeeDTO fetchEmployeeById(int id) {
		EmployeeDTO dto=null;
		EmployeeBO bo=null;
		//use dao
		bo=dao.getEmployeeById(id);
		dto=new EmployeeDTO();
		//copy to dto from bo
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	@Override
	public String ModifyEmployee(EmployeeDTO dto) {
		int count=0;
		EmployeeBO bo=null;
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.updateEmployee(bo);
		return count!=0?dto.getEno()+"Employee detail are found and updated":dto.getEno()+"Employee details are not updated";
	}

}
