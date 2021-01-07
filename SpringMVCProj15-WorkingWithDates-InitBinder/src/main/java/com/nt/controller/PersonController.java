package com.nt.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Person;

@Controller
public class PersonController {
	
	@GetMapping("/person")
	public String showForm(@ModelAttribute("perFrm") Person person) {
		return "show_form";
	}
	
	
	@PostMapping("/person")
	public String processForm(@ModelAttribute("perFrm") Person per,Map<String,Object> map) {
		System.out.println(per);
		return "person_success";
	}
	
	@InitBinder
	public void myInitBinder(ServletRequestDataBinder binder) {
		System.out.println("PersonController.myInitBinder()");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-dd-mm");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf, true) );
		
	}
	
	
	
	
	
	@ModelAttribute("gendersList")
   public List<String> populateGenders(){
	   List<String>gendersList=Arrays.asList("male","female");
	   return gendersList;
	   	}
	
	@ModelAttribute("hobbiesList")
	   public List<String> populateHobbies(){
		   List<String> hobbiesList=new ArrayList();
		   hobbiesList.addAll(Arrays.asList("sleeping","roaming","reading","playing","meditation"));
		   return hobbiesList;
	   }
	
	@ModelAttribute("qlfyList")
	   public List<String> populateQualifications(){
		   List<String> qlfyList=new ArrayList();
		   qlfyList.addAll(Arrays.asList("MCA","B.Tech","B.E","BCA","B.Sc"));
		   return qlfyList;
	   }
	
	@ModelAttribute("colorsList")
	   public List<String> populateColors(){
		   List<String> colorsList=new ArrayList();
		   colorsList.addAll(Arrays.asList("White","red","green","blue"));
		   return colorsList;
	   }
	
	
}
