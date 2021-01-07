package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Student;

@Controller
public class DataBinding {

	/*@GetMapping("/register")
	public String showForm(@ModelAttribute("stFrm") Student st) {
		st.setSadd("hyd");
		return "student_form";
	}*/
	
	/*@GetMapping("/register")
	public String showForm(Map<String,Object> map) {
		Student st=new Student();
		st.setSadd("hyd");
		map.put("stFrm", st);
		return "student_form";
	}*/
	
	@GetMapping("/register")
	public String showForm(@ModelAttribute Student st) {
		st.setSadd("hyd");
		return "student_form";
	}
	
	/*@PostMapping("/register")
	public String processForm(@ModelAttribute("stFrm") Student st,Map<String,Object> map) {
		
		return "result";
	}*/
	
	
	@PostMapping("/register")
	public String processForm(@ModelAttribute Student st,Map<String,Object> map) {
		
		return "result";
	}
	
	/*@GetMapping("/links")
	public String processForm(Map<String,Object> map,@RequestParam("sno") int no,
			                                         @RequestParam("sname") String sname ) {
		return "show_param";
	}*/
	
	@GetMapping("/links")
	public String processForm(Map<String,Object> map,@RequestParam String sadd,
			                                         @RequestParam(required=false) Integer sno,
			                                         @RequestParam(required=false) String sname
			                                         ) {
		return "show_param";
	}
	
}
