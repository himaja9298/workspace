package com.nt.cfg;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class persistenceConfig {
	// create MySql database1 DataSource
	@Bean(name = "mysqlXADs1")
	@ConfigurationProperties(prefix="dx.mysql1")
	public AtomikosDataSourceBean createMysqlXADS1() {
		AtomikosDataSourceBean ds = null;
		ds = new AtomikosDataSourceBean();
		return ds;
	}

	// create MySql database2 DataSource
	@Bean(name = "mysqlXADs2")
	@ConfigurationProperties(prefix="dx.mysql2")
	public AtomikosDataSourceBean createMysqlXADS2() {
		AtomikosDataSourceBean ds = null;
		ds = new AtomikosDataSourceBean();
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
