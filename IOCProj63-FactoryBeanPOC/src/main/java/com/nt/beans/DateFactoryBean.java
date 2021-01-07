package com.nt.beans;

import java.time.LocalDate;

import org.springframework.beans.factory.FactoryBean;

public class DateFactoryBean implements FactoryBean<LocalDate> {
    private int year;
    private int month;
    private int day;
	public DateFactoryBean(int year, int month, int day) {
		System.out.println("DateFactoryBean.DateFactoryBean()");
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public LocalDate getObject() throws Exception {
		System.out.println("DateFactoryBean.getObject()");
		return LocalDate.of(year, month, day);
	}

	@Override
	public Class<?> getObjectType() {
		System.out.println("DateFactoryBean.getObjectType()");
		return LocalDate.class;
	}
	
	public boolean isSingletone() {
		System.out.println("DateFactoryBean.isSingletone()");
		return false;
		
	}

}
