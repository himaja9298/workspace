package com.cr.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cr.service.ICricBuzzScoreMgmtService;

public class MainControllerServlet extends HttpServlet{
	ApplicationContext ctx=null;
	
   @Override
public void init() throws ServletException {
	ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
}
   
   @Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   ICricBuzzScoreMgmtService service=null;
	   String score=null;
	   int mid=0;
	   RequestDispatcher rd=null;
	   //get service class object
		service=ctx.getBean("service",ICricBuzzScoreMgmtService.class);
		//get mid through req param
		mid=Integer.parseInt(req.getParameter("mid"));
		score=service.fetchScore(mid);
		req.setAttribute("Score", score);
		rd=req.getRequestDispatcher("/result.jsp");
		rd.forward(req,res);
}//doGet(-,-)
   
  @Override
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	doGet(req,res);
}
  @Override
public void destroy() {
	//close container
	  ((AbstractApplicationContext) ctx).close();
}
	
}
