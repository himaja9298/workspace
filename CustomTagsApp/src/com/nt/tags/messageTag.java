package com.nt.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class messageTag extends TagSupport {
@Override
public int doStartTag() throws JspException {
	System.out.println("messageTag.doStartTag()");
	JspWriter out=null;
	//get out object
	out=pageContext.getOut();
    try {
    	out.println("print some message");
    }//try
    catch(IOException ioe) {
    	ioe.printStackTrace();
    }//catch
    return SKIP_BODY;
}//doStart()
@Override
	public int doEndTag() throws JspException {
		System.out.println("messageTag.doEndTag()");
		return EVAL_PAGE;		
	}//doEnd()

}
