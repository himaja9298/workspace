package com.cr.service;

import org.springframework.stereotype.Service;

import com.ipl.external.IIPLScoreComp;
@Service("service")
public class CricBuzzScoreMgmtServiceImpl implements ICricBuzzScoreMgmtService {
	private IIPLScoreComp extcomp;
	
	
	public CricBuzzScoreMgmtServiceImpl(IIPLScoreComp extcomp) {
		System.out.println("CricBuzzScoreMgmtServiceImpl:1-param constructor");
		this.extcomp = extcomp;
	}


	@Override
	public String fetchScore(int mid) {
		return extcomp.getScore(mid);
	}

}
