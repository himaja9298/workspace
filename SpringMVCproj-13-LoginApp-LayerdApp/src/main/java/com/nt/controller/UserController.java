package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.dto.UserDTO;
import com.nt.model.User;
import com.nt.service.ILoginMgmtService;

@Controller
public class UserController {
	@Autowired
	private ILoginMgmtService service;

	@GetMapping("/login")
	public String showLoginForm(@ModelAttribute User userdetails) {
		return "login_form";
	}

	@PostMapping("/login")
	public String processForm(@ModelAttribute User user,Map<String,Object> map){
		UserDTO dto=new UserDTO();
		dto.setUname(user.getUname());
		dto.setPwd(user.getPwd());
		String msg=service.login(dto);
		//System.out.println(msg);
		map.put("ResultMsg",msg);
		return "login_form";
	}

}
