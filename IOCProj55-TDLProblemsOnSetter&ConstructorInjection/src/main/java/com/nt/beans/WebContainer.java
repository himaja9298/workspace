package com.nt.beans;

public class WebContainer {
	private RequestHandler rh; 
	//setter method
	public void setRh(RequestHandler rh) {
		this.rh = rh;
	}
	public WebContainer() {
		System.out.println("WebContainer:0-param constructor");
	}
   public void processing(String data) {
	   System.out.println("WebContainer.processing()");
	   rh.handleRequest(data);
   }
}
