package com.nt.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("wdao")
public class WithdrawDAOImpl implements WithdrawDAO {
	
	public static String WITHDRAW_QUERY="update bankdetails set balamnt=balamnt-? where actno=?"; 

	@Autowired
	@Qualifier("mysql1jt")
	private JdbcTemplate jt;
    int count;
	@Override
	public int withdraw(double srcactno, float amnt) {
		int count=0;
		count=jt.update(WITHDRAW_QUERY,amnt,srcactno);
		return count;
	} 
	
		
}
