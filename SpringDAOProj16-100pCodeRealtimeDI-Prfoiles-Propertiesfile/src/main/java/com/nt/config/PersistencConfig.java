package com.nt.config;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource("com/nt/commons/jdbc.properties")
public class PersistencConfig {
    @Autowired
	private Environment env;
	
    // c3p0 DataSource configuration
	@Bean
	@Profile("dev")
	public DataSource createC3p0DsMysql() throws Exception {
		ComboPooledDataSource cds = new ComboPooledDataSource();
		cds.setDriverClass(env.getRequiredProperty("jdbc.mysql.driverclass"));
		cds.setJdbcUrl(env.getRequiredProperty("jdbc.mysql.url"));
		cds.setUser(env.getRequiredProperty("jdbc.mysql.usename"));
		cds.setPassword(env.getRequiredProperty("jdbc.mysql.pwd"));
		return cds;
	}

	// apacheDBCP2 DataSource configuration
	@Bean
	@Profile("test")
	public DataSource createApacheDBCP2Mysql() {
		BasicDataSource ads = new BasicDataSource();
		ads.setDriverClassName( env.getRequiredProperty("jdbc.mysql.driverclass"));
		ads.setUrl(env.getRequiredProperty("jdbc.mysql.url"));
		ads.setUsername(env.getRequiredProperty("jdbc.mysql.usename"));
		ads.setPassword(env.getRequiredProperty("jdbc.mysql.pwd"));
		return ads;
	}

	// apacheDBCP2 DataSource configuration
	@Bean
	@Profile("uat")
	public DataSource createApacheDBCP2MysqlMysql1() {
		BasicDataSource ads = new BasicDataSource();
		ads.setDriverClassName(env.getRequiredProperty("jdbc.mysql1.driverclass"));
		ads.setUrl(env.getRequiredProperty("jdbc.mysql1.url"));
		ads.setUsername(env.getRequiredProperty("jdbc.mysql1.usename"));
		ads.setPassword(env.getRequiredProperty("jdbc.mysql1.pwd"));
		return ads;
	}

	// hikari DataSource configuration
	@Bean
	@Profile("prod")
	public DataSource createHKDS() {
		HikariDataSource hkds = new HikariDataSource();
		hkds.setDriverClassName(env.getRequiredProperty("jdbc.mysql1.driverclass"));
		hkds.setJdbcUrl(env.getRequiredProperty("jdbc.mysql1.url"));
		hkds.setUsername(env.getRequiredProperty("jdbc.mysql1.usename"));
		hkds.setPassword(env.getRequiredProperty("jdbc.mysql1.pwd"));
		System.out.println(hkds);
		return hkds;
	}

	
	//JdbcTemplate for uat profile
			@Bean(autowire =Autowire.BY_TYPE)
			@Autowired
			public JdbcTemplate createJt() throws Exception {
				return new JdbcTemplate();
			}
	// JdbcTemplate for dev profile
	/*@Bean
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
		}*/


}
