package com.nt.interceptor;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeCheckingInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		Calendar cal=null;
		int hour=0;
		RequestDispatcher rd=null;
		hour=cal.getInstance().get(Calendar.HOUR_OF_DAY);
		if(hour<9||hour>17) {
			rd=req.getRequestDispatcher("timeout.jsp");
			rd.forward(req,res);
			return false;
		}
		else
			return true;
	}

}
