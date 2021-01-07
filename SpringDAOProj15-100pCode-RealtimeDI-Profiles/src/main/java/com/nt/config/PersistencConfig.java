package com.nt.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistencConfig {

	// c3p0 DataSource configuration
	@Bean
	@Profile("dev")
	public DataSource createC3p0DsMysql() throws Exception {
		ComboPooledDataSource cds = new ComboPooledDataSource();
		cds.setDriverClass("com.mysql.cj.jdbc.Driver");
		cds.setJdbcUrl("jdbc:mysql://localhost:3306/mydata");
		cds.setUser("root");
		cds.setPassword("root");
		return cds;
	}

	// apacheDBCP2 DataSource configuration
	@Bean
	@Profile("test")
	public DataSource createApacheDBCP2Mysql() {
		BasicDataSource ads = new BasicDataSource();
		ads.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ads.setUrl("jdbc:mysql://localhost:3306/mydata");
		ads.setUsername("root");
		ads.setPassword("root");
		return ads;
	}

	// apacheDBCP2 DataSource configuration
	@Bean
	@Profile("uat")
	public DataSource createApacheDBCP2MysqlMysql1() {
		BasicDataSource ads = new BasicDataSource();
		ads.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ads.setUrl("jdbc:mysql://localhost:3306/mydata1");
		ads.setUsername("root");
		ads.setPassword("root");
		return ads;
	}

	// hikari DataSource configuration
	@Bean
	@Profile("prod")
	public DataSource createHKDS() {
		HikariDataSource hkds = new HikariDataSource();
		hkds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hkds.setJdbcUrl("jdbc:mysql://localhost:3306/mydata1");
		hkds.setUsername("root");
		hkds.setPassword("root");
		System.out.println(hkds);
		return hkds;
	}

	// JdbcTemplate for dev profile
	@Bean
	@Profile("dev")
	public JdbcTemplate createMysqljtC3p0() throws Exception {
		return new JdbcTemplate(createC3p0DsMysql());
	}

	// JdbcTemplate for test profile
	@Bean
	@Profile("test")
	public JdbcTemplate createMysqljtApacheDBCP() throws Exception {
		return new JdbcTemplate(createApacheDBCP2Mysql());
	}
	
	//JdbcTemplate for uat profile
	@Bean
	@Profile("uat")
	public JdbcTemplate createMysql1jtApacheDBCP() throws Exception {
		return new JdbcTemplate(createApacheDBCP2MysqlMysql1());
	}

	//JdbcTemplate for uat profile
		@Bean
		@Profile("prod")
		public JdbcTemplate createMysql1jtHikariCP() throws Exception {
			return new JdbcTemplate(createHKDS());
		}


}
