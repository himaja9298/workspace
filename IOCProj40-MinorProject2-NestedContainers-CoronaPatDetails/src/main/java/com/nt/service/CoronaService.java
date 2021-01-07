package com.nt.service;

import java.util.List;

import com.nt.dto.CoronaDTO;


public interface CoronaService {
	public List<CoronaDTO> fetchCoronaPatDetails(String add1,String add2,String add3) throws Exception;
    
}
