package com.nt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerMgmtService;
import com.nt.vo.CustomerVO;
@Controller("mainController")
public class MainController {
	@Autowired
	private CustomerMgmtService service;
	
	CustomerDTO dto=null;
	String result=null;
    
	public String processCustomer(CustomerVO vo) throws Exception {
		dto=new CustomerDTO();
		dto.setCname(vo.getCname());
		dto.setCadd(vo.getCadd());
		dto.setPamt(Float.parseFloat(vo.getPamt()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Float.parseFloat(vo.getTime()));
		//use service
		result=service.calculateIntrestAmount(dto);
		return result;
	}
	

}
