package com.nt.target;

import org.springframework.stereotype.Component;

@Component("shopStore")
public class ShoppingStore {
	public float generateBill(String items[],float prices[]) {
		boolean problem=true;
		if(prices==null||items==null)
			problem=true;
		for(float price:prices) {
			if(price<0.0f) {
				break;
			}
			problem=true;
		}
		if(problem)
			throw new IllegalArgumentException("Internal problem");
		else {
			float billAmnt=0.0f;
			for(float price:prices) {
				billAmnt+=price;
			}
			return billAmnt; 
		}//method
		
	}//class

}
