package com.nt.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nt.bo.CustomerBO;
import com.nt.dao.CustomerDAO;
import com.nt.dto.CustomerDTO;
//@Service("custservice")
@Service("${jdbc.service}")
public class CustomerMgmtServiceImpl implements CustomerMgmtService {
	@Autowired
	private CustomerDAO dao;
	@Value("${cust.age}")
	private int age;
	
    //calculate intrest amount
	@Override
	public String calculateIntrestAmount(CustomerDTO dto) throws Exception {
				float intrAmt=0.0f;
				int count=0;
			    CustomerBO bo=null;
			    System.out.println("age:::"+age);
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
	//lifecycle init method
		public void myInit() {
			if (dao == null) {
				System.out.println("dao proprty not injected");
			}
		}
		
		//lifecycle destroy method
		public void myDestroy() {
			dao=null;
		}
		

}
