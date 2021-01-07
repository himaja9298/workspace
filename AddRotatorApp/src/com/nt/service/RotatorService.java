package com.nt.service;

import java.util.Random;

public class RotatorService {
	private String images[]= new String[] {"images/arvind.jpg","images/raymonds.jpg","images/siyarams.jpg","images/vimal.jpg"};
	private String links[]=new String[] {"http://www.arvind.in/","http://www.raymonds.com/","http://www.siyarams.in/","http://www.vimal.com/"};
	private int counter=0;
	public void nextAdvertisement() {
		counter=new Random().nextInt(4);
	}
	public String getLink() {
		return links[counter];
	}
	public String getImage() {
		return images[counter];
	}
}
