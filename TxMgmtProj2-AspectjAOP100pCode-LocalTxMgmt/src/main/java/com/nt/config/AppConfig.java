package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value= {ServiceConfig.class,AOPConfig.class,PersistenceConfig.class})
public class AppConfig {
	
}
