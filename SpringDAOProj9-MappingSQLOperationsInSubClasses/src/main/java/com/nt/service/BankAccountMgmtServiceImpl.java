package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.BankAccountBO;
import com.nt.dao.IBankDAO;
import com.nt.dto.BankAccountDTO;

@Service("BankService")
public class BankAccountMgmtServiceImpl implements IBankService {
	@Autowired
	private IBankDAO dao;

	@Override
	public List<BankAccountDTO> fetchBankAccountsByBalanceRange(float start, float end) {
		List<BankAccountDTO>listdto=new ArrayList();
		List<BankAccountBO>listbo=null;
		//use dao
		listbo=dao.getBankAccountsByBalanceRange(start, end);
		//copy properties from bo to dto
		listbo.forEach(bo->{
		BankAccountDTO dto=new BankAccountDTO();
		BeanUtils.copyProperties(bo, dto);
		listdto.add(dto);
		});
		return listdto;
	}

	@Override
	public String modifyBalmntWithBonus(float bonus, float maxBalance) {
		int count=0;
		//use dao
      count= dao.UpdateBalmntWithBonus(bonus, maxBalance);
	  return count!=0?"Balance incremented":"Balance not incremented";
	}

	@Override
	public BankAccountDTO fetchDetailsByAccountno(double actno) {
		BankAccountBO bo=null;
		//use dao
		bo=dao.getDetailsByAccountno(actno);
		//copy properties from bo to dto
		BankAccountDTO dto=new BankAccountDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}

	
	

}
