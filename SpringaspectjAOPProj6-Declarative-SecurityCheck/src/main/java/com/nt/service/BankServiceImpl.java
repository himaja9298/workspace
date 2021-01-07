package com.nt.service;

import org.springframework.dao.support.DaoSupport;

import com.nt.dao.IBankDAO;

public class BankServiceImpl implements IBankService {

	private IBankDAO dao;

	//0-param constrcutor
	public BankServiceImpl(IBankDAO dao) {
		this.dao = dao;
	}

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
