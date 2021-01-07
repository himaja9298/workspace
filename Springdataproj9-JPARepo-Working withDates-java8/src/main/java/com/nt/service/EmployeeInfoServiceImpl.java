package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeInfoDTO;
import com.nt.entity.EmployeeInfo;
import com.nt.repo.EmployeeInfoRepo;
@Service("empService")
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
    @Autowired
	private EmployeeInfoRepo empRepo;
	
    @Override
	public int registerEmployee(EmployeeInfoDTO dto) {
		EmployeeInfo entity=null;
		//create entoty class object
		entity=new EmployeeInfo();
		//copy properties from dto to entitiy
		BeanUtils.copyProperties(dto, entity);
		return empRepo.save(entity).getEid();
	}

}
