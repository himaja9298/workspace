package com.nt.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nt.dto.StudentDTO;
@Component("studService")
public class StudentServiceImpl implements IStudentService {

	@Override
	public List<StudentDTO> getAllStudents() {
		List<StudentDTO>listdto=Arrays.asList(new StudentDTO(101,"mohan","hyd"),
				                              new StudentDTO(102,"karesh","mumbai"),
				                              new StudentDTO(103,",madhavi","kolkatta")); 
		return listdto;
	}

}
