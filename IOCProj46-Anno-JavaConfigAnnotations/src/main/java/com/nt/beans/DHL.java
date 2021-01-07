package com.nt.beans;

import javax.inject.Named;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Named("dhl")
//@Lazy
public final class DHL implements Courier {
    public DHL() {
		System.out.println("DHL:0-param constructor");
	}
	@Override
	public String deliver(int oid) {
		System.out.println("DHL.deliver()");
		return "DHL courier will deliver order id::"+oid+"order products";
		
		
	}

}
