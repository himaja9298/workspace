package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class TilesController {
	
	@GetMapping("/home")
	public String showHome() {
		return "homeDef";//tile definition as logical view name
	}
	
	@GetMapping("/faculty")
	public String showFacultyPage() {
		return "facultyDef";//tile definition as logical view name
	}
	
	@GetMapping("/address")
	public String showAddressPage() {
		return "addressDef";//tile definition as logical view name
	}
	
	@GetMapping("/course")
	public String showCoursePage() {
		return "courseDef";//tile definition as logical view name
	}

}
