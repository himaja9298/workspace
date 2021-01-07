package com.nt.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class EmployeeDTO implements Serializable{
  private Integer serialNo;
  private Integer eno;
  private String ename;
  private Float sal;
  private String desg;
  private Date dob;
  private Date doj;
}
