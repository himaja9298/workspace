package com.nt.target;

public  class IntrestCalculator {
	public  float simpleIntrestAmnt(float amnt,float rate,float time) {
		return (amnt*rate*time)/100;
	}//method

	public  float compundIntrestAmnt(float amnt,float rate,float time) {
		return (float) (amnt*Math.pow(1+rate/100, time))-amnt;
	}//method

}//class
