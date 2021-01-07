package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
 @RequestMapping
	public String showMessage(Model model) {
	 return "error";
 }
}
