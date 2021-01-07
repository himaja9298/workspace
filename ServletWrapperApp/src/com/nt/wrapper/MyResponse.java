package com.nt.wrapper;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper {
    private HttpServletResponse response;
    private CharArrayWriter writer=null;
	public MyResponse(HttpServletResponse response) {
		super(response);
		this.response=response;
		writer=new CharArrayWriter();
	}//constructor
	@Override
	public PrintWriter getWriter() throws IOException {
		System.out.println("MyResponse.getWriter()");
		PrintWriter pw= new PrintWriter(writer);
		return pw;
	}
	@Override
	public String toString() {
		return writer.toString();
	}

}
