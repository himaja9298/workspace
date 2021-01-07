package com.nt.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PatternTag extends TagSupport{
	private int n;
	public void setN(int n) {
		this.n = n;
	}

	@Override
	public int doStartTag() throws JspException {
	System.out.println("PatternTag.doStartTag()");
	JspWriter out=null;
	//get out object
	out=pageContext.getOut();
	try {
		 for(int i=1;i<=n;i++) {
			for(int j=n;j>=i;j--) {
				out.print("*");
             }//j close
			out.println("");
		}//i close
	}//try
	catch(Exception e) {
		e.printStackTrace();
		}//catch
	return EVAL_BODY_INCLUDE;
	}//doStart()
	
	@Override
	public int doEndTag() throws JspException {
	System.out.println("PatternTag.doEndTag()");
	return EVAL_PAGE;
	}//doEnd

}
