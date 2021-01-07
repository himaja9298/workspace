package com.nt.beans;

import javax.inject.Named;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Named("dtdc")
//@Lazy
public final class DTDC implements Courier {
    public DTDC() {
		System.out.println("DTDC:0-param constructor");
	}
	@Override
	public String deliver(int oid) {
		System.out.println("DTDC.deliver()");
		return "DTDC courier will deliver order id::"+oid+"order products";
		
		
	}

}
