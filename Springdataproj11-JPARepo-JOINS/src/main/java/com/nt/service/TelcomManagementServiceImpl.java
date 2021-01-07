package com.nt.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.UserDTO;
import com.nt.entity.User;
import com.nt.repo.UserRepo;

@Service("tmService")
public class TelcomManagementServiceImpl implements TelcomManagementService {
	@Autowired
	  private  UserRepo userRepo;

	@Override
	public List<Object[]> getDataByJoins(){
	  return userRepo.fetchDataByJoins();
	}

	
			 
	

}