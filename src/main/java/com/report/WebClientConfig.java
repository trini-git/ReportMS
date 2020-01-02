package com.report;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	@Bean
	@Qualifier("bankFixedTermAccountVip")
	public WebClient bankFixedTermAccountVipWebClient() {
		return WebClient.create("http://localhost:8020/api/bankFixedTermAccountVip");
		
	}
	
	@Bean
	@Qualifier("creditCard")
	public WebClient creditCardWebClient() {
		return WebClient.create("http://localhost:8020/api/creditCard");
		
	}
}
