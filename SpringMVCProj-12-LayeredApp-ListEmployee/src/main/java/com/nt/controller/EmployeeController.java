package com.nt.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.dto.EmployeeDTO;
import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validator.EmployeeValidator;

@Controller
public class EmployeeController {
	@Autowired
	private IEmployeeMgmtService service;

	@Autowired
	private EmployeeValidator validator;

	@RequestMapping("/welcome.htm")
	public String processData(Model model) {
		return "home";
	}

	@RequestMapping("/display.htm")
	public String displayEmployee(Model model) {
		List<EmployeeDTO> listdto = null;
		// use service
		listdto = service.fetchAllEmployee();
		model.addAttribute("listDTO", listdto);
		return "show_result";

	}

	@GetMapping("/saveEmp.htm")
	public String saveEmployee(@ModelAttribute("empFrm") Employee emp) {
		return "employee_register";
	}

	@PostMapping("/saveEmp.htm")
	public String registerEmployee(RedirectAttributes map, @ModelAttribute("empFrm") Employee emp,
			BindingResult errors) {
		EmployeeDTO dto = null;
		String result = null;
		if (emp.getVflag().equalsIgnoreCase("no")) {
			// perform form validations
			if (validator.supports(emp.getClass())) {
				validator.validate(emp, errors);
			}
		}
		// business logic or application logic errors
				if (emp.getDesg().equalsIgnoreCase("actor")) {
					errors.rejectValue("desg", "blocked.jobs");
				}
		// if form validation errors are their show form page
		if (errors.hasErrors()) {
			return "employee_register";
		}

		// copy properties from model object to dto
		dto = new EmployeeDTO();
		// BeanUtils.copyProperties(emp, dto);
		dto.setEname(emp.getEname());
		dto.setDesg(emp.getDesg());
		dto.setSalary(emp.getSalary());
		dto.setDeptno(emp.getDeptno());
		// use service
		result = service.registerEmployee(dto);
		List<EmployeeDTO> listdto = service.fetchAllEmployee();
		map.addFlashAttribute("resultMsg", result);
		return "redirect:display.htm";
	}

	@ModelAttribute("deptInfo")
	public List<Integer> populateDeptnos() {
		return service.fetchAllDeptnos();
	}

	@GetMapping("/deleteEmp.htm")
	public String deleteEmployee(@RequestParam int eno, RedirectAttributes map) {
		String result;
		// use service
		result = service.removeEmployee(eno);
		map.addFlashAttribute("resultMsg", result);
		return "redirect:display.htm";

	}

	@GetMapping("/editEmp.htm")
	public String showEditFormPage(@ModelAttribute Employee emp, @RequestParam int eno) {

		EmployeeDTO dto = null;
		// use service
		dto = service.fetchEmployeeById(eno);
		// convert dto to model
		BeanUtils.copyProperties(dto, emp);
		// return lvn
		return "employee_edit";
	}

	@PostMapping("/editEmp.htm")
	public String updateEmployee(@ModelAttribute Employee employee, BindingResult errors, RedirectAttributes redirect) {
		EmployeeDTO dto = null;
		String result = null;
		if (employee.getVflag().equalsIgnoreCase("no")) {
			// perform form validations
			if (validator.supports(employee.getClass())) {
				validator.validate(employee, errors);
			}
		}
		// business logic or application logic errors
		if (employee.getDesg().equalsIgnoreCase("actor")) {
			errors.rejectValue("desg", "blocked.jobs");
		}
		// if form validation errors are their show form page
		if (errors.hasErrors()) {
			return "employee_edit";
		}

		// convert mode to dto
		dto = new EmployeeDTO();
		System.out.println(employee);
		BeanUtils.copyProperties(employee, dto);
		// use service
		result = service.ModifyEmployee(dto);
		// add to flash attribute
		redirect.addFlashAttribute("resultMsg", result);
		// perform redirection
		return "redirect:display.htm";
	}
}
