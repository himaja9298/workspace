package com.nt.beans;

public class Properties1 {
	private String osName;
	private String path;
	
	//setters and getters
	public void setOsName(String osName) {
		this.osName = osName;
	}
	public void setPath(String path) {
		this.path = path;
	}
	//toString()
	@Override
	public String toString() {
		return "Properties [osName=" + osName + ", path=" + path + "]";
	}
}
