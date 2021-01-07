package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.DAO.DepositeDAO;
import com.nt.DAO.WithdrawDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
	private WithdrawDAO wdao;
	@Autowired
	private DepositeDAO ddao;

	@Override
	  @Transactional(propagation=Propagation.REQUIRED)
	 //@Transactional(propagation=Propagation.REQUIRES_NEW)
	  //@Transactional(propagation=Propagation.SUPPORTS)
	 //@Transactional(propagation=Propagation.NOT_SUPPORTED)
	 //@Transactional(propagation=Propagation.MANDATORY)
	 //@Transactional(propagation=Propagation.NEVER)
	 //@Transactional(propagation = Propagation.REQUIRED, timeout = 10)
	 //@Transactional(propagation=Propagation.REQUIRED,timeout = 10,rollbackFor=IllegalAccessException.class)
	 //@Transactional(propagation=Propagation.REQUIRED,timeout =10,rollbackForClassName ="java.lang.IllegalAccessException")
	 //@Transactional(propagation=Propagation.REQUSupportIRED,timeout = 10,noRollbackFor=IllegalArgumentException.class)
	 // @Transactional(propagation=Propagation.REQUIRED,transactionManager="dsTxMgmr")
	public String trasferMoney(double srcactno, double destactno, float amnt) {
		int count1, count2 = 0;
		// use DAO
		count1 = wdao.withdraw(srcactno, amnt);
		 
		count2 = ddao.deposite(destactno, amnt);
		if (count1 == 0 || count2 == 0)
			throw new IllegalArgumentException("problem in money tranfering");
			 		
		else
			return amnt + "of moneytransfered from" + srcactno + "to destination" + destactno;
	}

}
