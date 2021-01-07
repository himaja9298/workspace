package com.cr.serviceLocator;

import org.springframework.beans.factory.FactoryBean;

import com.ipl.external.IIPLScoreComp;
import com.ipl.external.IPLScoreCompImpl;

public class IPLScoreCompServiceLocatorFactoryBean implements FactoryBean<IIPLScoreComp> {
    private IIPLScoreComp extcomp;
	@Override
	public IIPLScoreComp getObject() throws Exception {
		extcomp=new IPLScoreCompImpl();
		return extcomp;
	}

	@Override
	public Class<?> getObjectType() {
		return IIPLScoreComp.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
