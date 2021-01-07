package com.nt.dao;


import java.util.List;

import com.nt.bo.StudentBO;

public interface IStudentDAO {
	public StudentBO getStudentByNo(int sno);
    public List<StudentBO> getStudentsByAddresses(String city1,String city2,String city3);
    public List<StudentBO> getStudentsByAddresses1(String city1,String city2,String city3);

}
