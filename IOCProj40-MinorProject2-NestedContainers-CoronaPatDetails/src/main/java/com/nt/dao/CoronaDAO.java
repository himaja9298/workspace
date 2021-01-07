package com.nt.dao;

import java.util.List;

import com.nt.bo.CoronaBO;


public interface CoronaDAO {
	public List<CoronaBO> getCoronaPatDetails(String add1,String add2,String add3) throws Exception;

}
