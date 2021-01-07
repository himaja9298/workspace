package com.nt.beans;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

public class PersonInfo {
	private long aadharno;
	private String name;
	private Date date;
	private String[] addrs;
	private float salary;
	private File photoPath;
	private Currency countryCurrency;
	private Class javaClass;
	private Class[] javaClasses;
	private InputStream inputFile;
	private URL fburl;
	private Locale currentLocale;
	private TimeZone timeZone;
	private Properties props;
	
	//setters
	public void setAadharno(long aadharno) {
		this.aadharno = aadharno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setAddrs(String[] addrs) {
		this.addrs = addrs;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public void setPhotoPath(File photoPath) {
		this.photoPath = photoPath;
	}
	public void setCountryCurrency(Currency countryCurrency) {
		this.countryCurrency = countryCurrency;
	}
	public void setJavaClass(Class javaClass) {
		this.javaClass = javaClass;
	}
	public void setJavaClasses(Class[] javaClasses) {
		this.javaClasses = javaClasses;
	}
	public void setInputFile(InputStream inputFile) {
		this.inputFile = inputFile;
	}
	public void setFburl(URL fburl) {
		this.fburl = fburl;
	}
	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
	}
	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}
	public void setProps(Properties props) {
		this.props = props;
	}
	
	
	//toString()
	@Override
	public String toString() {
		return "PersonInfo [aadharno=" + aadharno + ", name=" + name + ", date=" + date + ", addrs="
				+ Arrays.toString(addrs) + ", salary=" + salary + ", photoPath=" + photoPath + ", countryCurrency="
				+ countryCurrency + ", javaClass=" + javaClass + ", javaClasses=" + Arrays.toString(javaClasses)
				+ ", inputFile=" + inputFile + ", fburl=" + fburl + ", currentLocale=" + currentLocale + ", timeZone="
				+ timeZone + ", props=" + props + "]";
	}
	
	
	

}
