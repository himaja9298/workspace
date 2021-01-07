package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component("adAspectSimple")
@Aspect

public class AroundAspectSimple {
	//method declaring pointcut
	@Pointcut("execution(float com.nt.target.IntrestCalculator.*(..))")
	public void myptc() {
		//dummy method()
	}

	
	    //map representing cache
		Map<String,Object> cacheMap=new HashMap();
		Object retVal=null;
		
		@Around("myptc()")
		@Order(20)
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
		
		@Around("myptc()")
		@Order(100)
		public Object around(ProceedingJoinPoint pjp) throws Throwable {
			System.out.println("Around aspect started"+pjp.getSignature()+"with arguments"+Arrays.toString(pjp.getArgs()));
			Object retVal=pjp.proceed();
			System.out.println("Around aspect ended"+pjp.getSignature()+"with arguments"+Arrays.toString(pjp.getArgs()));
		    return retVal;
		}
		
		@Around("myptc()")
		@Order(200)
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
			
			//modifying the return values
			returnVal=(Float)returnVal+(Float)returnVal*(0.5f);
			return returnVal;
		}



}
