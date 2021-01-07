package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class BankDAOImpl implements IBankDAO {
  
	private static final String WITHDRAW_QUERY="update bankdetails set balamnt=balamnt-? WHERE actno=?";
	private static final String DEPOSITE_QUERY="update bankdetails set balamnt=balamnt+? WHERE actno=?";
	private JdbcTemplate jt;

	public BankDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	//business methods
	@Override
	public int withdraw(double actno, float amnt) {
		int count=0;
		count=jt.update(WITHDRAW_QUERY,amnt,actno);
		return count;
	}

	@Override
	public int deposit(double actno, float amnt) {
		int count=0;
		count=jt.update(DEPOSITE_QUERY,amnt,actno);
		return count;
	}

}
