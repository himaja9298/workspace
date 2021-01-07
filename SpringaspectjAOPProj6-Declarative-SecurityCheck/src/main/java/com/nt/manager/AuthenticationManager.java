package com.nt.manager;

import org.springframework.beans.BeanUtils;

import com.nt.bo.UsersBO;
import com.nt.dao.IAuthenticateDAO;
import com.nt.dto.UsersDTO;

public class AuthenticationManager {
	private IAuthenticateDAO dao;
	ThreadLocal<UsersDTO> tl=new ThreadLocal();
	//1-param constructor
	public AuthenticationManager(IAuthenticateDAO dao) {
		this.dao = dao;
	}
	
	//signIn()
	public void signIn(String uname,String pwd) {
		System.out.println("AuthenticationManager.signIn()");
		UsersDTO dto=new UsersDTO();
		dto.setUname(uname);
		dto.setPwd(pwd);
		tl.set(dto);
	}
	
	//signOut()
	public void signOut() {
		System.out.println("AuthenticationManager.signOut()");
		tl.remove();
	}
	
	//validation method
	public boolean validate() {
		System.out.println("AuthenticationManager.validate()");
		UsersDTO dto=tl.get();
		//copy properties from dto to bo 
		UsersBO bo=new UsersBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		return dao.authenticate(bo)==1?true:false;
		
		}
	

}
