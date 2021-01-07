package com.nt.beans;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nt.beans.Courier;
@Component("fpkt")
//@Scope("prototype")
public class Flipkart {
	//property
	@Autowired
	@Qualifier("dhl")
	private Courier courier;
	//0-param constructor
	public Flipkart() {
       System.out.println("Flipkart:0-param constructor");
     }	 
	
	public String shopping(String[] items,float[] prices){
		float billAmt=0.0f;
		int oid=0;
		String msg=null;
		//calculate billAmt
		for(float p:prices) {
			billAmt+=p;
		}
		//generate order id dynamically for the products
		oid=new Random().nextInt(10000000);
		//use courier services of delivering the products
		 msg=courier.deliver(oid); 
		 //System.out.println(date);
		//return billAmt and courier details to customer
		return Arrays.toString(items)+"are purchased having the prices"+Arrays.toString(prices)+"with billamt"+billAmt+"----"+msg;
		
		
	}
 
}
