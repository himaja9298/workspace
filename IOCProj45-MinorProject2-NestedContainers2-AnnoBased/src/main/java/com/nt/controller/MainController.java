package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;
import com.nt.vo.EmployeeVO;
@Controller("myController")
public class MainController {

	@Autowired
	private EmployeeService service;
	

public List<EmployeeVO> gatherEmpDetails(String desg1,String desg2,String desg3)throws Exception{
	  List<EmployeeVO> listvo=new ArrayList();	  
	  List<EmployeeDTO> listdto=null;
	  listdto=service.fetchEmployeeDetails(desg1, desg2, desg3);
	  listdto.forEach(dto->{
		  EmployeeVO vo=new EmployeeVO();
		  //vo.setEno(dto.getEno());
		  BeanUtils.copyProperties(dto, vo);
		  //System.out.println(vo.toString());
		  vo.setEno(String.valueOf(dto.getEno()));
		  vo.setSal(String.valueOf(dto.getSal()));
		  vo.setSerialNo(String.valueOf(dto.getSerialNo()));
		  vo.setDob(String.valueOf(dto.getDob()));
		  vo.setDoj(String.valueOf(dto.getDoj()));
		  //System.out.println(dto.toString());
		  listvo.add(vo);
	  });
	  
	  return listvo;
  }


	
}
