package com.nt.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString

public class PhoneNumberDTO implements  Serializable {
	private Long mobileNo;
	private String  type;
	private String provider;
}