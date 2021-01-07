package com.nt.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.ILocaleService;

@Controller
public class LocaleController {
	@Autowired
	private ILocaleService service;
	
	
	@GetMapping("/welcome")
	public String showHome() {
		return "home";
	}
	
		
	@GetMapping("/locale")
	  public String fetchLocaleDetails(Map<String,Object> map) {
		Set<String>countries=null;
		Set<String>languages=null;
		countries=service.getAllCountries();
		languages=service.getAllCountriesLanguages();
		map.put("countries", countries);
		map.put("languages",languages);
		map.put("operation", "Countries&LanguagesInfo");
		map.put("CountriesCount",countries.size() );
		map.put("languagesCount",languages.size() );
		//logical view name
		return "result";
	}
	
}


