package com.mihir.employee_service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {
	//depricated RestTemplate method
	//@Bean
	//public RestTemplate restTemplate() {
	//    return new RestTemplate();
	//}
	
	//Commented because using feignclient
	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}
}
