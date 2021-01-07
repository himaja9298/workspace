package com.nt.controller;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerMgmtService;
import com.nt.vo.CustomerVO;

public class MainController {
	private CustomerMgmtService service;
	CustomerDTO dto=null;
	String result=null;
    //1-param constructor
	public MainController(CustomerMgmtService service) {
		System.out.println("MainController.MainController()");
		this.service = service;
	}
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
