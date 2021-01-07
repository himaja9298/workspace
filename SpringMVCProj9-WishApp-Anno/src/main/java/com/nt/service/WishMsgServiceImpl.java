package com.nt.service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("wishService")
public class WishMsgServiceImpl implements IWishMsgService {

	@Override
	public String getWishMessage() {
		Calendar cal=null;
		int hour=0;
		hour=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(hour<12)
			return "Good Morning";
		else if(hour<15)
			return "Good Afternoon";
		else if(hour<20)
			return "Good Evening";
		else
			return "Good Night";
		
	}

}
