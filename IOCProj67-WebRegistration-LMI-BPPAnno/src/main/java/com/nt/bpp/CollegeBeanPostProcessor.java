package com.nt.bpp;

import java.time.LocalDateTime;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.nt.bo.BaseBean;

public class CollegeBeanPostProcessor implements BeanPostProcessor {
	public CollegeBeanPostProcessor() {
		System.out.println("CollegeBeanPostProcessor.0-param constructor");
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof BaseBean)
		   ((BaseBean) bean).setDoj(LocalDateTime.now());
		System.out.println(bean);
		return bean;
	}

}
