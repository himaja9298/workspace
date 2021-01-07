package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.model.Employee;
@Component("validator")
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee emp=null;
		emp=(Employee) target;
		System.out.println(emp);
		if(emp.getEname()==null||emp.getEname().isEmpty()) {
			errors.rejectValue("ename", "emp.ename.required");
		}
		else if(emp.getEname().length()<5||emp.getEname().length()>15) {
			errors.rejectValue("ename", "emp.ename.length");
		}
		if(emp.getDesg()==null||emp.getDesg().isEmpty()) {
			errors.rejectValue("desg", "emp.desg.required");
		}
		else if(emp.getDesg().length()<5||emp.getDesg().length()>15) {
			errors.rejectValue("desg", "emp.desg.length");
		}
		
		if(emp.getSalary()==null) {
			errors.rejectValue("salary", "emp.salary.required");
			
		}
		else if(emp.getSalary()<1000||emp.getSalary()>100000) {
			errors.rejectValue("salary", "emp.salary.length");
		}
		
		// type mismatch errors
		else if (emp.getSalary().isNaN()) {
			errors.rejectValue("salary", "typemismatch.salary");

		}

		
	}

}
