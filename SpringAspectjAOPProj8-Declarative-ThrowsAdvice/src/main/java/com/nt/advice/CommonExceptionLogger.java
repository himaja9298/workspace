package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class CommonExceptionLogger {
	public void exceptionLogger(JoinPoint jp,Exception ex) throws Throwable {
      System.out.println(ex+"Exception raised in "+jp.getSignature()+" with arguments "+Arrays.deepToString(jp.getArgs()));
	  
	}

}
