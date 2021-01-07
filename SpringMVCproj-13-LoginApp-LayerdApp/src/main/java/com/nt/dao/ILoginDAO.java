package com.nt.dao;

import java.util.Map;

import com.nt.bo.UserBO;

public interface ILoginDAO {
	public String authenticate(UserBO bo);

}
