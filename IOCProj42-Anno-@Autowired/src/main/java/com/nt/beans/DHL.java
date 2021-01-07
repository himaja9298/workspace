package com.nt.beans;

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
