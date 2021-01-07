package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.WishMsgService;
import com.nt.service.WishMsgServiceImpl;

public class WishController extends AbstractController{
	private WishMsgService service;
	
    //1-param constructor
	public WishController(WishMsgService service) {
		System.out.println("WishController.WishController()");
		this.service = service;
	}


	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String msg=null;
		msg=service.getWishMessage();
			return new ModelAndView("result","wmsg",msg);
	}
	
}
