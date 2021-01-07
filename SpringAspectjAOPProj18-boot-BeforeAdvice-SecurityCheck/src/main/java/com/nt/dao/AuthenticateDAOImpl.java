package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.UsersBO;
@Repository("authDao")
public class AuthenticateDAOImpl implements IAuthenticateDAO {
    private static final String USER_QUERY="SELECT COUNT(*) FROM userslist WHERE uname=? AND pwd=?";
	
    @Autowired
    private JdbcTemplate jt;
    

	@Override
	public int authenticate(UsersBO bo) {
		int count=0;
		count=jt.queryForObject(USER_QUERY, Integer.class, bo.getUname(),bo.getPwd());
		return count;
	}

}
