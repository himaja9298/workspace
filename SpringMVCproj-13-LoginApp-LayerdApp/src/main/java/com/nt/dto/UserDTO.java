package com.nt.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class UserDTO implements Serializable {
    
	private String uname;
	private String pwd;

}
