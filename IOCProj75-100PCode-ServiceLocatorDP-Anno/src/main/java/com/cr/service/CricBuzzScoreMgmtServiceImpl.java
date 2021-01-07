package com.cr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipl.external.IIPLScoreComp;
@Service("service")
public class CricBuzzScoreMgmtServiceImpl implements ICricBuzzScoreMgmtService {
	@Autowired
	private IIPLScoreComp extcomp;
	

	@Override
	public String fetchScore(int mid) {
		return extcomp.getScore(mid);
	}

}
