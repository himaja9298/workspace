package com.nt.dto;

import java.io.Serializable;
import java.util.Set;

import com.nt.entity.PhoneNumber;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString

public class UserDTO implements Serializable {
	private  Integer userId;
	private  String name;
	private  String addrs;
	private  Set<PhoneNumberDTO> phones;

}
