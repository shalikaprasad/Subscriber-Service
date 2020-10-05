package com.fastdash.subscribers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EntityScan(basePackages = "com.fastdash.subscribers.models")
@EnableAuthorizationServer
@EnableResourceServer
public class SubscribersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscribersApplication.class, args);
	}

}
