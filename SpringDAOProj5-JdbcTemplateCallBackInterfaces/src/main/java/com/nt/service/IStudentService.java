package com.nt.service;

import java.util.List;

import com.nt.dto.StudentDTO;

public interface IStudentService {
	
    public StudentDTO fetchStudentByNo(int sno);
    public List<StudentDTO> fetchStudentsByCities(String city1,String city2,String city3);
    public List<StudentDTO> fetchStudentsByCities1(String city1,String city2,String city3);
}
