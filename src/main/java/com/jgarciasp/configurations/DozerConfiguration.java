package com.jgarciasp.configurations;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfiguration {

	@Bean
	public DozerBeanMapper dozer() {
		return new DozerBeanMapper();
	}
	
} // public class DozerConfiguration 
