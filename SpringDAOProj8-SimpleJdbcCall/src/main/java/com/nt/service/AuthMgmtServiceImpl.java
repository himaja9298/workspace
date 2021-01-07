package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IAuthDAO;

@Service("authService")
public class AuthMgmtServiceImpl implements IAuthService {
	@Autowired
	private IAuthDAO dao;

	@Override
	public String authenticateUser(String user, String pwd) {
     String result=null;
     //ude dao
     result=dao.loginUser(user, pwd);
	 return result;
	}

	

}
