package com.cr.service;

import com.ipl.external.IIPLScoreComp;

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
