package com.example.demo.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Getter
@Setter
public class Config {


	@Value( "${urlpage}" )
	private String appUrl;

	@Value( "${headless}" )
	private boolean headless;

	@Value( "${password}" )
	private String password;

	@Value( "${browser}" )
	private String browser;

	@Value( "${waittimeoutSeconds}" )
	private int waittimeoutSeconds;



}
