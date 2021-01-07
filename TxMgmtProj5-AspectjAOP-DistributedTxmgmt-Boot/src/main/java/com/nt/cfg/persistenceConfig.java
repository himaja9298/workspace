package com.nt.cfg;

import java.util.Properties;

import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class persistenceConfig {
	// create MySql database1 DataSource
	@Bean(name = "mysqlXADs1")
	public AtomikosDataSourceBean createMysqlXADS1() {
		AtomikosDataSourceBean ds = null;
		Properties props = null;
		ds = new AtomikosDataSourceBean();
		ds.setUniqueResourceName("mysqXA1");
		ds.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
		props = new Properties();
		props.setProperty("databaseName", "mydata");
		props.setProperty("URL", "jdbc:mysql://localhost:3306/mydata");
		props.setProperty("user", "root");
		props.setProperty("password", "root");
		ds.setXaProperties(props);
		return ds;
	}

	// create MySql database2 DataSource
	@Bean(name = "mysqlXADs2")
	public AtomikosDataSourceBean createMysqlXADS2() {
		AtomikosDataSourceBean ds = null;
		Properties props = null;
		ds = new AtomikosDataSourceBean();
		ds.setUniqueResourceName("mysqXA2");
		ds.setXaDataSourceClassName("com.mysql.cj.jdbc.MysqlXADataSource");
		props = new Properties();
		props.setProperty("databaseName", "mydata");
		props.setProperty("URL", "jdbc:mysql://localhost:3306/mydata1");
		props.setProperty("user", "root");
		props.setProperty("password", "root");
		ds.setXaProperties(props);
		return ds;
	}

	// create JdbcTemplate1
	@Bean(name = "mysql1jt")
	public JdbcTemplate createJt1() {
		return new JdbcTemplate(createMysqlXADS1());
	}

	// create JdbcTemplate2
	@Bean(name = "mysql2jt")
	public JdbcTemplate createJt2() {
		return new JdbcTemplate(createMysqlXADS2());
	}
}
