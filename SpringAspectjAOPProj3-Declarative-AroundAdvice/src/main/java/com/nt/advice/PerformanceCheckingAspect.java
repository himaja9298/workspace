package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceCheckingAspect {
	public Object monitor(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("PerformanceCheckingAdvice.invoke().prelogic()");
		System.out.println(pjp.getClass());
		float startTime = System.currentTimeMillis();

		// modifying arguments of target class methods
		Object[] args = pjp.getArgs();
		if ((Float) args[0] < 50000)
			args[1] = ((Float) args[1] - 0.5f);
		System.out.println(Arrays.toString(args));
		
		//controlling target class method execeution
		if ((Float) args[0]<=0||(Float) args[1]<=0||(Float) args[2]<=0)
			throw new IllegalArgumentException("values must be grater than zero");
	    
		Object returnVal = pjp.proceed();
		float endTime = System.currentTimeMillis();
		System.out.println("PerformanceCheckingAspect has taken"+(endTime-startTime)+"milliseconds");
		System.out.println("PerformanceCheckingAdvice.invoke().postlogic()");
		
		//modifing the return values
		returnVal=(Float)returnVal+(Float)returnVal*(0.5f);
		return returnVal;
	}

}
