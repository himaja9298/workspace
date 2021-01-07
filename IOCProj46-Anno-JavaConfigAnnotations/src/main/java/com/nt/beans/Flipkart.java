package com.nt.beans;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.nt.beans.Courier;
@Named("fpkt")
//@Scope("prototype")
public class Flipkart {
	//property
	//@Inject
	//@Named("fflight")
	@Resource(name="dhl")
	private Courier courier;
	//0-param constructor
	/*public Flipkart() {
       System.out.println("Flipkart:0-param constructor");
     }*/	 
	
   /*@Inject
   public Flipkart(@Named("dtdc")Courier courier) {
		System.out.println("Flipkart:1-param constructor");
		this.courier = courier;
	}*/
	/*@Inject
	public Flipkart(Date sysdate) {
		System.out.println("Flipkart:date param constructor)");
		this.sysdate = sysdate;
	}
	@Inject
	public Flipkart(@Named("dtdc")Courier courier, Date sysdate) {
		System.out.println("Flipkart:2-param constructor");
		this.courier = courier;
		this.sysdate = sysdate;
	}*/
	//setter method
	/*//@Inject
	//@Named("dhl")
	@Resource(name="dhl")
	public void setCourier(Courier courier) {
		this.courier = courier;
		System.out.println("Flipkart.setCourier()");
	}*/
	/*@Autowired
	public void setDate(Date sysdate) {
		this.sysdate=sysdate;
		System.out.println("Flipkart.setDate()");
	}*/
	
	//@Inject
	//@Named("bdart")
	/*@Resource(name="dtdc")
	public void Assign(Courier courier) {
		this.courier=courier;
		System.out.println("Flipkart.AssignCourier()");
	}*/
	/*@Inject
	public void Assign(Date sysdate) {
		this.sysdate=sysdate;
		System.out.println("Flipkart.AssignDate()");
	}*/
	
	
	
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
		 
		//return billAmt and courier details to customer
		return Arrays.toString(items)+"are purchased having the prices"+Arrays.toString(prices)+"with billamt"+billAmt+"----"+msg;
		
		
	}
 
}
