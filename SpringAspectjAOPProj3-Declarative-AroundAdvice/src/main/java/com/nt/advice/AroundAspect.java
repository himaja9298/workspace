package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAspect {
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Around aspect started"+pjp.getSignature()+"with arguments"+Arrays.toString(pjp.getArgs()));
		Object retVal=pjp.proceed();
		System.out.println("Around aspect ended"+pjp.getSignature()+"with arguments"+Arrays.toString(pjp.getArgs()));
	    return retVal;
	}

}
