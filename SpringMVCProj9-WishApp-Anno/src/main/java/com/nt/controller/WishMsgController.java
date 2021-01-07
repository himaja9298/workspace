package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.IWishMsgService;
import com.nt.service.WishMsgServiceImpl;

@Controller("/welcome")
public class WishMsgController {

	@Autowired
	private IWishMsgService service;

	@RequestMapping("/welcome")
	public String showHome() {
		return "home";
	}

	@RequestMapping("/wish")
	public ModelAndView ShowWishMsg() {
		//use service
		String msg = null;
		msg = service.getWishMessage();
		return new ModelAndView("result", "wmsg", msg);
	}

}
