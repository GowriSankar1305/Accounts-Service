package com.mybank.accounts.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "person")
public class ExternalConfig {
	
	private String name;
	private String email;
	private String mobile;
	private String gender;
}
