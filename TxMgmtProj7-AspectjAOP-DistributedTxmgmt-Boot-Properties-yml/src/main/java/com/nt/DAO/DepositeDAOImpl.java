package com.nt.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("ddao")
public class DepositeDAOImpl implements DepositeDAO {
	
	public static String DEPOSIT_QUERY="update bankdetails set balamnt=balamnt+? where actno=?"; 

	@Autowired
	@Qualifier("mysql2jt")
	private JdbcTemplate jt;
    int count;
	@Override
	public int deposite(double destactno, float amnt) {
		int count=0;
		count=jt.update(DEPOSIT_QUERY,amnt,destactno);
		return count;
	} 
	
		
}
