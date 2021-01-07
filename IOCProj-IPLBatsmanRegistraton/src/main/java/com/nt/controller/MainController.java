package com.nt.controller;

import com.nt.dto.CricketerDTO;
import com.nt.service.CricketerMgmtService;
import com.nt.vo.CricketerVO;

public class MainController {
	private CricketerMgmtService service;
	CricketerDTO dto=null;
	String result=null;
    //1-param constructor
	public MainController(CricketerMgmtService service) {
		System.out.println("MainController.MainController()");
		this.service = service;
	}
	public String processCustomer(CricketerVO vo) throws Exception {
		dto=new CricketerDTO();
		dto.setCname(vo.getCname());
		dto.setCountry(vo.getCountry());
		dto.setInnings(Integer.parseInt(vo.getInnings()));//use service
		dto.setNotouts(Integer.parseInt(vo.getNotouts()));
		dto.setRuns(Integer.parseInt(vo.getRuns()));
		dto.setWickets(Integer.parseInt(vo.getWickets()));
		result=service.calculateBtAndBwavg(dto);
		return result;
	}
	

}
