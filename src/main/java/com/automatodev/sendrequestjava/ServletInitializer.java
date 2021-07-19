package com.automatodev.sendrequestjava;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	
	/** 
	 * @author Marco Aurélio
	 * @param application
	 * @return SpringApplicationBuilder
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SendRequestJavaApplication.class);
	}

}
