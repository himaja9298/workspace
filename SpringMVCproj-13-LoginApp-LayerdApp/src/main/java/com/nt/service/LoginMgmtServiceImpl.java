package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.UserBO;
import com.nt.dao.ILoginDAO;
import com.nt.dto.UserDTO;

@Service("loginServcie")
public class LoginMgmtServiceImpl implements ILoginMgmtService {
    @Autowired
	private ILoginDAO dao;
	
	@Override
	public String login(UserDTO dto) {
		UserBO bo=new UserBO();
		//copy properties from dto to bo
		BeanUtils.copyProperties(dto, bo);
		//use dao
		String output=dao.authenticate(bo);
		System.out.println(output);
		return output;
	}

}
