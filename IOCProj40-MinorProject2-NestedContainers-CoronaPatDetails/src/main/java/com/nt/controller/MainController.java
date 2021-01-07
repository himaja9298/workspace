package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.dto.CoronaDTO;
import com.nt.service.CoronaService;
import com.nt.vo.CoronaVO;


public class MainController {
	private static final String String = null;
	private CoronaService service;
	//1-param constructor
	public MainController(CoronaService service) {
		System.out.println("MainController:1-param constructor");
		this.service = service;
	}
	
  public List<CoronaVO> gatherEmpDetails(String add1,String add2,String add3)throws Exception{
	  List<CoronaVO> listvo=new ArrayList();	  
	  List<CoronaDTO> listdto=null;
	  listdto=service.fetchCoronaPatDetails(add1, add2, add3);
	     listdto.forEach(dto->{
	    	 CoronaVO vo=new CoronaVO();
		  //vo.setEno(dto.getEno());
		  BeanUtils.copyProperties(dto, vo);
		  //System.out.println(vo.toString());
		  vo.setPatno(String.valueOf(dto.getPatno()));
		  vo.setPatbill(String.valueOf(dto.getPatbill()));
		  vo.setSerialNo(String.valueOf(dto.getSerialNo()));
		  vo.setPatstage(String.valueOf(dto.getPatstage()));
		  
		  //System.out.println(dto.toString());
		  listvo.add(vo);
	  });
	  
	  return listvo;
  }


	
}
