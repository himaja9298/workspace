package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.UsersBO;

public class AuthenticateDAOImpl implements IAuthenticateDAO {
    private static final String USER_QUERY="SELECT COUNT(*) FROM userslist WHERE uname=? AND pwd=?";
	
    private JdbcTemplate jt;
    //0-param constructor
    public AuthenticateDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int authenticate(UsersBO bo) {
		int count=0;
		count=jt.queryForObject(USER_QUERY, Integer.class, bo.getUname(),bo.getPwd());
		return count;
	}

}
