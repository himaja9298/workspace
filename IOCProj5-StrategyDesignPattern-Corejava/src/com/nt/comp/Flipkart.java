package com.nt.comp;

import java.util.Arrays;
import java.util.Random;

public class Flipkart {
	//property
	private courier courier;
    
	public Flipkart() {
   System.out.println("Flipkart:0-param constructor");
   }
	public void setCourier(courier courier) {
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
		//return billAmt and courier details to customer
		return Arrays.toString(items)+"are purchased having the prices"+Arrays.toString(prices)+"with billamt"+billAmt+"----"+msg;
		
		
	}
 
}
