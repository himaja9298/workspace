package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.DAO")
public class PersistenceConfig {
	//declare hkds as bean
  @Bean(name="hkds")
  //create DataSource
  public DataSource createDs() {
	HikariDataSource hkds=null; 
	hkds=new HikariDataSource();
	hkds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	hkds.setJdbcUrl("jdbc:mysql://localhost:3306/mydata");
	hkds.setUsername("root");
    hkds.setPassword("root");
    hkds.setMaximumPoolSize(20);
    hkds.setMinimumIdle(10);
    return hkds;
  }//createDs
  
@Bean(name="jt")
public JdbcTemplate createJT() {
	   return new JdbcTemplate(createDs());
   }//createJt


}

