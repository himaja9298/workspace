package com.nt.advice;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceCheckingAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("PerformanceCheckingAdvice.invoke().prelogic()");
		System.out.println(invocation.getClass());
		float startTime = System.currentTimeMillis();

		// modifying arguments of target class methods
		Object[] args = invocation.getArguments();
		if ((Float) args[0] < 50000)
			args[1] = ((Float) args[1] - 0.5f);
		System.out.println(Arrays.toString(args));
		
		//controlling target class method execeution
		if ((Float) args[0]<=0||(Float) args[1]<=0||(Float) args[2]<=0)
			throw new IllegalArgumentException("values must be grater than zero");
	    
		Object returnVal = invocation.proceed();
		float endTime = System.currentTimeMillis();
		System.out.println("PerformanceCheckingAdvice.invoke().postlogic()");
		
		//modifing the return values
		returnVal=(Float)returnVal+(Float)returnVal*(0.5f);
		return returnVal;
	}

}
