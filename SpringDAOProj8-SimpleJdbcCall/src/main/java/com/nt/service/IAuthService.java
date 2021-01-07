package com.nt.service;

import com.nt.dto.BankAccountDTO;

public interface IAuthService {

	 public String authenticateUser(String user,String pwd);
}
