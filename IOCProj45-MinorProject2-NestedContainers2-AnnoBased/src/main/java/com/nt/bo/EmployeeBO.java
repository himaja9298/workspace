package com.nt.bo;

import java.util.Date;

import lombok.Data;

@Data
public class EmployeeBO {
  private Integer serialNo;
  private Integer eno;
  private String ename;
  private String desg;
  private Float sal;
  private Date dob;
  private Date doj;
}
