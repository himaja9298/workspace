package com.nt.model;

import org.springframework.web.multipart.MultipartFile;

public class JobSeekerInfo {
	private String name;
	private String addrs;
	private MultipartFile resume;
	private MultipartFile photo;
	
	//setters&getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public MultipartFile getResume() {
		return resume;
	}
	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	
}
