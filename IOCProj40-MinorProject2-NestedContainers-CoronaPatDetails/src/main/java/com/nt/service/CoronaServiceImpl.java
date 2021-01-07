package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.CoronaBO;
import com.nt.dao.CoronaDAO;
import com.nt.dto.CoronaDTO;

public class CoronaServiceImpl implements CoronaService {
   private CoronaDAO dao;
    
   //1-param constructor   
	public CoronaServiceImpl(CoronaDAO dao) {
	System.out.println("EmployeeServiceImpl:1-param constructor");
	this.dao = dao;
}

	@Override
	public List<CoronaDTO> fetchCoronaPatDetails(String add1, String add2, String add3) throws Exception {
		
		List<CoronaBO> listbo=null;
		List<CoronaDTO>listdto=new ArrayList();
		//convert inputs to uppercase
		add1=add1.toUpperCase();
		add2=add2.toUpperCase();
		add3=add3.toUpperCase();
		listbo=dao.getCoronaPatDetails(add1, add2, add3);
		
		listbo.forEach(bo->{
			CoronaDTO dto=new CoronaDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setPatbill((float)Math.round(bo.getPatbill()));
			dto.setSerialNo(listdto.size()+1);
			listdto.add(dto);
		});
		return listdto;
	}

}
