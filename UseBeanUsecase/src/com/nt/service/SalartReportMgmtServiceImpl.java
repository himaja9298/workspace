package com.nt.service;

import com.nt.dto.EmployeeDTO;

public class SalartReportMgmtServiceImpl implements SalartReportMgmtService {
	public SalartReportMgmtServiceImpl() {
	System.out.println("SalartReportMgmtServiceImpl:0-param constructor");
    }
	@Override
	public void generateReport(EmployeeDTO dto) {
		float netSalary=0.0f,grossSalary=0.0f;
		//calculate gross,net salaries
		grossSalary=dto.getBasicSalary()+(dto.getBasicSalary()*0.4f);
		netSalary=grossSalary-(grossSalary*0.15f);
		//set results to do
		dto.setGrossSalary(grossSalary);
		dto.setNetSalary(netSalary);
		
	}
	

	
	}


