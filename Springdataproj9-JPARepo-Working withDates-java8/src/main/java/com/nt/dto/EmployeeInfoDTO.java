package com.nt.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
	private LocalDateTime dob;
	private LocalDate doj;
	private LocalTime batchTime;


}
