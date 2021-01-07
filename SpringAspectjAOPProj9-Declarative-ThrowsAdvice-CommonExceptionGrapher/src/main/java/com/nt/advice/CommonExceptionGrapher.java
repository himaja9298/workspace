package com.nt.advice;

import org.aspectj.lang.JoinPoint;

import com.nt.exception.InvalidInputException;

public class CommonExceptionGrapher {

	public void exceptionGrapher(JoinPoint jp,Exception ex) throws Throwable {
       throw new InvalidInputException(ex.getMessage());
	}
}
