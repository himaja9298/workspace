package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.dto.StudentDTO;
import com.nt.service.IStudentService;

@Controller
public class PdfAndExcelController {
	@Autowired
	private IStudentService service;
	
    @GetMapping("/home") 
	public String showHome() {
		return "result";
	}
    
    @GetMapping("/excelview") 
	public String showinExcel(Map<String,Object> map) {
    	List<StudentDTO> listdto=service.getAllStudents();
    	//keep in modelAttribute
    	map.put("StudentSList", listdto);
		return "excelView";
	}
    
    @GetMapping("/pdfview") 
	public String showInPdf(Map<String,Object> map) {
    	List<StudentDTO> listdto=service.getAllStudents();
    	//keep in modelAttribute
    	map.put("StudentSList", listdto);
		return "pdfView";
	}
	 
}
