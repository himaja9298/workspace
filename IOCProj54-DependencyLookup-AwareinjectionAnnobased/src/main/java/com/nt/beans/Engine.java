package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("engg")
public class Engine {
	public Engine() {
	System.out.println("Engine:0-param constructor");
	}
   ///start method
	public void start() {
		System.out.println("Engine:start() method");
	}
	//stop method
	public void stop(){
		System.out.println("Engine:stop() method");
		
	}
}
