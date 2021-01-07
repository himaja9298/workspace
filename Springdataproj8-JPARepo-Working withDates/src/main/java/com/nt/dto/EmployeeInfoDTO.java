package com.nt.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class EmployeeInfoDTO {

	private Integer eno;
	private String ename;
	private String eadd;
	private Date dob;
	private LocalDate doj;
	private Date batchTime;


}
