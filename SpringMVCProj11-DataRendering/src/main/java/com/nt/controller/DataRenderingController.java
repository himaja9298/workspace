package com.nt.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.StudentDTO;

@Controller
public class DataRenderingController {

	@GetMapping("/welcome")
	public String processData(Model model) {
		System.out.println("DataRenderingController.processData()");
		System.out.println(model.getClass());
		model.addAttribute("wmsg","Welcome").addAttribute("sysdate",new Date());
		return "display";
	}
	
	/*@GetMapping("/welcome")
	public String processData(Map<String,Object> map) {
		System.out.println("DataRenderingController.processData()");
		System.out.println(map.getClass());
		map.put("wmsg","Welcome");
		System.out.println(map.size());
		return "display";
	}*/
	
	/*@GetMapping("/welcome")
	public String processData(ModelMap map) {
		System.out.println("DataRenderingController.processData()");
		System.out.println(map.getClass());
		//map.addAttribute("wmsg","Welcome");
		map.put("wmsg", "Welcome");
		System.out.println(map.size());
		return "display";
	}*/
	
	/*@GetMapping("/welcome")
	  public String processData(Model model) {
		System.out.println("DataRenderingController.processData()");
		System.out.println(model.getClass());
		//array type data
		String names[]=new String[]{"raja","rani","ramana"};
		//List type data
		List<String> fruits=Arrays.asList("mango","banana","orange");
		//Set type data
		Set<Long>phonenums=new HashSet();
		phonenums.addAll((Arrays.asList(new Long[] { 1234L,12345L,1345L})));
		//Map type data
		Map<String,Integer> agemap=new HashMap();
		agemap.put("rani",25 );
		agemap.put("ravan",26 );
		agemap.put("malati",30 );
		//model.addAttribute("wmsg","Welcome");
		model.addAttribute("namesInfo",names);
		model.addAttribute("fruitsInfo",fruits);
		model.addAttribute("phonenumsInfo",phonenums);
		model.addAttribute("ageInfo",agemap);
		return "display";
	}*/
	 
	/* @RequestMapping("/welcome")
	 public String processData(Model model) {
		 List<StudentDTO>studdto=Arrays.asList(new StudentDTO(101,"raja","hyd"),
				                               new StudentDTO(102,"ramesh","delhi"),
				                               new StudentDTO(103,"naresh","kolkata"));
		 model.addAttribute("StudDTO",studdto);
		 return "display";
	 }*/
} 
