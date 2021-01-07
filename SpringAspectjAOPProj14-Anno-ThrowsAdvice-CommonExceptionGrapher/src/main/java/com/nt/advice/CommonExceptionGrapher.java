package com.nt.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.nt.exception.InvalidInputException;

@Component("cegrapher")
@Aspect
public class CommonExceptionGrapher {

	@AfterThrowing(pointcut="execution(float com.nt.target.ShoppingStore.generateBill(..))",throwing="ex" )
	public void exceptionGrapher(JoinPoint jp,Exception ex) throws Throwable {
       throw new InvalidInputException(ex.getMessage());
	}
}
