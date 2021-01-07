package com.nt.service;

import com.nt.bo.CustomerBO;
import com.nt.dao.CustomerDAO;
import com.nt.dto.CustomerDTO;

public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	private CustomerDAO dao;
	
	//1-param constructor
	public CustomerMgmtServiceImpl(CustomerDAO dao) {
		System.out.println("CustomerMgmtServiceImpl:1-param constructor)");
		this.dao = dao;
	}
    //calculate intrest amount
	@Override
	public String calculateIntrestAmount(CustomerDTO dto) throws Exception {
				float intrAmt=0.0f;
				int count=0;
			    CustomerBO bo=null;
				//calculate intrest amount
				intrAmt=(dto.getPamt()*dto.getRate()*dto.getTime())/100.0f;
				//return values to CustomerBO
				bo=new CustomerBO();
				bo.setCname(dto.getCname());
				bo.setCadd(dto.getCadd());
				bo.setPamt(dto.getPamt());
				bo.setIntramt(intrAmt);
				//insert BO class object to DTO
				count=dao.insert(bo);
				if(count==1)
					return " Customer Registration successed::Amt:"+dto.getPamt()+"intrest:"+intrAmt;
				
				else
					return " Customer Registration failedd::Amt:"+dto.getPamt()+"intrest:"+intrAmt;

	}

}
