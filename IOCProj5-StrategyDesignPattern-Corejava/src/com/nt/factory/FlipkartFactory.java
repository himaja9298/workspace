package com.nt.factory;

import com.nt.comp.BlueDart;
import com.nt.comp.DTDC;
import com.nt.comp.FirstFlight;
import com.nt.comp.Flipkart;
import com.nt.comp.courier;

public class FlipkartFactory {
	public static Flipkart getInstance(String courierName) {
		courier courier=null;
		Flipkart fpkt=null;
		//create dependent class object
		if(courierName.equalsIgnoreCase("dtdc")) 
			courier=new DTDC();
		else if(courierName.equalsIgnoreCase("bluedart")) 
			courier=new BlueDart();
		else if(courierName.equalsIgnoreCase("firstflight")) 
			courier=new FirstFlight();
		else
			throw new IllegalArgumentException("Invalid courier name");
		fpkt=new Flipkart();
		//assign dependent class object to target class object
		fpkt.setCourier(courier);
		return fpkt;
	  }

}
