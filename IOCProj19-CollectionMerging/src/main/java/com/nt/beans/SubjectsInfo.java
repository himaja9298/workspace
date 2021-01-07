package com.nt.beans;

import java.util.Set;

public class SubjectsInfo {
	private Set<String> subjects;
    //setter method
	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}
	//toString()
	@Override
	public String toString() {
		return "SubjectsInfo [subjects=" + subjects + "]";
	}
	
	

}
