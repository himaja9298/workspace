package com.nt.beans;

import java.util.Properties;

public class FruitsInfo {
	private Properties fruits;
    //1-param constructor
	public FruitsInfo(Properties fruits) {
		System.out.println(fruits.getClass());
		this.fruits = fruits;
	}
	//toString() method
	@Override
	public String toString() {
		return "FruitsInfo [fruits=" + fruits + "]";
	}
	
	

}
