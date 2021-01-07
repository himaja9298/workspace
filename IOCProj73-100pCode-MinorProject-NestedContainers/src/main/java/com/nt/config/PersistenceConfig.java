package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan("com.nt.dao")
public class PersistenceConfig {

	// create DataSource class object
		@Bean(name="hkds")
		public DataSource createDataSouce() {
			HikariDataSource hkds = null;
			hkds = new HikariDataSource();
			hkds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			hkds.setJdbcUrl("jdbc:mysql://localhost:3306/mydata");
			hkds.setUsername("root");
			hkds.setPassword("root");
			hkds.setMinimumIdle(10);
			hkds.setMaximumPoolSize(100);
			return hkds;
		}
}
