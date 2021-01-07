package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component("arAspect")
@Aspect
@Order(70)
public class AroundAspect {
	@Around("execution(float com.nt.target.IntrestCalculator.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Around aspect started"+pjp.getSignature()+"with arguments"+Arrays.toString(pjp.getArgs()));
		Object retVal=pjp.proceed();
		System.out.println("Around aspect ended"+pjp.getSignature()+"with arguments"+Arrays.toString(pjp.getArgs()));
	    return retVal;
	}

}
