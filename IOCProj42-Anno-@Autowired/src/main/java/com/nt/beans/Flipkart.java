package com.nt.beans;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Flipkart {
	//property
	@Autowired
	//@Qualifier("dt")
	@Qualifier("dtdc")
	private Courier courier;
	private Date sysdate;
    /*@Autowired(required =false)
	public Flipkart(Date sysdate) {
		this.sysdate = sysdate;
	}*/
	public Flipkart() {
       System.out.println("Flipkart:0-param constructor");
     }	 
	/*@Autowired(required =false)
	public Flipkart(@Qualifier("bdart")Courier courier) {
		System.out.println("Flipkart:1-param constructor");
		this.courier = courier;
	}*/
	/*@Autowired(required =false)
	public Flipkart(Date sysdate) {
		System.out.println("Flipkart:date param constructor)");
		this.sysdate = sysdate;
	}
	@Autowired(required =false)
	public Flipkart(@Qualifier("dtdc")Courier courier, Date sysdate) {
		System.out.println("Flipkart:2-param constructor");
		this.courier = courier;
		this.sysdate = sysdate;
	}*/
	//setter method
	/*@Autowired
	@Qualifier("fflight")
	public void setCourier(Courier courier) {
		this.courier = courier;
		System.out.println("Flipkart.setCourier()");
	}*/
	/*@Autowired
	public void setDate(Date sysdate) {
		this.sysdate=sysdate;
		System.out.println("Flipkart.setDate()");
	}*/
	
	/*@Autowired
	@Qualifier("dhl")
	public void Assign(Courier courier) {
		this.courier=courier;
		System.out.println("Flipkart.AssignCourier()");
	}*/
	/*@Autowired
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
		 //System.out.println(sysdate);
		//return billAmt and courier details to customer
		return Arrays.toString(items)+"are purchased having the prices"+Arrays.toString(prices)+"with billamt"+billAmt+"----"+msg;
		
		
	}
 
}
