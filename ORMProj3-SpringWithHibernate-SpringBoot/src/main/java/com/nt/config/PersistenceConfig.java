package com.nt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nt.entity.Project;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {

@Autowired
private DataSource hkds; 

@Bean(name="sesfact")
public  LocalSessionFactoryBean createLocalSesfactBean() {
	LocalSessionFactoryBean bean=null;
	Properties props=null;
	bean=new LocalSessionFactoryBean();
	System.out.println(hkds.getClass());
   bean.setDataSource(hkds);
   bean.setAnnotatedClasses(Project.class);
   props=new Properties();
   props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
   props.setProperty("hibernate.hbm2ddl.auto","update");
   props.setProperty("hibernate.show_sql", "true");
   bean.setHibernateProperties(props);
   return bean;
 }
//hibernateTemplate class
@Bean(name="ht")
public HibernateTemplate createHT() {
	return new HibernateTemplate(createLocalSesfactBean().getObject()); 
}

}