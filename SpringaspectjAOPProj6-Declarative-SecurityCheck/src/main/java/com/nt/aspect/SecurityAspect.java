package com.nt.aspect;

import org.aspectj.lang.JoinPoint;

import com.nt.manager.AuthenticationManager;

public class SecurityAspect {
	private AuthenticationManager manager;
	//0-param constructor
	public SecurityAspect(AuthenticationManager manager) {
		this.manager = manager;
	}
	
	public void check(JoinPoint jp) throws Throwable {
		System.out.println("SecurityAspect.check()");
		if(!manager.validate()) {
			throw new IllegalAccessException("Bad credentials");
		}
			
		
	}
	

}
