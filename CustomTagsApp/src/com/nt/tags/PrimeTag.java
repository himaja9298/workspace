package com.nt.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrimeTag extends TagSupport {
	 private int n=10;  
	
public void setN(int n) {
	System.out.println("PrimeTag.setN()");
		this.n = n;
	}//setN
public boolean isPirme(int x) {
	for(int i=2;i<x;i++) {
		if(x%i==0) 
			return false;
	 }//for
	 return true;
}//isPrime
@Override
 public int doStartTag() throws JspException {
	 JspWriter out=null;
	 //get out object
	 out=pageContext.getOut();
	 try {
		 for(int i=2;i<=n;i++) {
			 if(isPirme(i)) {
				 out.println(i+",");
			 }//if
		 }//for
	  }//try
	 catch(IOException ioe) {
		 ioe.printStackTrace();
	 }//catch
	 return SKIP_BODY;
}//doStart()
  @Override
  public int doEndTag() throws JspException {
		System.out.println("PrimeTag.doEndTag()");
		return EVAL_PAGE;
  }//doEnd()
}//class
