package com.cr.serviceLocator;

import com.ipl.external.IIPLScoreComp;
import com.ipl.external.IPLScoreCompImpl;

public interface IPLScoreCompServiceLocator{
    final static IIPLScoreComp extcomp=new IPLScoreCompImpl();
		public static IIPLScoreComp getExternalComp(){
		  return extcomp;
	}
}
