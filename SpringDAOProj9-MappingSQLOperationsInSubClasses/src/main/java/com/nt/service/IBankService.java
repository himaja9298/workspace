package com.nt.service;

import java.util.List;

import com.nt.bo.BankAccountBO;
import com.nt.dto.BankAccountDTO;

public interface IBankService {

	 public List<BankAccountDTO> fetchBankAccountsByBalanceRange(float start ,float end);
	 public BankAccountDTO fetchDetailsByAccountno(double actno);
	 public String modifyBalmntWithBonus(float bonus,float maxBalance);

}
