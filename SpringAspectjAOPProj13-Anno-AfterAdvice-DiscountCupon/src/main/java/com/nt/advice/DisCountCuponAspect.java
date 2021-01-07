package com.nt.advice;

import java.io.FileWriter;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("discountAspect")
@Aspect

public class DisCountCuponAspect {
	String cuponMsg=null;
	//discount cupon message
	@AfterReturning(pointcut = "execution(float com.nt.target.ShoppingStore.shopping(..))",returning="billAmnt")
	public void cupon(float billAmnt) throws Throwable {
		if(billAmnt<1000)
			cuponMsg="5% discount for next sale";
		else if(billAmnt<5000)
			cuponMsg="10% discount for next sale";
		else if(billAmnt<10000)
			cuponMsg="15% discount for next sale";
		else
			cuponMsg="15% discount for next sale";
		//generate cupon
		FileWriter writer= new FileWriter("E:/cupon.txt");
		writer.write(cuponMsg);
		writer.flush();
		writer.close();
	}

}
