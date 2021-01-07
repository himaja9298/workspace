package com.nt.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class CoronaDTO implements Serializable{
  private Integer serialNo;
  private Integer patno;
  private String patname;
  private Float patbill;
  private String patadd;
  private Integer patstage;
}
