package com.nt.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.manager.AuthenticationManager;
@Component("secAspect")
public class SecurityAspect {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Before("execution(String com.nt.service.IBankService.*(..)))")
	public void check(JoinPoint jp) throws Throwable {
		System.out.println("SecurityAspect.check()");
		if(!manager.validate()) {
			throw new IllegalAccessException("Bad credentials");
		}
			
		
	}
	

}
