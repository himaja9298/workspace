package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Person;

@Controller
public class PersonController {

	@GetMapping("/person")
	public String showForm(@ModelAttribute("perFrm") Person person) {
		return "show_form";
	}

}
