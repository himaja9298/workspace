package com.nt.service;

import com.nt.bo.CricketerBO;
import com.nt.dao.CricketerDAO;
import com.nt.dto.CricketerDTO;

public class CricketerMgmtServiceImpl implements CricketerMgmtService {
	private CricketerDAO dao;
	
	//1-param constructor
	public CricketerMgmtServiceImpl(CricketerDAO dao) {
		System.out.println("CricketerMgmtServiceImpl:1-param constructor)");
		this.dao = dao;
	}
    //calculate intrest amount
	@Override
	public String calculateBtAndBwavg(CricketerDTO dto) throws Exception {
				float btavg=0.0f;
				float bwavg=0.0f;
				int count=0;
			    CricketerBO bo=null;
				//calculate intrest amount
				btavg=dto.getRuns()/(dto.getInnings()-dto.getNotouts());
				bwavg=dto.getRuns()/dto.getWickets();
				//return values to CustomerBO
				bo=new CricketerBO();
				bo.setCname(dto.getCname());
				bo.setCountry(dto.getCountry());
				
				bo.setBtavg(btavg);
				bo.setBwavg(bwavg);
				//insert BO class object to DTO
				count=dao.insert(bo);
				if(count==1)
					return " Cricketer Registration successed::Batting avg:"+btavg+"::Bowling avg:"+bwavg;
				
				else
					return " Customer Registration failedd::Batting avg:"+btavg+"::Bowling avg:"+bwavg;

	}
	

}
