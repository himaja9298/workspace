package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.StudentBO;
import com.nt.dao.IStudentDAO;
import com.nt.dto.StudentDTO;

@Service("studService")
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDAO dao;

	@Override
	public StudentDTO fetchStudentByNo(int sno) {
		StudentBO bo=null;
		StudentDTO dto=null;
		//use dao
		bo=dao.getStudentByNo(sno);
		//copy properties from bo to dto
         dto=new StudentDTO();
         bo.setSno(sno);
         BeanUtils.copyProperties(bo, dto);
         return dto;
	}

	@Override
	public List<StudentDTO> fetchStudentsByCities(String city1, String city2, String city3) {
		List<StudentBO>listbo=null;
		List<StudentDTO>listdto=new ArrayList();;
		//use dao
		listbo=dao.getStudentsByAddresses(city1, city2, city3);
		//convert listbo to listdto
		listbo.forEach(bo->{
			
			StudentDTO dto=new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			if(bo.getAvg()>=75)
				dto.setGrade("FirstClass with Distinction");
			else if(bo.getAvg()>=60)
				dto.setGrade("FirstClass");
			else if(bo.getAvg()>=50)
				dto.setGrade("SecondClass");
			else if(bo.getAvg()>=35)
				dto.setGrade("Pass");
			else
				dto.setGrade("Fail");
			listdto.add(dto);
		});
		return listdto;
	}

	@Override
	public List<StudentDTO> fetchStudentsByCities1(String city1, String city2, String city3) {
		List<StudentBO>listbo=null;
		List<StudentDTO>listdto=new ArrayList();;
		//use dao
		listbo=dao.getStudentsByAddresses(city1, city2, city3);
		//convert listbo to listdto
		listbo.forEach(bo->{
			
			StudentDTO dto=new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			if(bo.getAvg()>=75)
				dto.setGrade("FirstClass with Distinction");
			else if(bo.getAvg()>=60)
				dto.setGrade("FirstClass");
			else if(bo.getAvg()>=50)
				dto.setGrade("SecondClass");
			else if(bo.getAvg()>=35)
				dto.setGrade("Pass");
			else
				dto.setGrade("Fail");
			listdto.add(dto);
		});
		return listdto;
	}
	
   }
