package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.EmployeeDTO;
import com.nt.dto.StudentDTO;
import com.nt.service.ICollegeMgmtService;
@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	ApplicationContext ctx=null;
	ICollegeMgmtService service=null;
	
    @Override
    public void init() throws ServletException {
    	ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String type=null;
    	String result=null;
    	String targetPage=null;
    	StudentDTO stdto=null;
    	EmployeeDTO empdto=null;
    	RequestDispatcher rd=null;
    	//get service class object
    	service=ctx.getBean("clgService",ICollegeMgmtService.class);
    	//Evaluate type of form submitting request to diffentiate the logics
    	type=req.getParameter("type");
    	if(type.equalsIgnoreCase("RegisterStudent")) {
    		stdto=ctx.getBean("stDTO",StudentDTO.class);
    		stdto.setId(Integer.parseInt(req.getParameter("sid")));
    		stdto.setName(req.getParameter("sname"));
    		stdto.setSadd(req.getParameter("sadd"));
    		stdto.setCourse(req.getParameter("scrcs"));
    		stdto.setM1(Integer.parseInt(req.getParameter("m1")));
    		stdto.setM2(Integer.parseInt(req.getParameter("m2")));
            stdto.setM3(Integer.parseInt(req.getParameter("m3")));
    		try {
            result=service.enrollStudent(stdto);
    		req.setAttribute("resultMsg", result);
    		targetPage="/result.jsp";
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}//catch
    	}//if
    	
    	else {
    		
    		empdto=ctx.getBean("empDTO",EmployeeDTO.class);
    		empdto.setId(Integer.parseInt(req.getParameter("eid")));
    		empdto.setName(req.getParameter("ename"));
    		empdto.setCompany(req.getParameter("ecmp"));
    		empdto.setSalary(Float.parseFloat(req.getParameter("esal")));
    		try {
            result=service.enrollEmployee(empdto);
    		req.setAttribute("resultMsg", result);
    		targetPage="/result.jsp";
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}//catch
    		
    	}//else
    	//forwardding request
    	rd=req.getRequestDispatcher(targetPage);
    	rd.forward(req, res);
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	doGet(req, res);
    }
    
    @Override
    public void destroy() {
    ((AbstractApplicationContext) ctx).close();
    }
}
