package com.nt.comp;

import java.util.Arrays;
import java.util.Random;

public class Flipkart {
	//property
	private Courier courier,courier1,courier2;
    
	public Flipkart() {
   System.out.println("Flipkart:0-param constructor");
   }

	/*
	 * public Flipkart(Courier courier1,Courier courier2) {
	 * System.out.println("Flipkart:2-param constructor"); this.courier1 = courier1;
	 * this.courier2 = courier2; }
	 */
	
	  public void setCourier1(Courier courier1) {
	  System.out.println("Flipkart.setCourier1()"); this.courier1 = courier1; }
	  public void setCourier2(Courier courier2) {
	  System.out.println("Flipkart.setCourier2()"); this.courier2 = courier2; }
	 	 
	public String shopping(String[] items,float[] prices){
		float billAmt=0.0f;
		int oid=0;
		String msg1=null,msg2=null;
		//calculate billAmt
		for(float p:prices) {
			billAmt+=p;
		}
		//generate order id dynamically for the products
		oid=new Random().nextInt(10000000);
		//use courier services of delivering the products
		 msg1=courier1.deliver(oid); 
		 msg2=courier2.deliver(oid);
		//return billAmt and courier details to customer
		return Arrays.toString(items)+"are purchased having the prices"+Arrays.toString(prices)+"with billamt"+billAmt+"----"+msg1+" "+msg2;
		
		
	}
 
}
