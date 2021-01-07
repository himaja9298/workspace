package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.BankAccountBO;
import com.nt.dao.IBankDAO;
import com.nt.dto.BankAccountDTO;

@Service("bankService")
public class BankAccountMgmtServiceImpl implements IBankService {
	@Autowired
	private IBankDAO dao;

	@Override
	public String registerCustomer(BankAccountDTO dto) {
		int count = 0;
		BankAccountBO bo = new BankAccountBO();
		BeanUtils.copyProperties(dto, bo);
		// use dao
		count = dao.insertCustomer(bo);
		return (count != 0) ? "Bank account created" : "Bank accountis not created";
	}

}
