package com.nt.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class AopConfig {
	// configure UserTransactionImp
	@Bean(name = "dTxService")
	public UserTransactionImp createDTxService() throws Exception {
		UserTransactionImp txservice = null;
		txservice = new UserTransactionImp();
		txservice.setTransactionTimeout(90);
		return txservice;

	}

	// configure UserTransactionManager
	@Bean(name = "dTxManager")
	public UserTransactionManager createDTxManager() throws Exception {
		UserTransactionManager txmanager = null;
		txmanager = new UserTransactionManager();
		txmanager.setTransactionTimeout(90);
		return txmanager;

	}
	//create JtatransactionManager
	@Bean(name="jtaTxMgmr")
	public JtaTransactionManager createTxMgmr() throws Exception{
		JtaTransactionManager manager=null;
		manager=new JtaTransactionManager();
		manager.setUserTransaction(createDTxService());
		manager.setTransactionManager(createDTxManager());
		return manager;
		
	}

}
