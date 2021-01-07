package com.nt.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bankdao")
public class BankDAOImpl implements BankDAO {
	public static String WITHDRAW_QUERY="update bankdetails set balamnt=balamnt-? where actno=?"; 
	public static String DEPOSIT_QUERY="update bankdetails set balamnt=balamnt+? where actno=?"; 

	@Autowired
	private JdbcTemplate jt;
    int count; 
	@Override
	public int withdraw(double actno, float amnt) {
		count=jt.update(WITHDRAW_QUERY,amnt,actno);
		return count;
	}

	@Override
	public int deposite(double actno, float amnt) {
		count=jt.update(DEPOSIT_QUERY,amnt,actno);
		return count;
	}

}
