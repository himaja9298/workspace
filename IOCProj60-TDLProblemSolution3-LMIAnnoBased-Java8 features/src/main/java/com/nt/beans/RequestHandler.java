package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("rhandle")
public class RequestHandler {
 public static int count;
 public RequestHandler() {
	 count++;
      System.out.println("RequestHandler:0-param constructor");
 }
 public void handleRequest(String data) {
	 System.out.println("Handling request with: "+data+" using the object::"+count);
	 
 }
}
