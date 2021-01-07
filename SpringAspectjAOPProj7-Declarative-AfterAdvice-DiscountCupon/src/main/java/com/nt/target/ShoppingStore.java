package com.nt.target;

public class ShoppingStore {
	public float shopping(String items[],float prices[]) {
		float billAmnt=0.0f;
		for(float price:prices) 
			billAmnt+=price;
		    return billAmnt;
	}

}
