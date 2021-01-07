package com.nt.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource("com/nt/commons/jdbc.properties")
public class PersistenceConfig {
	@Autowired
	private Environment env;
	
	@Bean("hkDs")
	public HikariDataSource createDataSource() {
		HikariDataSource hkds=null;
		hkds=new HikariDataSource();
		hkds.setDriverClassName(env.getProperty("jdbc.driver"));
		hkds.setJdbcUrl(env.getProperty("jdbc.url"));
		hkds.setUsername(env.getProperty("jdbc.user"));
		hkds.setPassword(env.getProperty("jdbc.pwd"));
		hkds.setMinimumIdle(Integer.parseInt(env.getProperty("jdbc.hikari.minidle")));
		hkds.setMaximumPoolSize(Integer.parseInt(env.getProperty("jdbc.hikari.maxsize")));
		return hkds;
		
	}
	@Bean("jt")
	public JdbcTemplate createJt() {
		JdbcTemplate jt=null;
		jt=new JdbcTemplate(createDataSource());
		return jt;
	}

}
