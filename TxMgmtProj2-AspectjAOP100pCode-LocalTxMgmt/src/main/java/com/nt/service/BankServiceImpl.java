package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.DAO.BankDAO;

@Service("bankService")
public class BankServiceImpl implements BankService {
	@Autowired
	private BankDAO dao;

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
		count1 = dao.withdraw(srcactno, amnt);
		/*
		 * try { Thread.sleep(20000); } catch(Exception e) { e.printStackTrace(); }
		 */ 
		count2 = dao.deposite(destactno, amnt);
		if (count1 == 0 || count2 == 0)
			 throw new RuntimeException("Problem in money trasfering");
			//throw new IllegalArgumentException("problem in money tranfering");
		else
			return amnt + "of moneytransfered from" + srcactno + "to destination" + destactno;
	}

}
