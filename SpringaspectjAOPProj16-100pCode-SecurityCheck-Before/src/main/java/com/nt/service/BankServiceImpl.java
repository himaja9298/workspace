package com.nt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IBankDAO;
@Service("bankService")
public class BankServiceImpl implements IBankService {
    
	@Autowired
	private IBankDAO dao;

	@Override
	public String withdraw(double actno, float amnt) {
		int count;
		//use dao
		count=dao.withdraw(actno, amnt);
		return count==0?"Money is not withdrawn from account":"Money is withdrawn from account";
	}

	@Override
	public String deposit(double actno, float amnt) {
		int count;
		//use dao
		count=dao.deposit(actno, amnt);
		return count==0?"Money is not deposited to account":"Money is deposited to account";
	}

}
