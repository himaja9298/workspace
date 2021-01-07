package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("chAspect")
@Aspect
@Order(20)
public class CachingAspect {
	//map representing cache
	Map<String,Object> cacheMap=new HashMap();
	Object retVal=null;
	
	@Around("execution(float com.nt.target.IntrestCalculator.*(..))")
	public Object caching(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Caching advice");
		
		String key=pjp.getSignature()+Arrays.toString(pjp.getArgs());
		if(!cacheMap.containsKey(key)) {
			System.out.println(" From target method");
			retVal=pjp.proceed();
			 cacheMap.put(key, retVal);
			 return retVal;
		}//if
		else {
			System.out.println("From cache");
			retVal=cacheMap.get(key);
			
		}//else
		return retVal;
		
	}//method
}//class
