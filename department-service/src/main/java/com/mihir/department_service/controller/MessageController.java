package com.mihir.department_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//This manual refresh is not good if we have more microservice 
//to solve this problem we can use Spring Cloud Bus
@RefreshScope
@RestController
public class MessageController {
	
	@Value("${spring.boot.message}")
	private String message;
	
	@GetMapping("/message")
	public String  message() {
		return message;
	}
}
