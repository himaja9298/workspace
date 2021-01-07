package com.nt.comp;

import java.util.Arrays;
import java.util.Random;

public class Flipkart {
	//property
	public Courier courier;
	/*
	 * private int number; //number setter method public void setNumber(int number)
	 * { this.number = number; }
	 */

	//0-param constructor
	public Flipkart() {
      System.out.println("Flipkart:0-param constructor");
    }
	//1-param constructor
	
	  public Flipkart(Courier courier) {
		 System.out.println("Flipkart:1-param constructor");
		  this.courier = courier;
		 }
	 
	public void setCourier(Courier courier) {
	   System.out.println("Flipkart.setCourier()"); 
	   this.courier = courier;
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
			/* System.out.println(number); */
		 
		//return billAmt and courier details to customer
		return Arrays.toString(items)+"are purchased having the prices"+Arrays.toString(prices)+"with billamt"+billAmt+"----"+msg;	
		
	}
 
}
