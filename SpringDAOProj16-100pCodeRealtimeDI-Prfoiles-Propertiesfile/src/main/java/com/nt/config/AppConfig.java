package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value={SeviceConfig.class,ControllerConfig.class,PersistencConfig.class})
public class AppConfig {

}
