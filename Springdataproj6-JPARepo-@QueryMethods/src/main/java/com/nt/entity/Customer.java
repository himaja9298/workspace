package com.nt.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import org.hibernate.annotations.Type;

@Entity
@NamedStoredProcedureQuery(procedureName="GET_CUSTOPMER_COUNT_BY_ADDRS", name = "getCustomersByAddrs",parameters= {@StoredProcedureParameter(mode=ParameterMode.IN,name="addrs",type=String.class),
	                                                                                                               @StoredProcedureParameter(mode=ParameterMode.OUT,name ="cnt",type=Integer.class)})


public class Customer implements Serializable {
	public Customer() {
		System.out.println("Customer:: 0-param constructor");
	}
	
		@Id
		@Type(type="int")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer cno;
		
		@Column(length=15)
		@Type(type="string")
		private String cname;
		
		@Column(length=15)
		@Type(type="string")
		private String cadd;
		
		@Type(type="double")
		private  Double billAmt;

		public Integer getCno() {
			return cno;
		}
		
		public void setCno(Integer cno) {
			this.cno = cno;
		}
		
		public String getCname() {
			return cname;
		}
		
		public void setCname(String cname) {
			this.cname = cname;
		}
		
		public String getCadd() {
			return cadd;
		}
		
		public void setCadd(String cadd) {
			this.cadd = cadd;
		}
		
		public Double getBillAmt() {
			return billAmt;
		}
		
		public void setBillAmt(Double billAmt) {
			this.billAmt = billAmt;
		}

		@Override
		public String toString() {
			return "Customer [cno=" + cno + ", cname=" + cname + ", cadd=" + cadd + ", billAmt=" + billAmt + "]";
		}
		
		
		
		
		
		

	}

