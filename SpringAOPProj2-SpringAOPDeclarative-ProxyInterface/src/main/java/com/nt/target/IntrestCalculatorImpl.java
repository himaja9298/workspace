package com.nt.target;

public final class IntrestCalculatorImpl implements IIntrestCalculator {
	public  float simpleIntrestAmnt(float amnt,float rate,float time) {
		return (amnt*rate*time)/100;
	}//method

}//class
