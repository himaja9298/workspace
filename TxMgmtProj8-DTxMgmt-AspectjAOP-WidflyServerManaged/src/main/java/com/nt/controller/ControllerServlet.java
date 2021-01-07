package com.nt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@WebServlet(urlPatterns = { "/Controller" })
public class ControllerServlet extends HttpServlet {
	ApplicationContext ctx = null;

	public void init() {
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	}

	public void destroy() {
		((AbstractApplicationContext) ctx).close();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   long srcactno=0,destactno=0;
	   float amnt=0;
	   
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
