package com.automatodev.sendrequestjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SendRequestJavaApplication {

	
	/** 
	 * @uthor Marco Aurelio
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SendRequestJavaApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate() {
    return new RestTemplate();
}
}
